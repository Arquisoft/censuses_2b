package es.uniovi.asw;


import java.util.logging.Logger;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import es.uniovi.asw.model.Voter;

/**
 * Main application
 * 
 * @author censuses_2b
 *
 */
@SpringBootApplication
public class LoadUsers {
	
	private static Logger log = Logger.getLogger(LoadUsers.class.getName());
	public static VoterRepository voterRepository;
	
	public static void main(String... args) {
		SpringApplication.run(LoadUsers.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(VoterRepository repository) {
		return (args) -> {
			
			voterRepository = repository;
			
			repository.save(new Voter("Votante1", "votante1@uniovi.es", "00000001A", 3300, "pass"));
			repository.save(new Voter("Votante2", "votante2@uniovi.es", "00000002B", 3300, "pass"));
			repository.save(new Voter("Votante3", "votante3@uniovi.es", "00000003C", 3300, "pass"));
			repository.save(new Voter("Votante4", "votante4@uniovi.es", "00000004D", 3300, "pass"));

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Voter customer : repository.findAll()) {
				log.info(customer.toString());
			}
			log.info("");

			// fetch an individual customer by ID
			Voter customer = repository.findOne(1L);
			log.info("Customer found with findOne(1L):");
			log.info("--------------------------------");
			log.info(customer.toString());
			log.info("");
	
		};
	
	}

}