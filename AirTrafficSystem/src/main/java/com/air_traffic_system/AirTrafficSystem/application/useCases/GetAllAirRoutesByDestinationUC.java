package com.air_traffic_system.AirTrafficSystem.application.useCases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.air_traffic_system.AirTrafficSystem.domain.models.AirRoute;
import com.air_traffic_system.AirTrafficSystem.domain.services.AirRouteService;

@Component
public class GetAllAirRoutesByDestinationUC {
  private AirRouteService airRouteService;

  @Autowired
  public GetAllAirRoutesByDestinationUC(AirRouteService airRouteService) {
    this.airRouteService = airRouteService;
  }
  
  public List<AirRoute> run(String geoRefFrom, String geoRefTo) {
    return airRouteService.getAllAirRoutesByDestination(geoRefFrom, geoRefTo);
  }
}
