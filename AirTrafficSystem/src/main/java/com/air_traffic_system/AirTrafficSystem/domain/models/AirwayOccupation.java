package com.air_traffic_system.AirTrafficSystem.domain.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "airway_occupations")
public class AirwayOccupation {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private Date date;
  private Integer altitude;

  public AirwayOccupation() {}

  public AirwayOccupation(Date date, Integer altitude, Airway airway) {
    this.date = date;
    this.altitude = altitude;
    this.airway = airway;
  }

  @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JoinColumn(name="id", nullable=false, insertable=false, updatable=false)
  private Airway airway;

  public int getId() {
    return id;
  }
  public Date getDate() {
    return date;
  }
  public Integer getAltitude() {
    return altitude;
  } 
}
