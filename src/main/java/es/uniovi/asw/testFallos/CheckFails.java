package es.uniovi.asw.testFallos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import es.uniovi.asw.parser.VoterInfo;

public class CheckFails {
	
	private static final Logger log = LoggerFactory.getLogger(CheckFails.class);

	
	public void ComprobarFallos(List<VoterInfo> voterValues) throws IOException {
		BufferedWriter bw=new BufferedWriter(new FileWriter("ficheroFallos.txt"));
		for(VoterInfo v: voterValues){
			if(!v.getEmail().contains("@"))
				bw.write("Email incorrecto " + "-------" + v.getEmail() + "\n") ;
		}

		bw.close();
	}
}
