package org.sg.flooring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@EntityScan(basePackages = "org.sg.flooring")
@SpringBootApplication
public class FlooringApplication {

//	private static final Logger log = LoggerFactory.getLogger(FlooringApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(FlooringApplication.class, args);
	}

}
