package com.air_traffic_system.AirTrafficSystem.domain.repositories;

import java.util.List;

import com.air_traffic_system.AirTrafficSystem.domain.models.AirwayOccupation;
import com.air_traffic_system.AirTrafficSystem.domain.models.GeoRef;

public interface IFlightPlanRepository {
  List<AirwayOccupation> check(int flightNumber, GeoRef from, GeoRef to);
  boolean dispatch(int flightNumber, GeoRef from, GeoRef to);
  boolean cancel(int flightNumber, GeoRef from, GeoRef to);
}
