package testscripts.regression;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDemo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		String currentDirectory=System.getProperty("user.dir");
		
		String excelDataPath=currentDirectory+"\\src\\test\\resources\\testdata\\excels\\LoginCredentials.xlsx";
		
		System.out.println(excelDataPath);
		
		FileInputStream f=new FileInputStream(new File(excelDataPath));
		
		XSSFWorkbook wb=new XSSFWorkbook(f);
        
		XSSFSheet ws=wb.getSheet("credentials");
		
		System.out.println(ws.getLastRowNum());

	}

}
