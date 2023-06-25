package com.air_traffic_system.AirTrafficSystem.application.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.air_traffic_system.AirTrafficSystem.domain.models.Airplane;
import com.air_traffic_system.AirTrafficSystem.domain.services.AirplaneService;

@Component
public class InsertAirplanesUC {
  private AirplaneService airplaneService;

  @Autowired
  public InsertAirplanesUC(AirplaneService airplaneService) {
    this.airplaneService = airplaneService;
  }
  
  public boolean run(Airplane airplane) {
    return airplaneService.insertAirplane(airplane);
  }
}
