package middleware.frontend.LibraryFrontend.controller;

import middleware.frontend.LibraryFrontend.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/user")
    public ModelAndView userHome() {
        ModelAndView modelAndView = new ModelAndView();
        String URL = "http://localhost:3000/user/users";
        Object[] users = restTemplate.getForObject(URL, Object[].class);
        modelAndView.addObject("users", users);
        modelAndView.setViewName("/user.jsp");
        return modelAndView;
    }

    @RequestMapping("/add-user")
    public ModelAndView userAdd() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/user_add.jsp");
        return modelAndView;
    }

    @PostMapping("/create_user")
    public ModelAndView createUser(User user) {
        ModelAndView modelAndView = new ModelAndView();
        System.out.println(user.getDob());
        String URL = "http://localhost:3000/user/addUser";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Object> request = new HttpEntity<Object>(user, headers);
        headers.setContentType(MediaType.APPLICATION_JSON);
        restTemplate.postForObject(URL, request, Object.class);
        modelAndView.setViewName("/user_add.jsp");
        return modelAndView;
    }

    @GetMapping("/edit_user")
    public ModelAndView editUser(@RequestParam String nic) {
        ModelAndView modelAndView = new ModelAndView();
        String URL = "http://localhost:3000/user/getUserByNic/"+nic;
        Object user = restTemplate.getForObject(URL, Object.class);
        System.out.println(user);
        modelAndView.addObject("user", user);
        modelAndView.setViewName("/edit_user.jsp");
        return modelAndView;
    }
}
