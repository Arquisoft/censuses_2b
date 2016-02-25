package es.uniovi.asw;

import static org.junit.Assert.*;

import org.junit.Test;

import es.uniovi.asw.parser.VoterInfo;
import es.uniovi.asw.testFallos.CheckFails;

public class CheckFailsTest {

	CheckFails cf = new CheckFails();
	
	@Test
	public void test() {
		VoterInfo v1 = new VoterInfo("","","","");		
		assertFalse(cf.comprobarFallosNombre(v1));
		assertFalse(cf.comprobarFallosNIF(v1));
		assertFalse(cf.comprobarFallosEmail(v1));
		assertFalse(cf.comprobarFallosPollingPlace(v1));
	}
	
	@Test
	public void test2() {
		VoterInfo v1 = new VoterInfo("Jonás","12345678Q","jonas@uniovi.es","3");		
		assertTrue(cf.comprobarFallosNombre(v1));
		assertTrue(cf.comprobarFallosNIF(v1));
		assertTrue(cf.comprobarFallosEmail(v1));
		assertTrue(cf.comprobarFallosPollingPlace(v1));
	}
	
	@Test
	public void test3() {
		VoterInfo v1 = new VoterInfo("Jonás","123456784Q","jonasuniovi.es","-1");		
		assertTrue(cf.comprobarFallosNombre(v1));
		assertFalse(cf.comprobarFallosNIF(v1));
		assertFalse(cf.comprobarFallosEmail(v1));
		assertFalse(cf.comprobarFallosPollingPlace(v1));
	}
	
	@Test
	public void test4() {
		VoterInfo v1 = new VoterInfo("","123456783","jonas@uniovies.","6");		
		assertFalse(cf.comprobarFallosNombre(v1));
		assertFalse(cf.comprobarFallosNIF(v1));
		assertFalse(cf.comprobarFallosEmail(v1));
		assertTrue(cf.comprobarFallosPollingPlace(v1));
	}

}
