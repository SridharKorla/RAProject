import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC1
{

	public static void main(String[] args) throws InterruptedException
	{
		// TODO Auto-generated method stub	
		// This comment is for testing purposes only	0840
		System.setProperty("webdriver.chrome.driver","C:\\Users\\n0180400\\eclipse-workspace\\SeleniumTests\\src\\test\\java\\chromedriver.exe");		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");		
		Thread.sleep(8000);		
		driver.findElement(By.name("q")).sendKeys("Liberty Mutual") ;
		Thread.sleep(4000);		
		driver.findElement(By.name("btnK")).click();  
		driver.close();
	}
}
