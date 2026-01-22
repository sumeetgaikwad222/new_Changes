package files;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Files {
	
	
	public String config(String path, String key) throws IOException
	{
		FileInputStream fis = new FileInputStream(path);
		Properties prop = new Properties();
		prop.load(fis);
		String value = prop.getProperty(key);
		fis.close();
		return value;
	}
	public String readExcel(String path, String sheetame, int rows, int columns) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetame);
		Row row = sh.getRow(rows);
		Cell cel = row.getCell(columns);
		DataFormatter df = new DataFormatter();
		String cell = df.formatCellValue(cel);
		fis.close();
		wb.close();
		return cell;
	}
	public String writeExcel(String path, String sheetame, int rows, int columns, String data) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetame);
		Row row = sh.getRow(rows);
		Cell cell = row.getCell(columns);
		cell.setCellValue(data);
		
		FileOutputStream fos = new FileOutputStream(path);
		wb.write(fos);
		
		fis.close();
		fos.close();
		wb.close();
		return data;
	}
	public int lastrow(String path, String sheetame, int rows) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetame);
		return sh.getLastRowNum();
	}
	public short lastcell(String path, String sheetame, int rows, int columns) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetame);
		Row row = sh.getRow(rows);
		return row.getLastCellNum();
	}
}
