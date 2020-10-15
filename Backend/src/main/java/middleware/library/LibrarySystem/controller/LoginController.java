package middleware.library.LibrarySystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import middleware.library.LibrarySystem.entity.Login;
import middleware.library.LibrarySystem.service.LoginService;

@RestController()
@RequestMapping("/admin")
public class LoginController {
	
	@Autowired	
	private LoginService loginServ;
	
	@PostMapping("/login")
    public Boolean login(@RequestBody Login user) {
		System.out.println("here");
    	System.out.println("here"+user.getPassword());
    	System.out.println(user.getUsername());
    	
        return loginServ.login(user);
    }

}
