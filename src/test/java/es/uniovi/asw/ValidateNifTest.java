package es.uniovi.asw;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import es.uniovi.asw.model.Voter;
import es.uniovi.asw.parser.Parser;
import es.uniovi.asw.parser.RCensusExcel;

public class ValidateNifTest {

	@BeforeClass
	public static void initialize() {
		LoadUsers.main();
	}
	@Test
	public void test() {
		List<Voter> chequeados = new RCensusExcel().read("src/test/resources/test1.xlsx");
		for(Voter v:chequeados){
			System.out.println(v.getName());
		}
		assertNotNull(Parser.voterRepository.findByEmail("gg@uniovi.es"));
		assertNull(Parser.voterRepository.findByEmail("hh@uniovi.es"));
		assertNull(Parser.voterRepository.findByEmail("ii@uniovi.es"));
		assertNotNull(Parser.voterRepository.findByEmail("jj@uniovi.es"));
	}

}