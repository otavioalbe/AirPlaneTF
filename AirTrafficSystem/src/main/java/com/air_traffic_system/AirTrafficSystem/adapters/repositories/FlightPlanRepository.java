package com.air_traffic_system.AirTrafficSystem.adapters.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.air_traffic_system.AirTrafficSystem.adapters.uils.AirTrafficHandler;
import com.air_traffic_system.AirTrafficSystem.domain.models.Airway;
import com.air_traffic_system.AirTrafficSystem.domain.models.AirwayOccupation;
import com.air_traffic_system.AirTrafficSystem.domain.models.FlightPlan;
import com.air_traffic_system.AirTrafficSystem.domain.models.GeoRef;
import com.air_traffic_system.AirTrafficSystem.domain.repositories.IFlightPlanRepository;

@Component
public class FlightPlanRepository implements IFlightPlanRepository {
  private IFlightPlanCrud flightPlanCrud;
  private IAirwayOccupationCrud airwayOccupationCrud;

  @Autowired
  public FlightPlanRepository(IFlightPlanCrud flightPlanCrud, IAirwayOccupationCrud airwayOccupationCrud) {
    this.flightPlanCrud = flightPlanCrud;
    this.airwayOccupationCrud = airwayOccupationCrud;
  }

  public List<AirwayOccupation> check(int flightNumber, GeoRef from, GeoRef to) {
    List<AirwayOccupation> airwayOccupations = new ArrayList<>();

    FlightPlan flightPlan = flightPlanCrud.findByFlightNumber(flightNumber);

    if (flightPlan.getDispatched())
      return airwayOccupations;

    double distance = AirTrafficHandler.calculateDistance(
      from.getLatitude(),
      to.getLatitude(),
      from.getLongitude(),
      to.getLongitude(),
      0,
      0);

    int hourSlots = (int) Math.ceil((distance / flightPlan.getCruisingSpeed()) * 60);
    int startHour = AirTrafficHandler.getHourOfDay(flightPlan.getDate());

    List<Airway> airways = flightPlan
      .getAirRoute()
      .getAirways()
      .stream()
      .filter(airway -> 
        airway.getFrom().getName().equals(from.getName()) && 
        airway.getFrom().getName().equals(to.getName()))
      .toList();
      
    for (Airway airway : airways) {
      airwayOccupations.addAll(airway
        .getAirwayOccupations()
        .stream()
        .filter(airwayOccupation -> 
          AirTrafficHandler.checkTimeInterval(AirTrafficHandler.getHourOfDay(airwayOccupation.getDate()), startHour, hourSlots) &&
          airwayOccupation.getAltitude() == flightPlan.getAltitude())
        .toList());
    }
    
    return airwayOccupations;
  } 

  public boolean dispatch(int flightNumber, GeoRef from, GeoRef to) {
    try {
      FlightPlan flightPlan = flightPlanCrud.findByFlightNumber(flightNumber);

      if (!flightPlan.getDispatched()) {
        flightPlan.setDispatched(true);
        flightPlanCrud.save(flightPlan);

        double distance = AirTrafficHandler.calculateDistance(
          from.getLatitude(),
          to.getLatitude(),
          from.getLongitude(),
          to.getLongitude(),
          0,
          0);

        int hourSlots = (int) Math.ceil((distance / flightPlan.getCruisingSpeed()) * 60);

        Airway airway = flightPlan
          .getAirRoute()
          .getAirways()
          .stream()
          .filter(aw -> 
            aw.getFrom().getName().equals(from.getName()) && 
            aw.getFrom().getName().equals(to.getName()))
          .findFirst()
          .get();
      
        for (int hour = 0; hour < hourSlots; hour++)
          airwayOccupationCrud.save(new AirwayOccupation(AirTrafficHandler.addHour(flightPlan.getDate(), hour), flightPlan.getAltitude(), airway));
      }
    } catch (IllegalArgumentException ex) {
      return false;
    }

    return true;
  }

  public boolean cancel(int flightNumber, GeoRef from, GeoRef to) {
    try {
      FlightPlan flightPlan = flightPlanCrud.findByFlightNumber(flightNumber);
  
      if (flightPlan.getDispatched()) {
        flightPlan.setDispatched(false);
        flightPlanCrud.save(flightPlan);

        double distance = AirTrafficHandler.calculateDistance(
          from.getLatitude(),
          to.getLatitude(),
          from.getLongitude(),
          to.getLongitude(),
          0,
          0);

        int hourSlots = (int) Math.ceil((distance / flightPlan.getCruisingSpeed()) * 60);
        int startHour = AirTrafficHandler.getHourOfDay(flightPlan.getDate());

        for (Airway airway : flightPlan.getAirRoute().getAirways()) {
          List<AirwayOccupation> airwayOccupations = airway
            .getAirwayOccupations()
            .stream()
            .filter(airwayOccupation -> 
              AirTrafficHandler.checkTimeInterval(AirTrafficHandler.getHourOfDay(airwayOccupation.getDate()), startHour, hourSlots) &&
              AirTrafficHandler.isSameDay(airwayOccupation.getDate(), flightPlan.getDate()))
            .toList();
          
          airwayOccupationCrud.deleteAll(airwayOccupations);
        }
      }
    } catch (IllegalArgumentException ex) {
      return false;
    }

    return true;
  }
}
