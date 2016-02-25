package es.uniovi.asw;


import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import es.uniovi.asw.dbupdate.VoterRepository;
import es.uniovi.asw.parser.Parser;
import es.uniovi.asw.reportwritter.MyFormatter;

/**
 * Main application
 * 
 * @author censuses_2b
 *
 */
@SpringBootApplication
public class LoadUsers {
	
	private static FileHandler handler;
	
	public static void main(String... args) {
		SpringApplication.run(LoadUsers.class, args);
	}
	
	public static void configureLogger(Logger logger) {
		try {
			if (handler == null) {
				handler = new FileHandler("fails.log");
				handler.setFormatter(new MyFormatter());
			}
			logger.addHandler(handler);
			
		} catch (Exception e) { }
	}
	
	@Bean
	public CommandLineRunner demo(VoterRepository repository) {
		return (args) -> {
			Parser.voterRepository = repository;
			Parser.run(args);
		};
	
	}

}