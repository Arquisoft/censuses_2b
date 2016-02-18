package es.uniovi.asw;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import es.uniovi.asw.model.Voter;

/**
 * 
 * @author Naucé López
 *
 */
public interface VoterRepository extends CrudRepository<Voter, Long> {

	List<Voter> findByEmail(String email);
}
