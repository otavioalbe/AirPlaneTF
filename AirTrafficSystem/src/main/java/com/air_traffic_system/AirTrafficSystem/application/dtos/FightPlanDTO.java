package com.air_traffic_system.AirTrafficSystem.application.dtos;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.air_traffic_system.AirTrafficSystem.domain.models.AirRoute;
import com.air_traffic_system.AirTrafficSystem.domain.models.Airplane;

public class FightPlanDTO {
    private int id;
  private int flightNumber;
  private boolean dispatched;
  private Date date;
  private Integer altitude;
  private Float cruisingSpeed;

  @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JoinColumn(name="id", nullable=false, insertable=false, updatable=false)
  private Airplane airplane;

  @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JoinColumn(name="id", nullable=false, insertable=false, updatable=false)
  private AirRoute airRoute;


   public FightPlanDTO(
    int flightNumber,
    Date date, 
    Integer altitude, 
    Float cruisingSpeed, 
    Boolean dispatched
) {
    this.flightNumber = flightNumber;
    this.date = date;
    this.altitude = altitude;
    this.cruisingSpeed = cruisingSpeed;
    this.dispatched = dispatched;
  }

  public int getId() {
    return id;
  }
  public int getFlightNumber() {
    return flightNumber;
  }
  public boolean getDispatched() {
    return dispatched;
  }
  public Date getDate() {
    return date;
  }
  public Integer getAltitude() {
    return altitude;
  }
  public Float getCruisingSpeed() {
    return cruisingSpeed;
  }

   public AirRoute getAirRoute() {
    return airRoute;
  }

}


