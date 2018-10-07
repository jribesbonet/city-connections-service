package com.jribes.cityconnectionsservice.exception;

import com.jribes.cityconnectionsservice.response.CityConnectionServiceResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerService {

  @ExceptionHandler(IncorrectFormatCityException.class)
  private ResponseEntity<CityConnectionServiceResponse> handleBadFormatCityNameException(
      final Exception exception) {
    return new ResponseEntity<CityConnectionServiceResponse>(CityConnectionServiceResponse
        .createCityConnectionServiceWithCityNameException(exception.getMessage()),
        HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(Throwable.class)
  private ResponseEntity<CityConnectionServiceResponse> handleGenericUnexpectedException(
      final Exception exception) {
    return new ResponseEntity<CityConnectionServiceResponse>(
        CityConnectionServiceResponse.createCityConnectionServiceWithGenericError(),
        HttpStatus.INTERNAL_SERVER_ERROR);
  }

}
