package com.air_traffic_system.AirTrafficSystem.adapters.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.air_traffic_system.AirTrafficSystem.domain.models.Airplane;
import com.air_traffic_system.AirTrafficSystem.domain.repositories.IAirplaneRepository;

@Component
public class AirplaneRepository implements IAirplaneRepository {
  private IAirplaneCrud airplaneCrud;

  @Autowired
  public AirplaneRepository(IAirplaneCrud airplaneCrud) {
      this.airplaneCrud = airplaneCrud;
  }

  public List<Airplane> getAll() {
    List<Airplane> airplanes = airplaneCrud.findAll();
    return airplanes;
  }

  public boolean insert(Airplane airplane) {
    try {
      airplaneCrud.save(airplane);
    } catch (IllegalArgumentException ex) {
      return false;
    }

    return true;
  }
}
