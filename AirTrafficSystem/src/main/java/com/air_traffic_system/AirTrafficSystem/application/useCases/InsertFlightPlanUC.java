

package com.air_traffic_system.AirTrafficSystem.application.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.air_traffic_system.AirTrafficSystem.domain.models.FlightPlan;
import com.air_traffic_system.AirTrafficSystem.domain.services.AirplaneService;
import com.air_traffic_system.AirTrafficSystem.domain.services.FlightPlanService;

@Component
public class InsertFlightPlanUC {
  private FlightPlanService flightPlanService;

  @Autowired
  public void InsertFightPlanUC(FlightPlanService flightPlanService) {
    this.flightPlanService = flightPlanService;
  }
  
  public boolean run(FlightPlan flightPlan) {
    return flightPlanService.insertFightPlans(flightPlan);
  }
}
