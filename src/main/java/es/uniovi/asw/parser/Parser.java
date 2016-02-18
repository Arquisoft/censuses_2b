package es.uniovi.asw.parser;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import es.uniovi.asw.VoterRepository;

/**
 * [-c1 -c2 -cN]    file1 [-c2]    file2    fileN [-c1 -c3]
 * 
 * The first format's parameters to generate Personal Letters (-c1, -c2, ..., -cN)
 * are only apply to all of the files
 * if they haven't got any parameters on its right (for example, the file2 hasn't got).
 * 
 * All the format's parameters are optionals.
 * 
 * Formats parameters:
 * 
 * -w	Word format
 * -p	PDF format
 * -t	TXT format
 * 
 * @author Nauce
 *
 */
public class Parser {

	@Autowired
	public static VoterRepository voterRepository;
	
	public static void run(VoterRepository repository, String... args) {
	
		voterRepository = repository;
		
		List<String> writterFormatsToAll = new ArrayList<String>();
		List<String> writterFormats = new ArrayList<String>();
		String pathFile = null;
		
		int i = 0;
		
		while(i < args.length && args[i].startsWith("-")) {
			writterFormatsToAll.add(args[i]);
			i++;
		}
		
		while(i < args.length) {
			pathFile = args[i];
			i++;
			
			while (i < args.length && args[i].startsWith("-")) {
				writterFormats.add(args[i]);
				i++;
			}
			
			if (writterFormats.isEmpty())
				readFile(pathFile, writterFormatsToAll.toArray(new String[writterFormatsToAll.size()]));
			else
				readFile(pathFile, writterFormats.toArray(new String[writterFormats.size()]));
			
			writterFormats.clear();
		}
			
	}
	
	private static void readFile(String pathFile, String... writterFormats) {
		if (pathFile.endsWith(".xlsx"))
			new RCensusExcel(writterFormats).read(pathFile);
	}
}
