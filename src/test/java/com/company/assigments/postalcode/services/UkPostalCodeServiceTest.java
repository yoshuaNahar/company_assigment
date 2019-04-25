package com.company.assigments.postalcode.services;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import com.company.assigments.postalcode.domain.UkPostalCode;
import com.company.assigments.postalcode.repository.UkPostalCodeRepository;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

// Mocked Service Unit Test
@RunWith(SpringRunner.class)
public class UkPostalCodeServiceTest {

  private UkPostalCodeService ukPostalCodeService;

  @MockBean
  private UkPostalCodeRepository ukPostalCodeRepository;

  @MockBean
  private UkPostalCodeUtil ukPostalCodeUtil;

  @Before
  public void setup() {
    ukPostalCodeService = new UkPostalCodeService(ukPostalCodeRepository, ukPostalCodeUtil);
  }

  @Test
  public void verifyGetByPostalCodeCallsFindByPostalCode() {
    // Setup
    UkPostalCode ukPostalCode1 = new UkPostalCode();
    ukPostalCode1.setPostalCode("AB10 1XG");
    ukPostalCode1.setLongitude(1.0);
    ukPostalCode1.setLatitude(2.0);

    UkPostalCode ukPostalCode2 = new UkPostalCode();
    ukPostalCode2.setPostalCode("AB10 6RN");
    ukPostalCode2.setLongitude(10.0);
    ukPostalCode1.setLatitude(20.0);

    Map<String, Object> expectedJsonResult = new HashMap<>();
    expectedJsonResult.put("postalCode1", ukPostalCode1);
    expectedJsonResult.put("postalCode2", ukPostalCode2);
    expectedJsonResult.put("distance", 30.0);
    expectedJsonResult.put("unit", "km");

    when(ukPostalCodeService.getByPostalCode("AB10 1XG")).thenReturn(Optional.of(ukPostalCode1));
    when(ukPostalCodeService.getByPostalCode("AB10 6RN")).thenReturn(Optional.of(ukPostalCode2));
    when(ukPostalCodeUtil.calculateDistance(ukPostalCode1, ukPostalCode2)).thenReturn(30.0);

    // Test
    Map<String, Object> actualJsonResult = ukPostalCodeService.getDistance("AB10 1XG", "AB10 6RN");

    // Assert
    assertThat(actualJsonResult, is(expectedJsonResult));
  }

}
