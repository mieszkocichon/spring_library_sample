package com.mieszkocichon.main.controlers;

import com.mieszkocichon.main.beans.BookBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String get() {
        return "Hello, World!";
    }
}