package es.uniovi.asw.testFallos;

import java.io.IOException;
import java.util.List;

import es.uniovi.asw.model.Voter;
import es.uniovi.asw.parser.RCensusExcel;

public class CheckFailsMain {

	public static void main(String[] args) throws IOException {
		CheckFails cf = new CheckFails();
		List<Voter> voters = new RCensusExcel().read("src/test/resources/testCheck.xlsx");
		cf.ComprobarFallos(voters);
	}

}
