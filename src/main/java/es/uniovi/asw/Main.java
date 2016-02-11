package es.uniovi.asw;

import java.util.ArrayList;
import java.util.List;

import es.uniovi.asw.model.Voter;
import es.uniovi.asw.reportGeneration.PasswordGenerator;
import es.uniovi.asw.reportGeneration.PlainTextLetter;

public class Main {

	public static void main(String[] args) {

		List<Voter> voters = new ArrayList<Voter>();

		voters.add(new Voter("Votante1", "votante1@uniovi.es", "00000001A", 3300));
		voters.add(new Voter("Votante2", "votante2@uniovi.es", "00000002B", 3300));
		voters.add(new Voter("Votante3", "votante3@uniovi.es", "00000003C", 3300));
		voters.add(new Voter("Votante4", "votante4@uniovi.es", "00000004D", 3300));

		PasswordGenerator.generatePasswords(voters);

		PlainTextLetter ptw = new PlainTextLetter(voters);

		ptw.WriteLetter();

	}

}
