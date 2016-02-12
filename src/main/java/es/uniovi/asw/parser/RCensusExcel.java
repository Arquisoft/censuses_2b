package es.uniovi.asw.parser;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class RCensusExcel extends RCensus implements ReadCensus{

	@Override
	public void read(String... paths) {
		XSSFWorkbook wb;
		XSSFSheet sheet;
		Iterator<Row> rows;
		Iterator<Cell> cells;
		
		List<String> voterValues = new ArrayList<String>();
		
		for (String path:paths) {
			this.currentFile = new File(path);
			
			try {
				wb = new XSSFWorkbook(this.currentFile);
				sheet = wb.getSheetAt(0);
				rows = sheet.iterator();
				
				//First line (headers in excel file)
				rows.next();
				
				while (rows.hasNext()) {
					cells = rows.next().cellIterator();
					
					while (cells.hasNext())
						voterValues.add(cells.next().toString());
					
					this.insertDB.insert(voterValues);
					//Generar cartas...
					
					voterValues.clear();
				}
								
			} catch (Exception e) {
				//Error fichero no existe
			}
		}
		
	}
	
}
