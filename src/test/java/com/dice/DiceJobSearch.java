package com.dice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DiceJobSearch { 
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		driver.get("https://www.dice.com/");
		
		String actualTitle=driver.getTitle();
		String expectedTitle= "Job Search for Technology Professionals | Dice.com";
		
		if(actualTitle.equals(expectedTitle)) {
			System.out.println("Step Pass. Dice homepage successfully loaded");
		} else {
			System.out.println("Step fail. Dice homepage did not load successfully");
			throw new RuntimeException("Step fail. Dice homepage did not load successfully");
		}
		
		String jobName="automation Engineer";
		String location= "60016";
		driver.findElement(By.id("search-field-keyword")).clear();
		driver.findElement(By.id("search-field-keyword")).sendKeys(jobName);
		driver.findElement(By.id("search-field-location")).clear();
		driver.findElement(By.id("search-field-location")).sendKeys(location);
		driver.findElement(By.id("findTechJobs")).click();
		
		String count= driver.findElement(By.id("posiCountId")).getText();
		System.out.println(count);
		int countResult= Integer.parseInt(count.replaceAll(",", ""));
		
		if(countResult>0) {
			System.out.println("Step pass: Job name: "+ jobName + " search returned "+ countResult+ " results in "+ location);
	
		}else {

			System.out.println("Step failed: Job name: "+ jobName + " search returned "+ countResult+ " results in "+ location);
			
				
	}
		driver.close();

}
}
