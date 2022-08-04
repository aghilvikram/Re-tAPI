package learning.restassured.datadrivern;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriven {
	static String fileName = "C:\\Users\\qapiapi04\\eclipse-workspace\\RestAssured\\Dataxlsx\\RestAssuredDataDriven.xlsx";
	static String sheetName = "booksapidata";
	static String testcaseLiteral = "TestCases";
	static String testcaseName="bookOne";
	static Map<String, Integer> rowcolmap;
	// String fileName, String sheetName, String testcaseLiteral
	public static Map<String, Integer> searchForTestCase(String fileName,String sheetName,String testcaseLiteral) throws Exception {
		
		  rowcolmap = new HashMap<>();
		FileInputStream fis = new FileInputStream(fileName);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		int numberOfSheets = wb.getNumberOfSheets();
		System.out.println("total number of sheets: " + numberOfSheets);
		int columnNumber = -1;
		int rowNumber = -1;
		for (int i = 0; i < numberOfSheets; i++) {
			if (wb.getSheetName(i).equalsIgnoreCase(sheetName)) {
				//System.out.println("sheet name is: booksapidata");
				XSSFSheet xssfSheet = wb.getSheetAt(i);
				Iterator<Row> rowiterator = xssfSheet.rowIterator();
				boolean isFound = false;
				int rowIndex = 0;
				while (rowiterator.hasNext()) {
					 Row currentRow = rowiterator.next();
					Iterator<Cell> cellIterator = currentRow.cellIterator();
					int columnIndex = 0;
					while (cellIterator.hasNext()) {
						Cell currentCell = cellIterator.next();
						if (currentCell.getStringCellValue().equals(testcaseLiteral)) {
							columnNumber = columnIndex;
							isFound = true;
							break;
						}
						columnIndex++;
					}
					if (isFound) {
						rowNumber = rowIndex;
						break;
					}
					rowIndex++;
				}
				rowcolmap.put("row", rowNumber);
				rowcolmap.put("column", columnNumber);
			}
		}
		System.out.println(rowcolmap);
		return rowcolmap;
	}

	public static ArrayList<Object> getDataforTestCase(Map<String, Integer> rowcolmap, String fileName, String sheetName,
			String testcaseName) throws Exception {
		FileInputStream fis = new FileInputStream(fileName);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		ArrayList<Object> inputDataList = new ArrayList<>();

		Iterator<Sheet> sheetIterator = wb.iterator();
		while (sheetIterator.hasNext()) {
			Sheet currentSheet = sheetIterator.next();
			if (currentSheet.getSheetName().equals(sheetName)) {
				Integer rowNumber = rowcolmap.get("row")+1;
				Integer columnnumber = rowcolmap.get("column");

				Integer rowIndex = 0;
				int columnIndex = 0;

				Iterator<Row> rowIterator = currentSheet.iterator();
				while (rowIterator.hasNext()) {
					if (rowIndex >= rowNumber) {
						Row currentRow = rowIterator.next();
						if (currentRow.getCell(columnnumber).toString().equals(testcaseName)) {
							columnnumber++;
							Iterator<Cell> cellIterator = currentRow.cellIterator();
							while (cellIterator.hasNext()) {
								if(columnIndex>=columnnumber) {
								Cell currentCell = cellIterator.next();
							if (currentCell.getCellType().equals(CellType.STRING)) {
									inputDataList.add(currentCell.getStringCellValue());
								} else {
									 String ConvertedCellValue = NumberToTextConverter
											.toText(currentCell.getNumericCellValue());
									inputDataList.add(ConvertedCellValue);
								}
							columnIndex++;
							}else
								cellIterator.next();
								columnIndex++;
							}
						
						}
						rowIndex++;
					} else {
						rowIterator.next();
						rowIndex++;
					}
				}
			}
		}
		System.out.println(inputDataList);
		return inputDataList;
	}

	public static void main(String[] args) throws Exception {
		Map<String, Integer> searchForTestCase = searchForTestCase(fileName,sheetName,testcaseLiteral);
		Integer row = searchForTestCase.get("row");
		System.out.println(row);

		getDataforTestCase( rowcolmap, fileName, sheetName, testcaseName);
	}

}
