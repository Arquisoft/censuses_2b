package es.uniovi.asw;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import es.uniovi.asw.model.Voter;
import es.uniovi.asw.parser.Parser;
import es.uniovi.asw.parser.RCensusExcel;

public class ReadCensusExcelTest {

	@BeforeClass
	public static void initialize() {
		LoadUsers.main();
	}
	
	@Test
	public void testReadEmpty() {
		List<Voter> voters = new RCensusExcel().read("src/test/resources/testEmpty.xlsx");
		
		assertEquals(true, voters.isEmpty());
	}
	
	@Test
	public void testRight() {
		List<Voter> voters = new RCensusExcel().read("src/test/resources/testRight.xlsx");
		
		List<Voter> votersToCheck = new ArrayList<Voter>();
		votersToCheck.add(new Voter("Ignacio Fernandez Fernandez", 
							"56378435A",
							"ignacio@uniovi.es",
							350));
		votersToCheck.add(new Voter("Nauce Lopez Gonzalez", 
				"53678541Z",
				"nauce@uniovi.es",
				440));
		votersToCheck.add(new Voter("Jorge Riopedre Vega", 
				"48976526C",
				"jorge@uniovi.es",
				220));
		
		for (Voter voter:votersToCheck) {
			Assert.assertTrue(voters.contains(voter));
			Assert.assertNotNull(Parser.voterRepository.findByEmail(voter.getEmail()));
		}
	}


}
