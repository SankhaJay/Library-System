package middleware.frontend.LibraryFrontend.controller;

import middleware.frontend.LibraryFrontend.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
        System.out.println(user.getName());
        modelAndView.setViewName("/user_add.jsp");
        return modelAndView;
    }
}
