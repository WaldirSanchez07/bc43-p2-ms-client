package com.nttdata.msclient.application.dto.validations;

import com.nttdata.msclient.domain.service.ClientService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UniqueDniValidator implements ConstraintValidator<UniqueDni, String> {

  private final ClientService clientService;

  @Override
  public void initialize(UniqueDni constraintAnnotation) {
    ConstraintValidator.super.initialize(constraintAnnotation);
  }

  @Override
  public boolean isValid(String dni, ConstraintValidatorContext context) {
    return clientService.findDniByDni(dni).isEmpty().blockingGet();
  }

}
