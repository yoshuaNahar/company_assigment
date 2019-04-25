package com.company.assigments.postalcode.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/*
 * I remember creating these and seeing json in the frn
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Empty postal code.")
public class EmptyPostalCodeException extends RuntimeException {

  public EmptyPostalCodeException() {
    super();
  }

}
