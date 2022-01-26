package com.deciphex.deciphex.assignment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudyApplication {

	private static final Logger log = LoggerFactory.getLogger(StudyApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(StudyApplication.class, args);

		log.info("Printer to verify application has launched!");
	}

}
