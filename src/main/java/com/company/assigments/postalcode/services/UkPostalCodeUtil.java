package com.company.assigments.postalcode.services;

import com.company.assigments.postalcode.domain.UkPostalCode;
import org.springframework.stereotype.Service;

@Service
public class UkPostalCodeUtil {

  // radius in kilometers
  private static final double EARTH_RADIUS = 6371;

  public double calculateDistance(UkPostalCode ukPostalCode1, UkPostalCode ukPostalCode2) {
    return calculateDistance(ukPostalCode1.getLatitude(), ukPostalCode1.getLongitude(),
        ukPostalCode2.getLatitude(), ukPostalCode2.getLongitude());
  }

  // Requires decimal values...
  private double calculateDistance(double latitude, double longitude,
      double latitude2, double longitude2) {
    // Using Haversine formula. See Wikipedia.
    double lon1Radians = Math.toRadians(longitude);
    double lon2Radians = Math.toRadians(longitude2);
    double lat1Radians = Math.toRadians(latitude);
    double lat2Radians = Math.toRadians(latitude2);
    double a = haversine(lat1Radians, lat2Radians)
        + Math.cos(lat1Radians)
        * Math.cos(lat2Radians)
        * haversine(lon1Radians, lon2Radians);
    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
    return (EARTH_RADIUS * c);
  }

  private double haversine(double degree1, double degree2) {
    return square(Math.sin((degree1 - degree2) / 2.0));
  }

  private double square(double x) {
    return x * x;
  }

}
