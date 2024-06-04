package calculator;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalculatorIntegrationTest
{
	
	private WebDriver driver;
	
	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		//driver.get("https://nuix.github.io/SDET/senior-sdet/productionCalc/index.html");
		driver.get("https://nuix.github.io/SDET/senior-sdet/stagingCalc/index.html");
	}
	
	
	@Test
	public void testAddition() {
		WebElement num1 = driver.findElement(By.xpath("//input[@value='1']"));
		num1.click();
		
		driver.findElement(By.id("add")).click();
		
		WebElement num2 = driver.findElement(By.xpath("//input[@value='2']"));
		num2.click();
		
		driver.findElement(By.xpath("//input[@value='=']")).click();
		
		WebElement result = driver.findElement(By.id("display"));
		String additionResult = result.getText();
		
		assertEquals("3", additionResult);
		
	}
	
	@Test
	public void testSubstraction() {
		WebElement num1 = driver.findElement(By.xpath("//input[@value='6']"));
		num1.click();
		
		driver.findElement(By.id("subtract")).click();
		
		WebElement num2 = driver.findElement(By.xpath("//input[@value='3']"));
		num2.click();
		
		driver.findElement(By.xpath("//input[@value='=']")).click();
		
		WebElement result = driver.findElement(By.id("display"));
		String additionResult = result.getText();
		
		assertEquals("3", additionResult);
		
	}
	
    // input 5 is not working as expected it is display 6 while click on button 5
	@Test
	public void testMultiplication() {
		WebElement num1 = driver.findElement(By.xpath("//input[@value='4']"));
		num1.click();
		
		driver.findElement(By.id("multiply")).click();
		
		WebElement num2 = driver.findElement(By.xpath("//input[@value='5']")); // 
		num2.click();
		
		driver.findElement(By.xpath("//input[@value='=']")).click();
		
		WebElement result = driver.findElement(By.id("display"));
		String additionResult = result.getText();
		
		assertEquals("20", additionResult);
		
	}
	
	@Test
	public void testDivision() {
		WebElement num1 = driver.findElement(By.xpath("//input[@value='8']"));
		num1.click();
		
		driver.findElement(By.id("divide")).click();
		
		WebElement num2 = driver.findElement(By.xpath("//input[@value='2']"));
		num2.click();
		
		driver.findElement(By.xpath("//input[@value='=']")).click();
		
		WebElement result = driver.findElement(By.id("display"));
		String additionResult = result.getText();
		
		assertEquals("4", additionResult);
		
	}
	
	@Test
	public void testDivisionByZero() {
		WebElement num1 = driver.findElement(By.xpath("//input[@value='2']"));
		num1.click();
		
		driver.findElement(By.id("divide")).click();
		
		WebElement num2 = driver.findElement(By.xpath("//input[@value='0']"));
		num2.click();
		
		driver.findElement(By.xpath("//input[@value='=']")).click();
		
		WebElement result = driver.findElement(By.id("display"));
		String additionResult = result.getText();
		
		assertEquals("Error", additionResult);
		
	}
	
	
	@AfterTest
	public void tearTown() {
		driver.quit();
	}

}
