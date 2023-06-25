package com.air_traffic_system.AirTrafficSystem.domain.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "airways")
public class Airway {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String name;

  public Airway() {}

  public Airway(String name, List<AirwayOccupation> airwayOccupations, AirRoute airRoute, GeoRef from, GeoRef to) {
    this.name = name;
    this.airwayOccupations = airwayOccupations;
    this.airRoute = airRoute;
    this.from = from;
    this.to = to;
  }

  @OneToMany(fetch = FetchType.EAGER,
             mappedBy = "airway", 
             cascade = CascadeType.ALL)
  private List<AirwayOccupation> airwayOccupations;

  @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JoinColumn(name="id", nullable=false, insertable=false, updatable=false)
  private AirRoute airRoute;

  @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JoinColumn(name="id", nullable=false, insertable=false, updatable=false)
  private GeoRef from;
  
  @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JoinColumn(name="id", nullable=false, insertable=false, updatable=false)
  private GeoRef to;

  public int getId() {
    return id;
  }
  public String getName() {
    return name;
  }
  public GeoRef getFrom() {
    return from;
  }
  public GeoRef getTo() {
    return to;
  }
  public List<AirwayOccupation> getAirwayOccupations() {
    return airwayOccupations;
  }
  public AirRoute getAirRoute() {
    return airRoute;
  } 
}
