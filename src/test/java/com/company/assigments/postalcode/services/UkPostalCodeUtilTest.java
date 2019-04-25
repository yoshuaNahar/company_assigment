package com.company.assigments.postalcode.services;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import com.company.assigments.postalcode.domain.UkPostalCode;
import org.junit.Before;
import org.junit.Test;

// Unit test
public class UkPostalCodeUtilTest {

  private UkPostalCodeUtil ukPostalCodeUtil = new UkPostalCodeUtil();

  private UkPostalCode postalCode1;
  private UkPostalCode postalCode2;

  @Before
  public void setup() {
    postalCode1 = new UkPostalCode();
    postalCode1.setPostalCode("AB10 1XG");
    postalCode1.setLatitude(57.14416516);
    postalCode1.setLongitude(-2.114847768);

    postalCode2 = new UkPostalCode();
    postalCode2.setPostalCode("AB10 6RN");
    postalCode2.setLatitude(57.13787976);
    postalCode2.setLongitude(-2.121486688);
  }

  @Test
  public void calculateDistanceWithPostalCode1AndPostalCode2ShouldReturn08055408702919634() {
    double distance = ukPostalCodeUtil.calculateDistance(postalCode1, postalCode2);

    assertThat(distance, is(0.8055408702919634));
  }

}
