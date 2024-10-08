package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login extends Base {
	
	@FindBy(xpath = "//input[@id='username']")
	private WebElement username;
	
	@FindBy(xpath = "//input[@id='password']")
	private WebElement password;
	
	@FindBy(xpath = "//button[@id='submit']")
	private WebElement submit;
	
	public Login(WebDriver driver) {
		super(driver);
	}
	
	public void enterUsername(String user) {
		username.sendKeys("student");
	}
	
	public void enterPassword(String pass) {
		password.sendKeys("Password123");
	}
	
	public void clicksubmit() {
		submit.click();
	}
	

}
