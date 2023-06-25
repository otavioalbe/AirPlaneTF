package com.air_traffic_system.AirTrafficSystem.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.air_traffic_system.AirTrafficSystem.domain.models.Airplane;
import com.air_traffic_system.AirTrafficSystem.domain.repositories.IAirplaneRepository;

@Component
public class AirplaneService {
  public IAirplaneRepository airplaneRepository;

  @Autowired
  public AirplaneService(IAirplaneRepository airplaneRepository){
    this.airplaneRepository = airplaneRepository;
  }
  
  public List<Airplane> getAllAirplanes(){
    return airplaneRepository.getAll();
  }

  public boolean insertAirplane(Airplane airplane){
    return airplaneRepository.insert(airplane);
  }
}
