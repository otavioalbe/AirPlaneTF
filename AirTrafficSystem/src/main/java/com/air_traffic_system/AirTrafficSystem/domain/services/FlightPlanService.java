package com.air_traffic_system.AirTrafficSystem.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.air_traffic_system.AirTrafficSystem.domain.models.AirwayOccupation;
import com.air_traffic_system.AirTrafficSystem.domain.models.GeoRef;
import com.air_traffic_system.AirTrafficSystem.domain.repositories.IAirwayRepository;
import com.air_traffic_system.AirTrafficSystem.domain.repositories.IFlightPlanRepository;

@Component
public class FlightPlanService {
  public IFlightPlanRepository flightPlanRepository;
  public IAirwayRepository airwayRepository;
  
  @Autowired
  public FlightPlanService(IFlightPlanRepository flightPlanRepository, IAirwayRepository airwayRepository){
    this.flightPlanRepository = flightPlanRepository;
    this.airwayRepository = airwayRepository;
  }

  public List<AirwayOccupation> checkFlightPlan(int flightNumber, String geoRefFrom, String geoRefTo){
    GeoRef from = airwayRepository.getGeoRefByName(geoRefFrom);
    GeoRef to = airwayRepository.getGeoRefByName(geoRefTo);

    return flightPlanRepository.check(flightNumber, from, to);
  }

  public boolean dispatchFlightPlan(int flightNumber, String geoRefFrom, String geoRefTo) {
    GeoRef from = airwayRepository.getGeoRefByName(geoRefFrom);
    GeoRef to = airwayRepository.getGeoRefByName(geoRefTo);

    return flightPlanRepository.dispatch(flightNumber, from, to);
  }

  public boolean cancelFlightPlan(int flightNumber, String geoRefFrom, String geoRefTo) {
    GeoRef from = airwayRepository.getGeoRefByName(geoRefFrom);
    GeoRef to = airwayRepository.getGeoRefByName(geoRefTo);

    return flightPlanRepository.cancel(flightNumber, from, to);
  }
}
