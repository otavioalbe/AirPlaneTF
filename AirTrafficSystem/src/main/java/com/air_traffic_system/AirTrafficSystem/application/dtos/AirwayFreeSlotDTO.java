package com.air_traffic_system.AirTrafficSystem.application.dtos;

import java.util.Date;

public class AirwayFreeSlotDTO {
  private Integer hour;
  private Date date;
  private Integer altitude;
  private String airwayName;
  
  public AirwayFreeSlotDTO(Integer hour, Date date, Integer altitude, String airwayName) {
    this.hour = hour;
    this.date = date;
    this.altitude = altitude;
    this.airwayName = airwayName;
  }

  public Integer getHour() {
    return hour;
  }
  public Date getDate() {
    return date;
  }
  public Integer getAltitude() {
    return altitude;
  }
  public String getAirwayName() {
    return airwayName;
  }
}
