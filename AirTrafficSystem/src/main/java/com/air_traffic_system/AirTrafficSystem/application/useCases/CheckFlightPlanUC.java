package com.air_traffic_system.AirTrafficSystem.application.useCases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.air_traffic_system.AirTrafficSystem.domain.models.AirwayOccupation;
import com.air_traffic_system.AirTrafficSystem.domain.services.FlightPlanService;

@Component
public class CheckFlightPlanUC {
  private FlightPlanService flightPlanService;

  @Autowired
  public CheckFlightPlanUC(FlightPlanService flightPlanService) {
    this.flightPlanService = flightPlanService;
  }
  
  public List<AirwayOccupation> run(int flightNumber, String geoRefFrom, String geoRefTo) {
    return flightPlanService.checkFlightPlan(flightNumber, geoRefFrom, geoRefTo);
  }
}
