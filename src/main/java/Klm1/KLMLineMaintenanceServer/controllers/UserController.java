package Klm1.KLMLineMaintenanceServer.controllers;

import Klm1.KLMLineMaintenanceServer.models.User;
import Klm1.KLMLineMaintenanceServer.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

  @Autowired
  private UserRepository userRepository;


  @GetMapping("/")
  public List<User> getUsers() {
    System.out.println(userRepository.findAll());
    return (List<User>) userRepository.findAll();
  }

  @PostMapping(value = "/")
  public String postUsers(@RequestBody User user) {

    userRepository.save(user);
    return  "User saved succesfully";
  }

  @PatchMapping(value = "/{userId}")
  public String updateUser(@PathVariable String userId, @RequestBody User user){
    userRepository.save(user);
    return "updated successfully";
  }

  @DeleteMapping(value = "/{id}")
  public String deleteUser(@PathVariable int id){
    userRepository.deleteById(id);
    return "Delete is successfull";
  }


}
