package utilities;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebdriverUtil {

	private WebDriver driver;

	public WebDriver getDriver() {

		if (driver == null) {
			WebDriverManager.chromedriver().setup();
			String downloadFilePath = System.getProperty("user.dir") + "/Selenium";
			Map<String, Object> prefs = new HashMap<>();
			prefs.put("Selenium.default_directory", downloadFilePath);
			prefs.put("profile.default_content_settings.popups", 0);

			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", prefs);

			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
		}
		return driver;
	}

}
