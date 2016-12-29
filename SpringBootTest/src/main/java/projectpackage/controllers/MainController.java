package projectpackage.controllers;

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
