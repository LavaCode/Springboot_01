package nl.kasper.springbootdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {

    @GetMapping(value="/")
	public String getDemo() {
		return "Hello World! ";
	}

	@GetMapping(value="/grap")
	public String getGrap() {
		return "Hello Ho! ";
	}

	@GetMapping(value="/grap/test2")
	public String getTest() {
		return "Hello Ho! 2";
	}
    
}
