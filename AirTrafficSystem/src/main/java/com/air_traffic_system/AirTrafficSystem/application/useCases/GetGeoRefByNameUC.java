package com.air_traffic_system.AirTrafficSystem.application.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.air_traffic_system.AirTrafficSystem.domain.models.GeoRef;
import com.air_traffic_system.AirTrafficSystem.domain.services.AirwayService;

@Component
public class GetGeoRefByNameUC {
  private AirwayService airwayService;

  @Autowired
  public GetGeoRefByNameUC(AirwayService airwayService) {
    this.airwayService = airwayService;
  }
  
  public GeoRef run(String name) {
    return airwayService.getGeoRefByName(name);
  }
}
