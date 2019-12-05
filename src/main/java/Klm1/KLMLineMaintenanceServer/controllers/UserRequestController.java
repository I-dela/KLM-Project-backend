package Klm1.KLMLineMaintenanceServer.controllers;

import Klm1.KLMLineMaintenanceServer.models.UserRequest;
import Klm1.KLMLineMaintenanceServer.repositories.UserRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/userRequest")
@CrossOrigin(origins = "http://localhost:4200")
public class UserRequestController {


    @Autowired
   private  UserRequestRepository userRequestRepository ;
    @GetMapping("/")
    public List<UserRequest> getUserRequests(){
        return(List<UserRequest>) userRequestRepository.findAll();

    }
}
