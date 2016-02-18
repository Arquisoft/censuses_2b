package es.uniovi.asw.testFallos;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.uniovi.asw.parser.VoterInfo;

public class CheckFails {

	private static final Logger log = LoggerFactory.getLogger(CheckFails.class);

	public boolean comprobarFallosEmail(VoterInfo v) {

		// Si el email no tiene "@" y punto, si acaba en punto o si es nulo
		if (v.getEmail() == null || v.getEmail().toString().equals("")) {
			log.error("Email incorrecto " + "-------" + "línea : " + v.getLine());
			return false;

		} else if ((!v.getEmail().contains("@")) || (!v.getEmail().contains("."))
				|| (v.getEmail().charAt(v.getEmail().length() - 1) == '.')) {
			log.error("Email incorrecto " + "-------" + v.getEmail() + "-------" + "línea : " + v.getLine() + "\n");
			return false;
		}

		return true;
	}
	
	public boolean comprobarFallosNombre(VoterInfo v) {

		if (v.getName() == null || v.getName().equals("")) {
			log.error("Nombre vacío " + "-------" + "línea : " + v.getLine() + "\n");
			return false;
		}
		return true;

	}
	
	public boolean comprobarFallosNIF(VoterInfo v) {

		if (v.getNIF() == null || v.getNIF().toString().equals("")) {
			log.error("DNI inválido " + "-------" + "línea : " + v.getLine());
			return false;
		} else if ((!Character.isLetter(v.getNIF().charAt(v.getNIF().length() - 1))) || (!(v.getNIF().length() == 9))) {
			log.error("DNI inválido " + "-------" + v.getNIF() + "-------" + "línea : " + v.getLine() + "\n");
			return false;
		}
		return true;
	}
	
	public boolean comprobarFallosPollingPlace(VoterInfo v) {

		if ((v.getPollingPlace() == null) || (v.getPollingPlace().toString().equals(""))) {
			log.error("PollingPlace inválido " + "-------" + v.getPollingPlace() + "-------" + "línea : " + v.getLine() + "\n");
			return false;
		} else if (Double.parseDouble(v.getPollingPlace()) <= 0) {
			log.error("PollingPlace inválido " + "-------" + v.getPollingPlace() + "-------" + "línea : " + v.getLine()+ "\n");
			return false;
		}
		return true;
	}

	}


