package es.uniovi.asw;

import java.util.ArrayList;
import java.util.List;

import es.uniovi.asw.model.Voter;
import es.uniovi.asw.personalLetters.PersonalLetterGenerator;
import es.uniovi.asw.reportGeneration.PasswordGenerator;

public class Main {

	public static void main(String[] args) {

		List<Voter> voters = new ArrayList<Voter>();

		voters.add(new Voter("Votante1", "00000001A", "votante1@uniovi.es", 3300));
		voters.add(new Voter("Votante2", "00000002B", "votante2@uniovi.es", 3300));
		voters.add(new Voter("Votante3", "00000003C", "votante2@uniovi.es", 3300));
		voters.add(new Voter("Votante4", "00000004D", "votante4@uniovi.es", 3300));

		PasswordGenerator.generatePasswords(voters);

		PersonalLetterGenerator psg = new PersonalLetterGenerator(voters);
		psg.chooseWritter("p");

		psg.writeAllLetters();

	}

}
