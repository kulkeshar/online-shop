import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Onlineorder {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rkulk\\OneDrive\\Desktop\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Account registration >>>>>>>>

	     driver.get("https://qatest.commentsoldrt.com/webstore-register?destination=/account");
	     driver.findElement(By.cssSelector("input[id=\"customer-first-name\"]")).sendKeys("Kul");
	     driver.findElement(By.cssSelector("input[id=\"customer-last-name\"]")).sendKeys("Rimal");
	     driver.findElement(By.cssSelector("input[type=\"email\"]")).sendKeys("kulrima2@gmail.com");
	     driver.findElement(By.cssSelector("input[type=\"password\"]")).sendKeys("Kulrimal77");
	     driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
	     driver.findElement(By.xpath("(//input[@class=\"default-input\"])[2]")).sendKeys("4157805467");
	     driver.findElement(By.cssSelector("button[id=\"pink-button\"]")).click();
	     driver.quit();

		// for login account>>>>>>
		driver.get("https://qatest.commentsoldrt.com/webstore-login?destination=/account");
		driver.findElement(By.xpath("(//input[@type=\"email\"])[1]")).sendKeys("kulrima@gmail.com");
		driver.findElement(By.xpath("(//input[@type=\"password\"])[1]")).sendKeys("Kulrimal77");
		driver.findElement(By.cssSelector("button[class=\"ws-v2-button-primary mt-1r\"]")).click();

		// Adding to the cart >>>>>>
		driver.findElement(By.xpath("(//a[@href=\"/store\"])[1]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.findElement(By.xpath(
				"(//a[@class=\"text-nav lg:text-nav-lg inline-block my-4 border-transparent hover:border-current uppercase\"])[2]"))
				.click();

		driver.findElement(By.cssSelector("img[alt=\"Product: Velvet Duvet Cover\"]")).click();

		driver.findElement(By.xpath("(//label[@class=\"absolute inset-0 z-20 opacity-0 cursor-pointer\"])[3]")).click();
		driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();
		driver.findElement(By.cssSelector("a[href=\"/checkout\"]")).click();

		// order note>>>>>>

		driver.findElement(By.cssSelector("button[class=\"_pill-button\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("textarea[placeholder=\"Type your order notes here...\"]")).click();
		driver.findElement(By.cssSelector("textarea[placeholder=\"Type your order notes here...\"]"))
				.sendKeys("no damage please");
		driver.findElement(By.cssSelector("button[id=\"back\"]")).click();

		// shipping address>>>>>>>
		driver.findElement(By.xpath("(//button[@class=\"_pill-button\"])[2]")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("input[autocomplete=\"address-line1\"]")).click();
		driver.findElement(By.cssSelector("input[autocomplete=\"address-line1\"]")).sendKeys("123 MAIN");
		driver.findElement(By.cssSelector("input[name=\"locality\"]")).sendKeys("");
		WebElement drop = driver.findElement(By.cssSelector("select[name=\"state\"]"));
		Select select = new Select(drop);
		select.selectByValue("NY");
		driver.findElement(By.cssSelector("input[autocomplete=\"postal-code\"]")).sendKeys("12345");
		driver.findElement(By.cssSelector("button[id=\"save-button\"]")).click();

		// switching iframe
		// payment
		driver.findElement(By.xpath("//label[contains(@for, 'credit-card')]")).click();

		WebElement card = driver.findElement(By.cssSelector("iframe[title=\"Secure card payment input frame\"]"));
		driver.switchTo().frame(card);

		
		driver.findElement(By.cssSelector("input[name=\"cardnumber\"]")).sendKeys("4242 4242 4242 4242 ");
		driver.findElement(By.cssSelector("input[name=\"exp-date\"]")).sendKeys("11/30");
		driver.findElement(By.cssSelector("input[name=\"cvc\"]")).sendKeys("111");
		driver.findElement(By.cssSelector("input[name=\"postal\"]")).sendKeys("12345");

		driver.switchTo().parentFrame();
		driver.findElement(By.cssSelector("button[id=\"stripe-button\"]")).click();

		// Add coupon
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[contains(text(),'Add Code ')]")).click();
		driver.findElement(By.cssSelector("input[placeholder=\"Enter Code\"]")).sendKeys("1TIMEONLY");
		driver.findElement(By.id("save-button")).click();
		driver.findElement(By.cssSelector("button[class=\"_cta-button\"]")).click();
		//logout
		driver.findElement(By.cssSelector("a[class=\"webstore-checkout-btn\"]")).click();
		driver.quit();
		
		//THANK YOU

	}

}
