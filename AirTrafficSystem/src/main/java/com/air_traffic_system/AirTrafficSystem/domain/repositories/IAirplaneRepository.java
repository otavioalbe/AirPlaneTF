package com.air_traffic_system.AirTrafficSystem.domain.repositories;

import java.util.List;

import com.air_traffic_system.AirTrafficSystem.domain.models.Airplane;

public interface IAirplaneRepository {
  List<Airplane> getAll();
  boolean insert(Airplane airplane);
}
