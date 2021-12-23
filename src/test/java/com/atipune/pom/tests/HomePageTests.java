package com.atipune.pom.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.atipune.pom.pages.HomePage;

public class HomePageTests extends TestBase {

	HomePage homepage;
	
	
	@BeforeClass
	public void setup() {
		initDriver();
		homepage=new HomePage(driver);
		driver.get("http://practice.automationtesting.in/");
		driver.manage().window().maximize();
	}
	@Test
	public void verifyNewArrivalsDisplayed() {
		boolean arrivalsActual=homepage.newArrivalsIsDisplayed();	
		Assert.assertTrue(arrivalsActual);
 	}
	
	@Test
	public void verifyNewArrivalsEnabled() {
		boolean arrivalsActual=homepage.newArrivalsIsEnabled();	
		Assert.assertTrue(arrivalsActual);
 	}
	
	
	@Test
	public void verifyFirstBookTitle() {
		String expectedTitleBook="Selenium Ruby";
		String actualTitleBook=homepage.getElementText(); 
		Assert.assertEquals(actualTitleBook,expectedTitleBook);
 	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
}
