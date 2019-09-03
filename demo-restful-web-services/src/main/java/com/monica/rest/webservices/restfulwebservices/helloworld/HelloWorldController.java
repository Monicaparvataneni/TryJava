package com.monica.rest.webservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
//GET//URI
	//@RequestMapping(method=RequestMethod.GET,path="/hello-world")
	@GetMapping(path="/hello-world")
	public String helloWorld(){
		return "Hello World1";
	}
	@GetMapping(path="/hello-world-bean")
	public HelloWorldBean helloWorldBean(){
		return new HelloWorldBean("Hello World bean");
	}
		@GetMapping(path="/hello-world-bean/var/{name}")
		public HelloWorldBean helloWorldBean(@PathVariable String name){
			return new HelloWorldBean("Hello World , "+name);
	}
}
