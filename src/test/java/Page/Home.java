package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home extends Base {

	@FindBy(xpath = "//h1[normalize-space()='Logged In Successfully']")
	private WebElement logo;

	public Home(WebDriver driver) {
		super(driver);
	}

	public String logoPresent() {
		String logoname = logo.getText();
		return logoname;
	}
}
