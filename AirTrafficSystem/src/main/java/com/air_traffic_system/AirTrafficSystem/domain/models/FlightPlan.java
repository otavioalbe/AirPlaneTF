package com.air_traffic_system.AirTrafficSystem.domain.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "planoVoo")
public class FlightPlan {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int flightNumber;
  @Column(unique=true)
  private int rota;
  private boolean dispatched;
  private Date date;
  private Integer altitude;
  private Float cruisingSpeed;


  public FlightPlan(
    int flightNumber,
    Date date, 
    Integer altitude, 
    Float cruisingSpeed, 
    Airplane airplane,
    AirRoute airRoute) {
    this.flightNumber = flightNumber;
    this.date = date;
    this.altitude = altitude;
    this.cruisingSpeed = cruisingSpeed;
    this.airplane = airplane;
    this.airRoute = airRoute;
    this.dispatched = false;
  }

  public FlightPlan() {
}

@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JoinColumn(name="aviao", nullable=false, insertable=false, updatable=false)
  private Airplane airplane;

  @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JoinColumn(name="rota", nullable=false, insertable=false, updatable=false)
  private AirRoute airRoute;

  public int getRota() {
    return rota;
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

  public void setDispatched(boolean dispatched) {
    this.dispatched = dispatched;
  }
}
