package es.uniovi.asw.testFallos;

import java.util.logging.Logger;

import es.uniovi.asw.LoadUsers;
import es.uniovi.asw.parser.VoterInfo;

public class CheckFails {

	private static final Logger log = Logger.getLogger(CheckFails.class.getName());
	
	public CheckFails() {
		LoadUsers.configureLogger(log);
	}

	public boolean comprobarFallosEmail(VoterInfo v) {

		// Si el email no tiene "@" y punto, si acaba en punto o si es nulo
		if (v.getEmail() == null || v.getEmail().toString().equals("")) {
			log.info("Email incorrecto " + "-------" + "línea : " + v.getLine());
			return false;

		} else if ((!v.getEmail().contains("@")) || (!v.getEmail().contains("."))
				|| (v.getEmail().charAt(v.getEmail().length() - 1) == '.')) {
			log.info("Email incorrecto " + "-------" + v.getEmail() + "-------" + "línea : " + v.getLine() + "\n");
			return false;
		}

		return true;
	}
	
	public boolean comprobarFallosNombre(VoterInfo v) {

		if (v.getName() == null || v.getName().equals("")) {
			log.info("Nombre vacío " + "-------" + "línea : " + v.getLine() + "\n");
			return false;
		}
		return true;

	}
	
	public boolean comprobarFallosNIF(VoterInfo v) {

		if (v.getNIF() == null || v.getNIF().toString().equals("")) {
			log.info("DNI inválido " + "-------" + "línea : " + v.getLine());
			return false;
		} else if ((!Character.isLetter(v.getNIF().charAt(v.getNIF().length() - 1))) || (!(v.getNIF().length() == 9))) {
			log.info("DNI inválido " + "-------" + v.getNIF() + "-------" + "línea : " + v.getLine() + "\n");
			return false;
		}
		return true;
	}
	
	public boolean comprobarFallosPollingPlace(VoterInfo v) {

		if ((v.getPollingPlace() == null) || (v.getPollingPlace().toString().equals(""))) {
			log.info("PollingPlace inválido " + "-------" + v.getPollingPlace() + "-------" + "línea : " + v.getLine() + "\n");
			return false;
		} else if (Double.parseDouble(v.getPollingPlace()) <= 0) {
			log.info("PollingPlace inválido " + "-------" + v.getPollingPlace() + "-------" + "línea : " + v.getLine()+ "\n");
			return false;
		}
		return true;
	}

	}


