package com.nttdata.msclient.application.dto.validations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ExistProfileValidator.class)
public @interface ExistProfile {

  String message() default "El campo perfil es inválido";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

}
