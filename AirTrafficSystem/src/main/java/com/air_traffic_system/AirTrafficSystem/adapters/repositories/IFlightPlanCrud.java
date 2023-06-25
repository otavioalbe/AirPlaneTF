package com.air_traffic_system.AirTrafficSystem.adapters.repositories;

import org.springframework.data.repository.CrudRepository;

import com.air_traffic_system.AirTrafficSystem.domain.models.FlightPlan;

public interface IFlightPlanCrud extends CrudRepository<FlightPlan, String> {
  FlightPlan findByFlightNumber(int flightNumber);
}
