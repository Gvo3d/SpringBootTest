package projectpackage.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import projectpackage.model.AuthEntities.User;
import projectpackage.service.SecurityService;
import projectpackage.service.UserService;
import projectpackage.validators.UserValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Gvozd on 07.01.2017.
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model){
        model.addAttribute("userForm", new User());
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registrationHandler(@ModelAttribute("userFrom") User userForm, BindingResult bindingResult, Model model){
        System.out.println("controller: "+userForm.toString());
        userValidator.validate(userForm, bindingResult);
        if (bindingResult.hasErrors()){
            model.addAttribute("error", bindingResult.getFieldErrors());
            return "redirect:/registration";
        }
        userService.save(userForm);
        securityService.autologin(userForm.getUsername(), userForm.getConfirmPassword());
        return "redirect:/index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout){

        if (error!=null){
            model.addAttribute("error", "Username or password incorrect");
        }

        if (logout!=null){
            model.addAttribute("message", "Logged out succesfully");
        }

        return "login";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin(Model model){
        return "admin";
    }

    @RequestMapping(value = "/useronly", method = RequestMethod.GET)
    public String useronly(HttpServletRequest request, HttpServletResponse response){
        return "index";
    }
}
