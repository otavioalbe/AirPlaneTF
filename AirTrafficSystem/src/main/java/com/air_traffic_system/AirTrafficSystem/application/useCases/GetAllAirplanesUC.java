package com.air_traffic_system.AirTrafficSystem.application.useCases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.air_traffic_system.AirTrafficSystem.domain.models.Airplane;
import com.air_traffic_system.AirTrafficSystem.domain.services.AirplaneService;

@Component
public class GetAllAirplanesUC {
  private AirplaneService airplaneService;

  @Autowired
  public GetAllAirplanesUC(AirplaneService airplaneService) {
    this.airplaneService = airplaneService;
  }
  
  public List<Airplane> run() {
    return airplaneService.getAllAirplanes();
  }
}
