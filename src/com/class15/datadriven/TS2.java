package com.class15.datadriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.opencsv.CSVReader;

public class TS2 {
	@SuppressWarnings("resource")
	static void m1() throws IOException {
		FileReader reader = new FileReader("./testdata/promotedata.csv");
		CSVReader r = new CSVReader(reader);
		
		List<String[]> readAll = r.readAll();
		for (String[] strings : readAll) {
			for (String strings2 : strings) {
				System.out.print(strings2.charAt(0));
				System.out.println(strings2.charAt(1));
			}
		}
	}
	
	@SuppressWarnings("resource")
	static void m2() throws IOException, ParseException
	{
		FileReader reader = new FileReader("./testdata/promotedata.json");
		JSONParser jsonParser = new JSONParser();
		JSONObject json=(JSONObject) jsonParser.parse(reader);
		
		Object data = json.get("id");
		System.out.println(data);
	}
	
	static void m3() throws IOException
	{
		FileInputStream f =new FileInputStream("./testdata/insta.properties");
		Properties p=new Properties();
		p.load(f);
		
		String fname = (String) p.get("firstname");
		System.out.println(fname);
	}
	
	@SuppressWarnings("resource")
	static void m4() throws EncryptedDocumentException, IOException
	{
		FileInputStream file = new FileInputStream("./testdata/fb.xlsx");
		Workbook w = WorkbookFactory.create(file);
		
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				WebDriver d = new ChromeDriver();
				d.manage().window().maximize();
				d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

				String url = w.getSheet("Sheet1").getRow(1).getCell(0).toString();
				String campaignName  = w.getSheet("Sheet1").getRow(1).getCell(1).toString();
				String expectedRevenue = w.getSheet("Sheet1").getRow(1).getCell(2).toString();
				
				d.get(url);
				d.findElement(By.name("campaign_name")).sendKeys(campaignName);
				d.findElement(By.name("expected_revenue")).sendKeys(expectedRevenue);
				
	}
	
	
	
	public static void main(String[] args) throws IOException, ParseException {
		m4();
	}
}
