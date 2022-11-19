package variousConcepts;

import java.beans.Statement;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class VariousConcepts {
	// dropdown method with arguments. to be able to use multiple dropdowns.
	public void selectFromDropdown(WebElement element, String visibleText) {
		Select sel = new Select(element);
		sel.selectByVisibleText(visibleText);

	}
	//generate random numbers
	public int generateRndomNum(int boundryNum) {
		Random rnd = new Random();
		int generatedNum = rnd.nextInt(boundryNum);
		return generatedNum;
	}
	// initiate browser
	public void init() {
		
		System.setProperty("webdriver.chrome.driver", "path");
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://www.techfios.com/billing/?ng=login/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	// using this method u are able to find out if file exist. by using the while loop and making sure it is not null
	public static void doesFileExist(String path) {
		String path1 = "src\\data\\textFile";

		File f = new File(path1);
		FileReader fr;

		try {

			fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);

			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);

				br.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void readConfig() {
		// InputStream //BufferedReader //FileReader //Scanner

		try {
			InputStream input = new FileInputStream("config\\config.properties");
			Properties prop = new Properties();
			prop.load(input);
			prop.getProperty(" this method to get whatever u are trying to get from properties file");
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	
	}
	
	// Take Screen Shot requires apache commions.IO dependency
	
	public void takeScreenShot(WebDriver driver) {
		
	TakesScreenshot ts = (TakesScreenshot)driver;
//	File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	File sourceFile = ts.getScreenshotAs(OutputType.FILE);
	String currentDirectory = System.getProperty("user.dir");
	
	SimpleDateFormat formatter = new SimpleDateFormat("MMddyy_HHmmss");
	Date date = new Date();
	String label = formatter.format(date);
	
	try {
		FileUtils.copyFile(sourceFile, new File(currentDirectory + "/screenshots/" + label + ".png"));
	} catch (IOException e) {
		e.printStackTrace();
		
}
		
	}
	
	
	
	//Read files from MySQL	

	Connection connection;
	Statement statement;
	ResultSet resultset;
	String columnValue;
	List<String> valAsList;

	public String getDataFromDb(String columnName) {

		// set properties for mySQL
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			String sqlUsername = "root";
			String sqlPassword = "root";
			String sqlUrl = "jdbc:mysql://127.0.0.1:3306/april2022";
			String sqlQurey = "Select * from users;";

			// Create connection to the local database
			connection = DriverManager.getConnection(sqlUrl, sqlUsername, sqlPassword);

			// empowering connection reference variable to execute queries
			statement = connection.createStatement();

			// Delivering query
			resultset = statement.executeQuery(sqlQurey);

			while (resultset.next()) {
				columnValue = resultset.getString(columnName);
				return columnValue;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (resultset != null) {
				try {
					resultset.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return columnValue;

	}
	
	//RestAssured . Automation.
	String baseUri = "https://techfios.com/api-prod/api/product";
	
	/*	01. ReadAllProducts
		HTTP Method: GET
		url=https://techfios.com/api-prod/api/product/read.php
		Header/s:
		Content-Type=application/json; charset=UTF-8
		Authorization:
		basic auth = username,password
		StatusCode= 200 OK
		*/
		
	
	
		@Test
		public void readAllProducts() {
			
			/*
			given: all input details(baseURI,Headers,Authorization,Payload/Body,QueryParameters)
			when: submit api requests(Http method,Endpoint/Resource)
			then: validate response(status code, Headers,/ responseTime, Payload/Body)
			*/
			
			
			Response response =	
			
			given()
				.baseUri(baseUri)
				.header("Content-Type","application/json; charset=UTF-8")
				.auth().preemptive().basic("demo@techfios.com", "abc123").
			when()
				.get("/read.php").
			then()
				.extract().response();
			
			int responseCode = response.getStatusCode();
			System.out.println("Response Code:" + responseCode);
			Assert.assertEquals(responseCode, 200);
			
			Long responseTime = response.getTimeIn(TimeUnit.MILLISECONDS);
			System.out.println("Response Time:" + responseTime);
			if(responseTime<=2000) {
				System.out.println("Response Time within range.");
				
			}else
			System.out.println("Response Time out of range!!!");
			
			String responseHeader = response.getHeader("Content-Type");
			System.out.println("Response Header:" +responseHeader);
			Assert.assertEquals(responseHeader, "application/json; charset=UTF-8");
			
			String responseBody = response.getBody().asString();
		//	System.out.println(responseBody);


			JsonPath jp = new JsonPath(responseBody);
			String firstproductId = jp.get("records[0].id");
			System.out.println("First Product ID:" + firstproductId);
			if(firstproductId != null) {
				System.out.println("Response body contains first product id.");
				
			}else
			System.out.println("Response body does not contain first product id.");
			
		}
}
