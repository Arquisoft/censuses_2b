package es.uniovi.asw;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import es.uniovi.asw.parser.RCensusExcel;
import es.uniovi.asw.parser.VoterInfo;
import es.uniovi.asw.testFallos.CheckFails;

public class ReadCensusExcelTest {

	@Test
	public void testReadEmpty() {
		List<VoterInfo> voters = new RCensusExcel().read("src/test/resources/testEmpty.xlsx");
		
		assertEquals(true, voters.isEmpty());
	}
	
	@Test
	public void testRight() {
		List<VoterInfo> voters = new RCensusExcel().read("src/test/resources/testRight.xlsx");
		
		List<VoterInfo> votersToCheck = new ArrayList<VoterInfo>();
		votersToCheck.add(new VoterInfo("Ignacio Fernández Fernández", 
							"56378435A",
							"ignacio@uniovi.es",
							"350.0"));
		votersToCheck.add(new VoterInfo("Naucé López González", 
				"53678541Z",
				"nauce@uniovi.es",
				"440.0"));
		votersToCheck.add(new VoterInfo("Jorge Riopedre Vega", 
				"48976526C",
				"jorge@uniovi.es",
				"220.0"));
		
		assertEquals(3, voters.size());
		Assert.assertArrayEquals(votersToCheck.toArray(), voters.toArray());
	}


}
