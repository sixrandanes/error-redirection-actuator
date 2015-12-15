package com.feature.domain.user;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


/**
 * Created by Sylvain on 14/12/2015.
 */
@Component("beforeDeleteUserValidator")
public class UserValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {

        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        System.out.println("ERRORR §§§§");
       // errors.reject("DIE");
    }
}