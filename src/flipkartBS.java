import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.remote.RemoteWebDriver;

public class flipkartBS {
	
	public static final String USERNAME = "meghfonseca1";
	public static final String AUTOMATE_KEY = "4qMAsYZA6G2iyCh2PuzS";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

	public static void main(String[] args) throws InterruptedException, MalformedURLException {
		
		DesiredCapabilities caps = new DesiredCapabilities();
	    caps.setCapability("browser", "Chrome");
	    caps.setCapability("browser_version", "77.0 beta");
	    caps.setCapability("os", "Windows");
	    caps.setCapability("os_version", "10");
	    caps.setCapability("resolution", "1024x768");
	    caps.setCapability("name", "Bstack-[Java] Sample Test");
		
	//	System.setProperty("webdriver.chrome.driver", "C:\\Users\\megh.f\\Downloads\\chromedriver.exe"); 				// invoke .exe

	//	WebDriver driver = new ChromeDriver();
	    WebDriver driver = new RemoteWebDriver(new java.net.URL(URL), caps);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://www.flipkart.com/");

		driver.findElement(By.cssSelector("button[class='_2AkmmA _29YdH8']")).click();									//Close Log In popup

		WebElement search = driver.findElement(By.cssSelector("input[name='q']"));										//Object creation for Web Element
		search.sendKeys("iPhone 6");
		search.sendKeys(Keys.ENTER);

		driver.findElement(By.linkText("Mobiles")).click();																//Click on Mobiles				

		Select s = new Select(driver.findElement(By.xpath("//div[@class='_1qKb_B']//select")));							//Object creation using select method
		s.selectByValue("30000");
		Thread.sleep(5000L);

		driver.findElement(By.xpath("//section[5]//div[2]//div[1]//div[1]//div[1]//div[1]//label[1]//div[1]")).click(); // Checkbox Apple
		Thread.sleep(5000L);

		driver.findElement(By.cssSelector("div[class='_1p7h2j _2irnD_']")).click(); 									// Checkbox Flipkart Assured

		for (int i = 0; i < 24; i++) {

			System.out.println("INR" + driver.findElement(By.cssSelector("div[class='_1vC4OE _2rQ-NK']")).getText());  // Price
			System.out.println(driver.findElement(By.cssSelector("div[class='_3wU53n']")).getText()); 					// Product Nam
			System.out.println(driver.findElement(By.cssSelector("a[class='_31qSD5']")).getAttribute("href")); 			// Link
			System.out.println(" ");
		}

		driver.quit();
	}

}
