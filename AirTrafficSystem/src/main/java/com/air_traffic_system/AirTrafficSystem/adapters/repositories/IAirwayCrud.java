package com.air_traffic_system.AirTrafficSystem.adapters.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.air_traffic_system.AirTrafficSystem.domain.models.Airway;

public interface IAirwayCrud extends CrudRepository<Airway, String> {
  List<Airway> findAll();
}
