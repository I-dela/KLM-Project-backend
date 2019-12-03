package com.klmhva.LineMaintenanceBackend.controller;

import com.klmhva.LineMaintenanceBackend.model.User;
import com.klmhva.LineMaintenanceBackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/getUsers")
    public @ResponseBody
    List<User> getUsers() {
        return (List<User>) userRepository.findAll();
    }
}
