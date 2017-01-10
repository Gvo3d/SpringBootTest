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
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "login.emptyField");
        if (user.getLogin().length()<6 || user.getLogin().length()>32){
            errors.rejectValue("login", "login.outOfBounds");
        }
        if (userService.findByLogin(user.getLogin())!=null){
            errors.rejectValue("login", "userCreation.alreadyExist");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "login.emptyField");
        if (user.getPassword().length()<8 || user.getPassword().length()>32){
            errors.rejectValue("password", "login.passOutOfBounds");
        }
        if (!user.getConfirmPassword().equals(user.getPassword())) {
            errors.rejectValue("confirmPassword", "userCreation.passwordConfirmFalse");
        }
    }
}
