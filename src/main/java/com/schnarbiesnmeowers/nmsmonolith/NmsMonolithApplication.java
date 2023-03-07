package com.schnarbiesnmeowers.nmsmonolith;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/**
 *
 * @author Dylan I. Kessler
 *
 */
@SpringBootApplication
public class NmsMonolithApplication {

	//private static final Logger applicationLogger = LogManager.getLogger("FileAppender");

	/**
	 * this is the main class for our NmsMonolith application
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(NmsMonolithApplication.class, args);
	}


}