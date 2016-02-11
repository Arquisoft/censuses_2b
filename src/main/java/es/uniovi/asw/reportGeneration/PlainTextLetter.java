package es.uniovi.asw.reportGeneration;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import es.uniovi.asw.model.Voter;

public class PlainTextLetter implements PersonalLetterWriter {

	private FileWriter writer;

	private List<Voter> voters;

	public PlainTextLetter(List<Voter> voters) {

		this.voters = voters;

	}

	@Override
	public void WriteLetter() {

		String fileName = "";

		for (Voter voter : voters) {

			fileName = voter.getNIF() + ".txt";
			try {
				writer = new FileWriter(fileName);
				writer.write("User :" + "\t" + voter.getEmail());
				writer.write("\n");
				writer.write("Password : " + "\t" + voter.getPassword());
				writer.write("\n");
				writer.write("Thanks for using our service, hope all went well.");
				writer.write("\n");
				writer.write(new Date().toString());

				writer.close();

			} catch (IOException e) {

				System.err.println("No se ha podido crear el archivo" + e.getMessage());
			}

		}

	}

}
