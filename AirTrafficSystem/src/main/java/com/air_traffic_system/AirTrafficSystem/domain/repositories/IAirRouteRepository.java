package com.air_traffic_system.AirTrafficSystem.domain.repositories;

import java.util.List;

import com.air_traffic_system.AirTrafficSystem.domain.models.AirRoute;
import com.air_traffic_system.AirTrafficSystem.domain.models.GeoRef;

public interface IAirRouteRepository {
  List<AirRoute> getAllByDestination(GeoRef from, GeoRef to);
  AirRoute getByName(String name);
}
