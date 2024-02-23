package com.vitoria.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vitoria.configuration.GreetingConfiguration;
import com.vitoria.model.Greeting;

@RestController
public class GreetingController {
	

	private static final String template = "%s, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	@Autowired
	private GreetingConfiguration configuration;
	
	@RequestMapping(value= "/greeting")
	public Greeting greeting(@RequestParam(value="name",defaultValue="") String name) {
		
		if(name.isEmpty()) name=configuration.getDefaultValue();
		return new Greeting(counter.incrementAndGet(),String.format(template, configuration.getGreeting(),name));
	}
	
}
