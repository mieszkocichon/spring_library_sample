package com.mieszkocichon.main.controlers;

import com.mieszkocichon.main.exception.ErrorMessage;
import com.mieszkocichon.main.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ResponseBody
    public UserDetails get(@RequestParam("user") String user, @RequestParam("password") String password) throws IllegalAccessException {
        UserDetails userDetails = userService.loadUserByUsername(user);
        if (Objects.equals(userDetails.getPassword().substring(6), password)) {
            return userDetails;
        }

        throw new IllegalAccessException("Bad credentials");
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseEntity<ErrorMessage> HandleInternalError(InternalError ex) {
        log.warn(ex.getMessage());
        return new ResponseEntity<>(new ErrorMessage(
                "Bad credentials",
                ex.getMessage(),
                ""), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
