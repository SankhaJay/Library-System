package middleware.frontend.LibraryFrontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
}
