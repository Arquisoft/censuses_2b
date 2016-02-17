package es.uniovi.asw;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private static final Logger log = LoggerFactory.getLogger(LoadUsers.class);
	
	public static void main(String... args) {
		SpringApplication.run(LoadUsers.class);
	}

	@Bean
	public CommandLineRunner demo(VoterRepository repository) {
		return (args) -> {
			repository.save(new Voter("Votante1", "votante1@uniovi.es", "00000001A", 3300));
			repository.save(new Voter("Votante2", "votante2@uniovi.es", "00000002B", 3300));
			repository.save(new Voter("Votante3", "votante3@uniovi.es", "00000003C", 3300));
			repository.save(new Voter("Votante4", "votante4@uniovi.es", "00000004D", 3300));

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