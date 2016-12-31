package projectpackage.controllers;

import org.springframework.boot.autoconfigure.web.BasicErrorController;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Gvozd on 31.12.2016.
 */
@RestController
public class ErrorController extends BasicErrorController{

    public ErrorController(ErrorAttributes errorAttributes, ErrorProperties errorProperties) {
        super(errorAttributes, errorProperties);
    }

    @RequestMapping
    ModelAndView error() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("error");
        return mav;
    }
}
