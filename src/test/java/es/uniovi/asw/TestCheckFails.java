package es.uniovi.asw;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

import es.uniovi.asw.parser.RCensusExcel;
import es.uniovi.asw.parser.VoterInfo;
import es.uniovi.asw.testFallos.CheckFails;

public class TestCheckFails {

	
	@Test
	public void testFails() throws IOException {
		CheckFails cf = new CheckFails();
		List<VoterInfo> voters = new RCensusExcel().read("src/test/resources/testCheck.xlsx");
		cf.ComprobarFallos(voters);
	}

}
