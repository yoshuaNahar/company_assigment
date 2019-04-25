package com.company.assigments.postalcode.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No such postal code.")
public class NonExistentPostalCodeException extends RuntimeException {

  public NonExistentPostalCodeException() {
    super();
  }

}
