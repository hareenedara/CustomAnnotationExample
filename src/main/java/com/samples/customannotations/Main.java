package com.samples.customannotations;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.constraints.NotNull;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("eh", "2011-12-23");
        Validator validator =Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Person>> violations = validator.validate(person);
        violations.forEach(v -> {
            System.out.println(v.getMessage());
        });
        System.out.println("Done");
    }


}
