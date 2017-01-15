package projectpackage.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import projectpackage.model.AuthEntities.User;
import projectpackage.service.UserService;

/**
 * Created by Gvozd on 07.01.2017.
 */
@Component
public class UserValidator implements Validator{

    @Autowired
    UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "login.emptyField");
        if (user.getUsername().length()<5 || user.getUsername().length()>32){
            errors.rejectValue("username", "login.outOfBounds");
            System.out.println("VALIDATION ERROR - login.outOfBound");
        }
        if (userService.findByUsername(user.getUsername())!=null){
            errors.rejectValue("username", "userCreation.alreadyExist");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "login.emptyField");
        if (user.getPassword().length()<5 || user.getPassword().length()>32){
            errors.rejectValue("password", "login.passOutOfBounds");
            System.out.println("VALIDATION ERROR - login.passOutOfBound");
        }
        if (!user.getConfirmPassword().equals(user.getPassword())) {
            errors.rejectValue("confirmPassword", "userCreation.passwordConfirmFalse");
        }
    }
}
