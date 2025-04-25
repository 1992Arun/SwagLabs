package org.utility;

	import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.remote.RemoteWebDriver;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;


	public class Utility extends BaseClass{
		
		public static Sheet sheet;
		
		public static Properties pr;
		
		public static String getProperty(String value){
			
			Properties p = new Properties();
			
			FileReader fr;		
			
			try {
				fr = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\Config.properties");
				
				p.load(fr);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
			String property = p.getProperty(value);
			
			return property;
			
		}
		
	  
		 public static void jvmReport(String json) {
			 
			  
			 File f = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\Reports\\AutomationExercise.html");
			 
			 Configuration conf = new Configuration(f,"JvmReport");
			 
			 conf.addClassifications("User Name", System.getProperty("user.name"));
			 
			 conf.addClassifications("OS", System.getProperty("os.name"));
			 
			 conf.addClassifications("Jave Version", System.getProperty("java.version"));
			 
			 conf.addClassifications("Browser Name", ((RemoteWebDriver)driver).getCapabilities().getBrowserName());
			 
			 conf.addClassifications("Browser Version", ((RemoteWebDriver)driver).getCapabilities().getBrowserVersion());
			 
			 List<String> li = new ArrayList<String>();
			 
			 li.add(json);
			 
			 ReportBuilder a = new ReportBuilder(li, conf);
			 
			 a.generateReports();
			 
		 }
		 
		
		
		 
//		 public static void ex() throws IOException {
//			 
//			 String[][] readExcel = readExcel();
//			 
//			 for(String[] x:readExcel) {
//				 
//				 for(String y:x) {
//					 
//					 System.out.println(y);
//				 
//				 }
//			 }
//			 
//			 
//		 }
//		 
//		 public static void main(String[] args) throws IOException {
//			
//			 ex();
//		}
			
		 
		 public static String[][] readExcel() throws IOException {
			 
			 FileInputStream is = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\NewUsers.xlsx");
			 
			 XSSFWorkbook wb = new XSSFWorkbook(is);
			 
			  sheet = wb.getSheet("USERS");
			 
			 int rown = sheet.getPhysicalNumberOfRows();
			 
			 Row row = sheet.getRow(0);
			 
			 short lastCellNum = row.getLastCellNum();
			 
			 String data[][] = new String[rown-1][lastCellNum];
			 
			 for(int i=1; i<=data.length; i++) {
				 	 
				 data[i-1][0]= cell(i,0);
				 data[i-1][1]= cell(i,1);
				 data[i-1][2]= cell(i,2);
				 data[i-1][3]= cell(i,3);
				 data[i-1][4]= cell(i,4);
				 data[i-1][5]= cell(i,5);
				 data[i-1][6]= cell(i,6);
				 data[i-1][7]= cell(i,7);
				 data[i-1][8]= cell(i,8);
				 data[i-1][9]= cell(i,9);
				 data[i-1][10]= cell(i,10);
				 data[i-1][11]= cell(i,11);
				 data[i-1][12]= cell(i,12);
				 data[i-1][13]= cell(i,13);
				 data[i-1][14]= cell(i,14);
				 data[i-1][15]= cell(i,15);
				 data[i-1][16]= cell(i,16);
				
				 
				 
				 
			 }
			 
			 return data;
		 }
		 
		 public static String cell(int rows, int col) {
			 
			 String value;
			 
			 Row row = sheet.getRow(rows);
			 
			 Cell cell = row.getCell(col);
			 
			 int cellType = cell.getCellType();
			 
			 if(cellType==1) {
				 
				 value= cell.getStringCellValue();
				 
			 } else if (DateUtil.isCellDateFormatted(cell)) {
				 
				 Date dateCellValue = cell.getDateCellValue();
				 
				 SimpleDateFormat sd = new SimpleDateFormat("MM/dd/yyyy");
				 
				  value = sd.format(dateCellValue);
				 
			 }else {
				 
				 
				 double numericCellValue = cell.getNumericCellValue();
				 
				 long l = (long)numericCellValue;
				 
				 value = String.valueOf(l);
				 
			 }
			 
			 return value;
			 
		 }
		 
		 public static void writeProperty(String key, String value) {
				
			
				
				if(pr==null) {
					
					pr = new Properties();
				}
				 
				pr.setProperty(key, value);
				 
				  
				 try {
					 FileOutputStream fo = new FileOutputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Config.properties");
						
					 pr.store(fo, "new data");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 
				
				 
			 }
		
		
	}



