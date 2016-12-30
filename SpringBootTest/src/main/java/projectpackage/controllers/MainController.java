package projectpackage.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Gvozd on 30.12.2016.
 */
@RestController
public class MainController {

    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }
}
