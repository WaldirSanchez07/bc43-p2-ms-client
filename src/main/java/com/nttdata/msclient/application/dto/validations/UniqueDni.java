package com.nttdata.msclient.application.dto.validations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueDniValidator.class)
public @interface UniqueDni {

  String message() default "El dni debe ser único";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

}
