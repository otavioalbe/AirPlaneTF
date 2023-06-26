
package com.air_traffic_system.AirTrafficSystem.application.useCases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.air_traffic_system.AirTrafficSystem.domain.models.Airplane;
import com.air_traffic_system.AirTrafficSystem.domain.models.FlightPlan;
import com.air_traffic_system.AirTrafficSystem.domain.services.AirplaneService;
import com.air_traffic_system.AirTrafficSystem.domain.services.FlightPlanService;

@Component
public class GetAllFightPlanUC {
  private static FlightPlanService flightPlanService;

  @Autowired
  public GetAllFightPlanUC(FlightPlanService flightPlanService) {
    this.flightPlanService = flightPlanService;
  }
  
  public static List<FlightPlan> run() {
    return flightPlanService.getAllFlightPlans();
  }
}
