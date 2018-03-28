package com.cforage.autocomplete;

import com.cforage.autocomplete.mediator.MasterManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * This order of annotations is very important
 */
@SpringBootApplication //attaches a bunch of
@ComponentScan(basePackages = {"com.cforage.autocomplete"}) // looks for Autowire-able candidates.
@Configuration // allows this class to configure Bean sources
public class AutocompleteApplication {


	@Autowired
	private MasterManager masterManager;


	public static void main(String[] args) {
		SpringApplication.run(AutocompleteApplication.class, args);

	}
}
