package projectpackage.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Timestamp;

/**
 * Created by Gvozd on 30.12.2016.
 */
@RestController
public class MainController {

    @RequestMapping(value = {"/", "welcome"}, method = RequestMethod.GET)
    ModelAndView home() {
        ModelAndView mav = new ModelAndView();
        Timestamp tms = new Timestamp(System.currentTimeMillis());
        mav.addObject("tms", tms);
        mav.setViewName("index");
        return mav;
    }
}
