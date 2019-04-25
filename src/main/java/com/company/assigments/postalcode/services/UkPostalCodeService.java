package com.company.assigments.postalcode.services;

import com.company.assigments.postalcode.domain.UkPostalCode;
import com.company.assigments.postalcode.exception.NonExistentPostalCodeException;
import com.company.assigments.postalcode.repository.UkPostalCodeRepository;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UkPostalCodeService {

  private UkPostalCodeRepository ukPostalCodeRepository;
  private UkPostalCodeUtil ukPostalCodeUtil;

  @Autowired
  public UkPostalCodeService(UkPostalCodeRepository ukPostalCodeRepository, UkPostalCodeUtil ukPostalCodeUtil) {
    this.ukPostalCodeRepository = ukPostalCodeRepository;
    this.ukPostalCodeUtil = ukPostalCodeUtil;
  }

  public Map<String, Object> getDistance(String ukPostalCodeString1, String ukPostalCodeString2) {
    Optional<UkPostalCode> ukPostalCodeOptional1 = getByPostalCode(ukPostalCodeString1);
    Optional<UkPostalCode> ukPostalCodeOptional2 = getByPostalCode(ukPostalCodeString2);
    UkPostalCode ukPostalCode1 = ukPostalCodeOptional1.orElseThrow(NonExistentPostalCodeException::new);
    UkPostalCode ukPostalCode2 = ukPostalCodeOptional2.orElseThrow(NonExistentPostalCodeException::new);

    Map<String, Object> jsonResult = new HashMap<>();
    jsonResult.put("postalCode1", ukPostalCode1);
    jsonResult.put("postalCode2", ukPostalCode2);

    double distance = ukPostalCodeUtil.calculateDistance(ukPostalCode1, ukPostalCode2);
    jsonResult.put("distance", distance);
    jsonResult.put("unit", "km");

    return jsonResult;
  }

  Optional<UkPostalCode> getByPostalCode(String postalCode) {
    return ukPostalCodeRepository.findByPostalCode(postalCode);
  }

}
