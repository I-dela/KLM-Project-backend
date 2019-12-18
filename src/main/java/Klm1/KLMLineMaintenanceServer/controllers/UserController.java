package Klm1.KLMLineMaintenanceServer.controllers;

import Klm1.KLMLineMaintenanceServer.models.User;
import Klm1.KLMLineMaintenanceServer.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

  @Autowired
  private UserRepository userRepository;


  @GetMapping("/users")
  public List<User> getUsers() {
    System.out.println(userRepository.findAll());
    return (List<User>) userRepository.findAll();
  }

  @GetMapping("/users/{id}")
  public User getUserById(@PathVariable(name = "id") String id){


    User user= userRepository.findById(id);

    if(user== null){
      throw new RuntimeException("User with id:" + id + "not found");
    }

    return user;

  }



  @PostMapping(value = "/users")
  public String postUsers(@RequestBody User user) {

    userRepository.save(user);
    return  "User saved succesfully";
  }

  @PatchMapping(value = "/users/{userId}")
  public String updateUser(@PathVariable String userId, @RequestBody User user){
    userRepository.save(user);
    return "updated successfully";
  }

  @DeleteMapping(value = "/users/{id}")
  public String deleteUser(@PathVariable String id){
    User user= userRepository.findById(id);
    userRepository.delete(user);
    return "Delete is successfull";
  }


}
