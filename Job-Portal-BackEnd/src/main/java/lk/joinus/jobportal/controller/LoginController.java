package lk.joinus.jobportal.controller;

import lk.joinus.jobportal.dto.UserDTO;
import lk.joinus.jobportal.service.JobPosterService;
import lk.joinus.jobportal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/login")
public class LoginController {

    @Autowired
    private JobPosterService jobPosterService;

    @Autowired
    private UserService userService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDTO Login(@RequestBody UserDTO userDTO)throws Exception{
        return userService.loginUser(userDTO.getUsername(),userDTO.getPassword());
    }
}
