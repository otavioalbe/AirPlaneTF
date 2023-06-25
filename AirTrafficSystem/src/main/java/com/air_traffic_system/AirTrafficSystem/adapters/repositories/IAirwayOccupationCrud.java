package com.air_traffic_system.AirTrafficSystem.adapters.repositories;

import org.springframework.data.repository.CrudRepository;

import com.air_traffic_system.AirTrafficSystem.domain.models.AirwayOccupation;

public interface IAirwayOccupationCrud extends CrudRepository<AirwayOccupation, String> {
}
