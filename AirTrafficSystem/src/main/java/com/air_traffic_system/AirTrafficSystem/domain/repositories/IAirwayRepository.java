package com.air_traffic_system.AirTrafficSystem.domain.repositories;

import java.util.Date;
import java.util.List;

import com.air_traffic_system.AirTrafficSystem.application.dtos.AirwayFreeSlotDTO;
import com.air_traffic_system.AirTrafficSystem.application.dtos.AirwayReportDTO;
import com.air_traffic_system.AirTrafficSystem.domain.models.GeoRef;

public interface IAirwayRepository {
  List<AirwayFreeSlotDTO> getFreeSlots(Date date, Float cruisingSpeed, GeoRef from, GeoRef to);
  GeoRef getGeoRefByName(String name);
  AirwayReportDTO generateReport(String name, Date date);
}
