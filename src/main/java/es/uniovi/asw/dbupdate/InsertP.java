package es.uniovi.asw.dbupdate;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import es.uniovi.asw.model.Voter;
import es.uniovi.asw.parser.Parser;
import es.uniovi.asw.parser.VoterInfo;
import es.uniovi.asw.reportGeneration.PasswordGenerator;

public class InsertP implements Insert {

	private static Logger log = Logger.getLogger(InsertP.class);
	
	@Override
	public List<Voter> insert(List<VoterInfo> voterValues, String path) {
		List<Voter> voters = new ArrayList<Voter>();
		Voter voter;
		//Inserta y verifica en la base de datos
		for (VoterInfo v:voterValues) {
			//Validar informacion: if (...)
			voter = new Voter(v.getName(), v.getNIF(), v.getEmail(), Integer.parseInt((v.getPollingPlace().replace(".0",  ""))));
			voters.add(voter);
			PasswordGenerator.generatePasswords(voter);
			Parser.voterRepository.save(voter);
			log.info(voter);
			//else (error...)
			//new WReportR().report(reasons);
		}
		
		//Devuelve los votantes insertados
		return voters;
	}

}
