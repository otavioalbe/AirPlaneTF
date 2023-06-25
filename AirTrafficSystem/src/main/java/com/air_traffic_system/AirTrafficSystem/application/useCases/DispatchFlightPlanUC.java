package com.air_traffic_system.AirTrafficSystem.application.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.air_traffic_system.AirTrafficSystem.domain.services.FlightPlanService;

@Component
public class DispatchFlightPlanUC {
  private FlightPlanService flightPlanService;

  @Autowired
  public DispatchFlightPlanUC(FlightPlanService flightPlanService) {
    this.flightPlanService = flightPlanService;
  }
  
  public boolean run(int flightNumber, String geoRefFrom, String geoRefTo) {
    return flightPlanService.dispatchFlightPlan(flightNumber, geoRefFrom, geoRefTo);
  }
}
