package es.uniovi.asw;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import es.uniovi.asw.model.Voter;
import es.uniovi.asw.parser.Parser;
import es.uniovi.asw.parser.RCensusExcel;

public class ValidateEmailTest {

	@BeforeClass
	public static void initialize() {
		LoadUsers.main();
	}
	@Test
	public void test() {
		List<Voter> chequeados = new RCensusExcel().read("src/test/resources/testCheck.xlsx");
		for(Voter v:chequeados){
			System.out.println(v.getName());
		}
		assertNull(Parser.voterRepository.findByEmail("wwuniovi.es"));
		assertNotNull(Parser.voterRepository.findByEmail("yy@uniovi.es"));
		assertNull(Parser.voterRepository.findByEmail("mm@uniovies."));

	}

}
