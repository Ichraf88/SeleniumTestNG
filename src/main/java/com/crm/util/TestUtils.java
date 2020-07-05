package com.crm.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.base.TestBase;

public class TestUtils extends TestBase {

	public TestUtils() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	public static void TakePicture(String name) throws IOException {
		File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File("TestNGcrmpro/ScreenShots" +name+".png"));
	}
	public static Object[][] getDataFromExcel(String sheetName) throws IOException {

		File file=new File("src/test/resources/testData/FreeCrmTest.xlsx");
		FileInputStream fis=new FileInputStream(file);

		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		Sheet sheet= workbook.getSheet("Feuil1");


		int rows=sheet.getLastRowNum();
		int columns=sheet.getRow(0).getLastCellNum();
		Object data[][]=new Object[rows][columns];
		for(int i=0;i<rows;i++) {
			for(int k=0;k<columns;k++) {
				data[i][k]=sheet.getRow(i).getCell(k).toString();
			}
		}
		return data;


	}

}


