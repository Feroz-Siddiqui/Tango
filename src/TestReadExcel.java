import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.util.CellReference;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestReadExcel {
	public static void main(String[] args) {
		
		ArrayList<ArrayList<String>>  temp =	readExcelData("C:\\Users\\Feroz\\Tango1\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\Tango\\uploads\\register.xlsx");
		for(ArrayList<String> kk :temp){
				System.out.println(kk.get(3));
		}
}
	public static ArrayList<ArrayList<String>> readExcelData(String fileName) {
		ArrayList<ArrayList<String>> celllisting = new ArrayList<>();
		try {
			FileInputStream file = new FileInputStream(new File(fileName));
			// Create Workbook instance holding reference to .xlsx file
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			// Get first/desired sheet from the workbook
			XSSFSheet sheet = workbook.getSheetAt(0);
			// Iterate through each rows one by one
			Iterator<Row> rowIterator = sheet.iterator();
			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				// For each row, iterate through all the columns
				Iterator<Cell> cellIterator = row.cellIterator();
				if (row.getRowNum() != 0) {
					ArrayList<String> temp = new ArrayList<>();

					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						switch (cell.getCellType()) {
						case Cell.CELL_TYPE_NUMERIC:
							temp.add(cell.getNumericCellValue() + "");
							break;
						case Cell.CELL_TYPE_STRING:
							temp.add(cell.getStringCellValue());
							break;
						}
					}
					celllisting.add(temp);

				}
			}

			file.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return celllisting;
	}
}
	
	
	