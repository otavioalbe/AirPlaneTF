package com.air_traffic_system.AirTrafficSystem.adapters.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.air_traffic_system.AirTrafficSystem.domain.models.AirRoute;

public interface IAirRouteCrud extends CrudRepository<AirRoute, String> {
  List<AirRoute> findAll();
  AirRoute findByName(String name);
}
