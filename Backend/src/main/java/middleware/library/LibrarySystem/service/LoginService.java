package middleware.library.LibrarySystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import middleware.library.LibrarySystem.entity.Login;
import middleware.library.LibrarySystem.repository.LoginRepository;

@Service
public class LoginService {
	
	@Autowired
    private LoginRepository loginRepo;
	
	public Boolean login(Login user) {
		Login new_user = loginRepo.findById(user.getUsername()).orElse(null);
//		System.out.println(new_user.getPassword());
//		System.out.println(user.getPassword());
		if(new_user.getPassword().equals(user.getPassword())) {
			return true;
		}
		return false;
	}
}
