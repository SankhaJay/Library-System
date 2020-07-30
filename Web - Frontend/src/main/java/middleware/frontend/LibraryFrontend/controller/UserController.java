package middleware.frontend.LibraryFrontend.controller;

import middleware.frontend.LibraryFrontend.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

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

    @RequestMapping("/edit_user/{id}")
    public ModelAndView editUser(@PathVariable String id) {
        ModelAndView modelAndView = new ModelAndView();
        String URL = "http://localhost:3000/user/getUserById/"+ id;
        Object user = restTemplate.getForObject(URL, Object.class);
        System.out.println(user);
        modelAndView.addObject("user", user);
        modelAndView.setViewName("/edit_user.jsp");
        return modelAndView;
    }

    @PostMapping("/edit_user_form")
    public RedirectView editUser(User user) {
        ModelAndView modelAndView = new ModelAndView();
        System.out.println("ID "+ user.getUsr_id());
        String URL = "http://localhost:3000/user/update";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Object> request = new HttpEntity<Object>(user, headers);
        restTemplate.put(URL, request, Object.class);
        modelAndView.setViewName("/edit_user.jsp");
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("http://localhost:9090/user");
        return redirectView;
    }

    @PostMapping("/filter_user")
    public ModelAndView filterUser(User user) {
        ModelAndView modelAndView = new ModelAndView();
        System.out.println(user.getName());
        String URL = "http://localhost:3000/user/getUserByName/" + user.getName();
        Object[] users = restTemplate.getForObject(URL, Object[].class);
        modelAndView.addObject("users", users);
        modelAndView.setViewName("/user.jsp");
        return modelAndView;
    }

    @DeleteMapping("/delete/{id}")
    public RedirectView deleteUser(@PathVariable String id) {
        System.out.println(id);
        ModelAndView modelAndView = new ModelAndView();
        String URL = "http://localhost:3000/user/delete/" + id;
        try {
            restTemplate.delete(URL);
        } catch (Exception exception) {
            exception.getMessage();
        } finally {
            String users_URL = "http://localhost:3000/user/users";
            Object[] users = restTemplate.getForObject(users_URL, Object[].class);
            RedirectView redirectView = new RedirectView();
            redirectView.setUrl("http://localhost:9090/user");
            return redirectView;
        }
    }
}
