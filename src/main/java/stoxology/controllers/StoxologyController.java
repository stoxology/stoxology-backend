package stoxology.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StoxologyController {

    @RequestMapping("/")
	public String index() {	
		return "Greetings from Spring Boot!";
	}
}
