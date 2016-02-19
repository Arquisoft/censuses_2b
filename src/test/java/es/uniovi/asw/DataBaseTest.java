package es.uniovi.asw;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import es.uniovi.asw.parser.Parser;
import es.uniovi.asw.parser.RCensusExcel;

public class DataBaseTest {

	@BeforeClass
	public static void initialize() {
		LoadUsers.main();
	}
	
	@Test
	public void test() {
		new RCensusExcel().read("src/test/resources/testRight.xlsx");
		Assert.assertNotNull(Parser.voterRepository.findByEmail("nauce@uniovi.es"));
		Assert.assertNotNull(Parser.voterRepository.findByEmail("jorge@uniovi.es"));
		
		
		//parte mysql
		
		//assertEquals(1, Parser.voterRepository.findByEmail("nauce@uniovi.es").size());
		//assertEquals(0, Parser.voterRepository.findByEmail("nohay@uniovi.es").size());
		//assertEquals(1, Parser.voterRepository.findByEmail("a@a.com").size());

		
	}

}
