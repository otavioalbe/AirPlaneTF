package com.air_traffic_system.AirTrafficSystem.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.air_traffic_system.AirTrafficSystem.domain.models.AirRoute;
import com.air_traffic_system.AirTrafficSystem.domain.models.GeoRef;
import com.air_traffic_system.AirTrafficSystem.domain.repositories.IAirRouteRepository;
import com.air_traffic_system.AirTrafficSystem.domain.repositories.IAirwayRepository;

@Component
public class AirRouteService {
  public IAirRouteRepository airRouteRepository;
  public IAirwayRepository airwayRepository;
  
  @Autowired
  public AirRouteService(IAirRouteRepository airRouteRepository, IAirwayRepository airwayRepository){
    this.airRouteRepository = airRouteRepository;
    this.airwayRepository = airwayRepository;
  }

  public List<AirRoute> getAllAirRoutesByDestination(String geoRefFrom, String geoRefTo){
    GeoRef from = airwayRepository.getGeoRefByName(geoRefFrom);
    GeoRef to = airwayRepository.getGeoRefByName(geoRefTo);

    return airRouteRepository.getAllByDestination(from, to);
  }
}
