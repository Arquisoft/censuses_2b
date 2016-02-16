package es.uniovi.asw.personalLetters;

import java.util.List;

import es.uniovi.asw.model.Voter;

public class PersonalLetterGenerator {

	private PersonalLetterWriter writer;

	private List<Voter> voters;

	public PersonalLetterGenerator(List<Voter> voters, PersonalLetterWriter writer) {
		this.writer = writer;
		this.voters = voters;
	}

	public PersonalLetterGenerator(List<Voter> voters) {

		this.voters = voters;
	}

	public void chooseWritter(String type) {

		if (type.contains("t")) {
			writer = new PlainTextLetter();
		} else if (type.contains("w")) {
			writer = new WordLetterWriter();
		} else if (type.contains("p")) {
			writer = new PDFLetterWriter();
		}

	}

	public void writeAllLetters() {

		for (Voter voter : voters) {

			writer.WriteLetter(voter);
		}

	}

}
