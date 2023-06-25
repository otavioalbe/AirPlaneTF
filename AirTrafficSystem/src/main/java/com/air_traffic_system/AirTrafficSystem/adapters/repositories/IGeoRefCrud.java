package com.air_traffic_system.AirTrafficSystem.adapters.repositories;

import org.springframework.data.repository.CrudRepository;

import com.air_traffic_system.AirTrafficSystem.domain.models.GeoRef;

public interface IGeoRefCrud extends CrudRepository<GeoRef, String> {
  GeoRef findByName(String name);
}
