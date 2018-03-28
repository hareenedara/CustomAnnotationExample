package com.samples.customannotations;

import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Valid;
import java.lang.annotation.Annotation;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EffectiveDateValidator implements ConstraintValidator<ValidEffectiveDate,String > {

    String format;
    int yearsBuffer;

    @Override
    public void initialize(ValidEffectiveDate constraintAnnotation) {
        format = constraintAnnotation.format();
        yearsBuffer = constraintAnnotation.yearsbuffer();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(StringUtils.isBlank(value))
            return false;
        boolean result= false;
        try{
            result = isValidEffectiveDate(value,format,yearsBuffer);
        }catch(DateTimeException ex){
            return false;
        }
        return result;
    }

    boolean isValidEffectiveDate(String effDate, String dateFormat, int INTERVAL_YEARS) {

        LocalDate todayDate = LocalDate.now();
        LocalDate effStartDate = LocalDate.parse(effDate, DateTimeFormatter.ofPattern(dateFormat) );

        return (effStartDate.compareTo(todayDate.minusYears(INTERVAL_YEARS)) >=0
                && effStartDate.compareTo(todayDate.plusYears(INTERVAL_YEARS)) <= 0);
    }
}
