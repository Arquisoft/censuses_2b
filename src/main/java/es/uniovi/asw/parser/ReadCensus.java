package es.uniovi.asw.parser;

import java.util.List;

public interface ReadCensus {

	public List<VoterInfo> read(String... path);
}
