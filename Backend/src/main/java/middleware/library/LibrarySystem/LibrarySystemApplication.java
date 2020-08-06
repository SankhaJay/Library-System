package middleware.library.LibrarySystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
<<<<<<< HEAD

=======
>>>>>>> 3422287c1f0a31679aa97518822a8cb37063ac6a
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@SpringBootApplication
public class LibrarySystemApplication {
	
	    @RequestMapping("/")
	    @ResponseBody
	    String home() {
	      return "Library-System-Spring Boot-Backend";
	    }

	public static void main(String[] args) {
		SpringApplication.run(LibrarySystemApplication.class, args);
	}

}
