package com.samples.customannotations;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.lang.annotation.*;
import java.lang.reflect.Method;


@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EffectiveDateValidator.class)
@Documented
@Pattern(regexp= "\\d{4}-[01]\\d-[0-3]\\d",message="Invalid Date")
public @interface ValidEffectiveDate {
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String format() default "yyyy-MM-dd";
    int yearsbuffer() default 1;
    String message() default "Invalid Date";

}
