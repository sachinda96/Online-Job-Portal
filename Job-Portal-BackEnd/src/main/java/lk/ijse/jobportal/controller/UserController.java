package lk.ijse.jobportal.controller;

import lk.ijse.jobportal.dto.UserDTO;
import lk.ijse.jobportal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean addUser(@RequestBody UserDTO userDTO){
        return userService.addUser(userDTO);
    }
}
