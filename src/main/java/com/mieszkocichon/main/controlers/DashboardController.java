package com.mieszkocichon.main.controlers;

import com.mieszkocichon.main.beans.BookBean;
import com.mieszkocichon.main.services.DashboardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class DashboardController {

    private static final Class THIS_CLASS = DashboardController.class;
    private static final Logger LOGGER = LoggerFactory.getLogger(THIS_CLASS);

    @Autowired
    private DashboardService dashboardService;

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    @ResponseBody
    public List<BookBean> get(Authentication authentication) {
        String userName = authentication.getName();
        String userRoles = authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.joining(","));

        LOGGER.info(String.format("User name: %s", userName));
        LOGGER.info(String.format("User roles: %s", userRoles));

        return dashboardService.getAll();
    }

    @RequestMapping(value = "/dashboard/{id}", method = RequestMethod.GET)
    @ResponseBody
    public BookBean get(@PathVariable String id) {
        BookBean book = dashboardService.findById(id);

        LOGGER.info("Book has been found" + book);

        return book;
    }

    @RequestMapping(value = "/dashboard", method = RequestMethod.POST)
    @ResponseBody
    public List<BookBean> add(@RequestBody BookBean bookBean) {
        dashboardService.add(bookBean);

        LOGGER.info("Book has been added" + bookBean);

        return dashboardService.getAll();
    }

    @RequestMapping(value = "/dashboard/{id}", method = RequestMethod.DELETE)
    public BookBean remove(@PathVariable String id) {
        BookBean book = dashboardService.findById(id);

        dashboardService.removeById(id);

        LOGGER.info("Book has been removed" + book);

        return book;
    }
}