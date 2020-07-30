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
        System.out.println(user);
        return userService.addUser(user);
    }

    @GetMapping("/users")
    public List<User> getAllUsers() throws Exception{
        return userService.getAllUsers();
    }

    @GetMapping("/getUserById/{id}")
    public User getUserById(@PathVariable String id) throws Exception{
        return userService.getUserById(Integer.parseInt(id));
    }

    @GetMapping("/getUserByName/{name}")
    public List<User> getUserByName(@PathVariable String name) throws Exception{
        return userService.getUserByName(name);
    }

    @PutMapping("/update")
    public User updateUser(@RequestBody User user) throws Exception{
        System.out.println("Updating " + user);
        return userService.updateUser(user);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable int id) throws Exception{
        return userService.deleteUser(id);
    }

}
