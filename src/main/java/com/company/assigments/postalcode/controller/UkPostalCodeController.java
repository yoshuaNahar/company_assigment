package com.company.assigments.postalcode.controller;

import com.company.assigments.postalcode.exception.EmptyPostalCodeException;
import com.company.assigments.postalcode.services.UkPostalCodeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// NO POST method. I would've used a Map<String, String> as the @RequestBody.
/*
 * When using machine-clients like Postman, you get a json error handling, instead of the whitelabel.
 * https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-features-error-handling
 */
@RestController
public class UkPostalCodeController {

  private static final Logger logger = LoggerFactory.getLogger(UkPostalCodeController.class);

  private UkPostalCodeService ukPostalCodeService;

  @Autowired
  public UkPostalCodeController(UkPostalCodeService ukPostalCodeService) {
    this.ukPostalCodeService = ukPostalCodeService;
  }

  @GetMapping("distance")
  public ResponseEntity getDistance(@RequestParam("postalcode1") String ukPostalCodeString1, @RequestParam("postalcode2") String ukPostalCodeString2) {
    logger.info("postalcode1: {} & postalcode2: {}", ukPostalCodeString1, ukPostalCodeString2);

    if (ukPostalCodeString1.isEmpty() || ukPostalCodeString2.isEmpty()) {
      throw new EmptyPostalCodeException();
    }

    return ResponseEntity.ok(ukPostalCodeService.getDistance(ukPostalCodeString1, ukPostalCodeString2));
  }

}
