package middleware.library.LibrarySystem.controller;

import middleware.library.LibrarySystem.entity.User;
import middleware.library.LibrarySystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user) throws Exception{
        return userService.addUser(user);
    }

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers() throws Exception{
        return userService.getAllUsers();
    }

    @GetMapping("/getUserByNic/{nic}")
    public User getUserByNIC(@PathVariable String nic) throws Exception{
        return userService.getUserByNIC(nic);
    }

    @GetMapping("/getUserByName/{name}")
    public User getUserByName(@PathVariable String name) throws Exception{
        return userService.getUserByName(name);
    }

    @PutMapping("/update")
    public User updateUser(@RequestBody User user) throws Exception{
        return userService.updateUser(user);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable String nic) throws Exception{
        return userService.deleteUser(nic);
    }

}
