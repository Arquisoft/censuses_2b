package es.uniovi.asw.parser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class RCensusExcel extends RCensus implements ReadCensus{

	@Override
	public List<VoterInfo> read(String... paths) {
		XSSFWorkbook wb;
		XSSFSheet sheet;
		Iterator<Row> rows;
		Row row;
		VoterInfo voterInfo;
		
		List<VoterInfo> voterValues = new ArrayList<VoterInfo>();
		
		for (String path:paths) {
			this.currentFile = new File(path);
			
			try {
				wb = new XSSFWorkbook(this.currentFile);
				sheet = wb.getSheetAt(0);
				rows = sheet.iterator();
				
				//First line (headers in excel file)
				rows.next();
				
				while (rows.hasNext()) {
					row = rows.next();
					
					voterInfo = new VoterInfo(row.getCell(0) != null ? row.getCell(0).toString() : null,
							row.getCell(1) != null ? row.getCell(1).toString() : null,
							row.getCell(2) != null ? row.getCell(2).toString() : null,
							row.getCell(3) != null ? row.getCell(3).toString() : null);
					
					
					//Row empty, without cells
					if (!voterInfo.isEmpty())
						voterValues.add(voterInfo);
					
					
				}
								
			} catch (Exception e) {
				e.printStackTrace();//Error fichero no existe
			}
		}
		
		return voterValues;
	}

	
}
