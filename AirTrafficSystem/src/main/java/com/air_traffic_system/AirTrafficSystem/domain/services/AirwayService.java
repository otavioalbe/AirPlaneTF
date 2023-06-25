package com.air_traffic_system.AirTrafficSystem.domain.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.air_traffic_system.AirTrafficSystem.application.dtos.AirwayFreeSlotDTO;
import com.air_traffic_system.AirTrafficSystem.application.dtos.AirwayReportDTO;
import com.air_traffic_system.AirTrafficSystem.domain.models.GeoRef;
import com.air_traffic_system.AirTrafficSystem.domain.repositories.IAirwayRepository;

@Component
public class AirwayService {
  public IAirwayRepository airwayRepository;
  
  @Autowired
  public AirwayService(IAirwayRepository airwayRepository){
    this.airwayRepository = airwayRepository;
  }

  public List<AirwayFreeSlotDTO> getAirwayFreeSlots(Date date, Float cruisingSpeed, String geoRefFrom, String geoRefTo) {
    GeoRef from = airwayRepository.getGeoRefByName(geoRefFrom);
    GeoRef to = airwayRepository.getGeoRefByName(geoRefTo);

    return airwayRepository.getFreeSlots(date, cruisingSpeed, from, to);
  }

  public GeoRef getGeoRefByName(String name) {
    return airwayRepository.getGeoRefByName(name);
  }

  public AirwayReportDTO generateAirwayReport(String name, Date date) {
    return airwayRepository.generateReport(name, date);
  }
}
