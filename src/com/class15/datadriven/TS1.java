package com.class15.datadriven;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.opencsv.CSVReader;

public class TS1 {

	static void m1() throws IOException, ParseException {
		FileReader f = new FileReader("./testdata/jsonDATA.json");
		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse(f);

		// Load the driver
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		// Load the web driver
		WebDriver d = new ChromeDriver();
		// Maximize the screen
		d.manage().window().maximize();
		// Implicit wait
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		String url = (String) json.get("URL");
		d.get(url);
		System.out.println(json.get("username"));
		System.out.println(json.get("password"));

//		Thread.sleep(4000);
//		d.quit();
	}

	@SuppressWarnings("resource")
	static void m2() throws IOException {
		FileReader reader = new FileReader("./testdata/csvDATA.csv");
		CSVReader r = new CSVReader(reader);

		/*
		 * String[] readNext = r.readNext(); for (String string : readNext) {
		 * System.out.println(string); }
		 */
		
		List<String[]> readAll = r.readAll();
		for (String[] data : readAll) {
			for (String s : data) {
				System.out.println(s);
			}
		}
		
	}

	public static void main(String[] args) throws IOException, ParseException, InterruptedException {
		m2();
	}

}
