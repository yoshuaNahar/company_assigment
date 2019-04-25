package com.company.assigments.postalcode.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*
 * Changed the default table and column names to fit the .sql script.
 * An alternative would be to change the names inside the .sql scripts to fit the names of the generated sql table.
 */
@Entity
@Table(name = "postcodelatlng")
public class UkPostalCode {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false, insertable = false, updatable = false)
  private Long id;

  @Column(name = "postcode", nullable = false, insertable = false, updatable = false, unique = true, length = 10)
  private String postalCode;

  @Column(name = "latitude", nullable = false, insertable = false, updatable = false)
  private Double latitude;

  @Column(name = "longitude", nullable = false, insertable = false, updatable = false)
  private Double longitude;

  public UkPostalCode() {
  }

  public String getPostalCode() {
    return postalCode;
  }

  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }

  public Double getLatitude() {
    return latitude;
  }

  public void setLatitude(Double latitude) {
    this.latitude = latitude;
  }

  public Double getLongitude() {
    return longitude;
  }

  public void setLongitude(Double longitude) {
    this.longitude = longitude;
  }

}
