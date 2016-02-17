package es.uniovi.asw.dbupdate;

import java.util.List;

import es.uniovi.asw.parser.VoterInfo;

public interface Insert {
	
	public void insert(List<VoterInfo> voterValues);
	
}
