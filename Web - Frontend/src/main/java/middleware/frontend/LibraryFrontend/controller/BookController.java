package middleware.frontend.LibraryFrontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class BookController {
	@Autowired
	private RestTemplate restTemplate;
	
	 @RequestMapping("/book")
	    public ModelAndView userHome() {
	        ModelAndView modelAndView = new ModelAndView();
	        String URL = "http://localhost:3000/book/getAll";
	        Object[] books = restTemplate.getForObject(URL, Object[].class);
	        modelAndView.addObject("books", books);
	        modelAndView.setViewName("/book.jsp");
	        return modelAndView;
	    }
	
}
