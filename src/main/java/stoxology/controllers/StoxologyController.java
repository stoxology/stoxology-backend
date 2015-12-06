package stoxology.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import stoxology.datacollator.alchemy.AlchemyExtractor;

@RestController
public class StoxologyController {

	@Autowired
	AlchemyExtractor alchemy;
	
    @RequestMapping("/")
	public String index() {	
		return "Greetings from Spring Foot!";
	}
    
    @RequestMapping("/alchemy/sentiment")
    public String getAlchemySentiments(@RequestParam(value="url") String url) {
    	return alchemy.extractSentiment(url);
    }
    
    @RequestMapping("/alchemy")
    public String getAlchemy(@RequestParam(value="url") String url) {
    	return "lel";
    }
}
