package com.nttdata.msclient.application.dto.validations;

import com.nttdata.msclient.domain.service.ProfileService;
import lombok.AllArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@AllArgsConstructor
public class ExistProfileValidator implements ConstraintValidator<ExistProfile, String> {

  private final ProfileService profileService;

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    return !profileService.findById(value).isEmpty().blockingGet();
  }

}
