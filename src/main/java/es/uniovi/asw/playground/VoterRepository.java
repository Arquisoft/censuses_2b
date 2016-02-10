package es.uniovi.asw.playground;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import es.uniovi.asw.model.Voter;

public interface VoterRepository extends CrudRepository<Voter, Long> {

	
	  List<Voter> findByLastName(String lastName);
}
