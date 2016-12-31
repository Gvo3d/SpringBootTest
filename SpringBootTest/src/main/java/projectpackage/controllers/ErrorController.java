package projectpackage.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Gvozd on 31.12.2016.
 */
@RestController
public class ErrorController {

    @RequestMapping("/error")
    ModelAndView error() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("error");
        return mav;
    }
}
