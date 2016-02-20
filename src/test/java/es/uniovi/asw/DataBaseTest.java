package es.uniovi.asw;

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
		
		Assert.assertNull(Parser.voterRepository.findByEmail("nothing@uniovi.es"));
	}

}
