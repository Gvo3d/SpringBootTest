package projectpackage.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Gvozd on 30.12.2016.
 */
@RestController
public class MainController {

    @RequestMapping("/")
    ModelAndView home() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
        return mav;
    }
}
