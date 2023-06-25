package com.air_traffic_system.AirTrafficSystem.adapters.repositories;

import java.util.List;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.air_traffic_system.AirTrafficSystem.domain.models.AirRoute;
import com.air_traffic_system.AirTrafficSystem.domain.models.GeoRef;
import com.air_traffic_system.AirTrafficSystem.domain.repositories.IAirRouteRepository;

@Component
public class AirRouteRepository implements IAirRouteRepository {
  private IAirRouteCrud airRouteCrud;

  @Autowired
  public AirRouteRepository(IAirRouteCrud airRouteCrud) {
    this.airRouteCrud = airRouteCrud;
  }

  public List<AirRoute> getAllByDestination(GeoRef from, GeoRef to) {
    Predicate<AirRoute> haveSpecifiedDestination = 
      airRoute -> airRoute
        .getAirways()
        .stream()
        .anyMatch(airway -> 
          airway.getFrom().getName().equals(from.getName()) && 
          airway.getFrom().getName().equals(to.getName()));

    List<AirRoute> airRoutes = airRouteCrud
      .findAll()
      .stream()
      .filter(haveSpecifiedDestination)
      .toList();

    return airRoutes;
  }

  public AirRoute getByName(String name) {
    return airRouteCrud.findByName(name);
  }
}
