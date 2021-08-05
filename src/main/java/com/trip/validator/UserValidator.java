package com.trip.validator;

import com.trip.model.User;
import com.trip.repository.UserDaoInternal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


@Component
public class UserValidator implements Validator {

    @Autowired
    private UserDaoInternal userDaoInternal;


    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "Required");
        if (user.getName().length() < 6 || user.getName().length() > 12) { //проверка пораметров имени
            errors.rejectValue("name", "Size.user.name");
        }

        if (userDaoInternal.getUserByName(user.getName()) != null) { //проверка наличия имени
            errors.rejectValue("name", "Duplicate.user.name");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Required");
        if (user.getPassword().length() < 6 || user.getPassword().length() > 12) { //проверка пороля
            errors.rejectValue("password", "Size.user.password");
        }

    }
}
