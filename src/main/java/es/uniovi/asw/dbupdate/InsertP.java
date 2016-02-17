package es.uniovi.asw.dbupdate;

import java.util.ArrayList;
import java.util.List;

import es.uniovi.asw.model.Voter;
import es.uniovi.asw.parser.VoterInfo;

public class InsertP implements Insert {

	@Override
	public List<Voter> insert(List<VoterInfo> voterValues) {
		List<Voter> voters = new ArrayList<Voter>();
		//Inserta y verifica en la base de datos
		for (VoterInfo v:voterValues) {
			voters.add(new Voter(v.getName(), v.getNIF(), v.getEmail(), Integer.parseInt((v.getPollingPlace().replace(".0",  "")))));
			//Llamada y comprabacion en el report
			//LoadUsers.voterRepository.save(voter);
			//new WReportR().report(reasons);
		}
		
		//Devuelve los votantes insertados
		return voters;
	}

}
