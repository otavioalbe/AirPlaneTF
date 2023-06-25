package com.air_traffic_system.AirTrafficSystem.adapters.repositories;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.air_traffic_system.AirTrafficSystem.adapters.uils.AirTrafficHandler;
import com.air_traffic_system.AirTrafficSystem.application.dtos.AirwayFreeSlotDTO;
import com.air_traffic_system.AirTrafficSystem.application.dtos.AirwayReportDTO;
import com.air_traffic_system.AirTrafficSystem.application.dtos.IndividualAirwayDTO;
import com.air_traffic_system.AirTrafficSystem.domain.models.Airway;
import com.air_traffic_system.AirTrafficSystem.domain.models.AirwayOccupation;
import com.air_traffic_system.AirTrafficSystem.domain.models.GeoRef;
import com.air_traffic_system.AirTrafficSystem.domain.repositories.IAirwayRepository;

@Component
public class AirwayRepository implements IAirwayRepository {
  private IGeoRefCrud geoRefCrud;
  private IAirwayCrud airwayCrud;

  @Autowired
  public AirwayRepository(IGeoRefCrud geoRefCrud, IAirwayCrud airwayCrud) {
    this.geoRefCrud = geoRefCrud;
    this.airwayCrud = airwayCrud;
  }

  public List<AirwayFreeSlotDTO> getFreeSlots(Date date, Float cruisingSpeed, GeoRef from, GeoRef to) {
    double distance = AirTrafficHandler.calculateDistance(
      from.getLatitude(),
      to.getLatitude(),
      from.getLongitude(),
      to.getLongitude(),
      0,
      0);

    int hourSlots = (int) Math.ceil((distance / cruisingSpeed) * 60);
    int startHour = AirTrafficHandler.getHourOfDay(date);

    List<Airway> airways = airwayCrud
      .findAll()
      .stream()
      .filter(airway -> 
        airway.getFrom().getName().equals(from.getName()) && 
        airway.getFrom().getName().equals(to.getName()))
      .toList();

    List<AirwayFreeSlotDTO> airwayFreeSlots = new ArrayList<>();

    for (Airway airway : airways) {
      List<AirwayOccupation> airwayOccupations = airway
        .getAirwayOccupations()
        .stream()
        .filter(airwayOccupation -> 
          AirTrafficHandler.checkTimeInterval(AirTrafficHandler.getHourOfDay(airwayOccupation.getDate()), startHour, hourSlots) &&
          AirTrafficHandler.isSameDay(airwayOccupation.getDate(), date))
        .toList();
      
      for (int i = 25; i <= 35; i++) {
        final int altitude = i * 1000;
        boolean isOccupied = airwayOccupations.stream().anyMatch(airwayOccupation -> airwayOccupation.getAltitude() == altitude * 1000);
        
        if (!isOccupied) {
          for (int hour = 0; hour < hourSlots; hour++) {
            airwayFreeSlots.add(new AirwayFreeSlotDTO(startHour + hour, date, altitude * 1000, airway.getName()));
          }
        }
      }
    }
    
    return airwayFreeSlots;
  }

  public GeoRef getGeoRefByName(String name) {
    return geoRefCrud.findByName(name);
  }

  public AirwayReportDTO generateReport(String name, Date date) {
    AirwayReportDTO airwayReportDTO = new AirwayReportDTO();

    Airway airway = airwayCrud.findAll().stream().filter(aw -> aw.getName().equals(name)).findFirst().get();

    List<AirwayOccupation> airwayOccupations = airway
      .getAirwayOccupations()
      .stream()
      .filter(airwayOccupation -> AirTrafficHandler.isSameDay(airwayOccupation.getDate(), date))
      .toList();

    for (int i = 25; i <= 35; i++) {
      final int altitude = i * 1000;

      long occupationsCount = airwayOccupations.stream().filter(airwayOccupation -> airwayOccupation.getAltitude() == altitude * 1000).count();
      
      float occupationPercentage = 0;
      
      if (occupationsCount > 0) 
        occupationPercentage = (24 / occupationsCount) * 100;

      airwayReportDTO.addIndividualAirway(new IndividualAirwayDTO(altitude, occupationPercentage));
    }

    return airwayReportDTO;
  }
}
