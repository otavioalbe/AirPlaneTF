package com.air_traffic_system.AirTrafficSystem.adapters.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.air_traffic_system.AirTrafficSystem.domain.models.Airplane;

public interface IAirplaneCrud extends CrudRepository<Airplane, String> {
  List<Airplane> findAll();
}
