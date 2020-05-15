package support;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.common.collect.ImmutableMap;

import cucumber.api.Scenario;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class DriverQAM {

	private static AppiumDriver<MobileElement> driver;
	@SuppressWarnings("unused")
	private static Scenario cenario;
	
	public DriverQAM(Scenario cenario) {
		DriverQAM.cenario = cenario;
	}
	
	public void start(String OS) {
		
		String URL_STRING = "http://127.0.0.1:4723/wd/hub";
		
		URL url = null;
		
		try {
			url = new URL(URL_STRING);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		
		switch (OS) {
		case "ChromeMobile":
			desiredCapabilities.setCapability("platformName", "Android");
			desiredCapabilities.setCapability("deviceName", "emulator-5554");
			desiredCapabilities.setCapability("noReset", true);
			desiredCapabilities.setCapability("browserName", "Chrome");
			desiredCapabilities.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));
			
			driver = new AndroidDriver<MobileElement>(url, desiredCapabilities);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			break;
		}

	}
	
    public void openURL(String parUrl) {
        driver.get(parUrl);
    }
    
    private String getAttributeType(String... parType) {
        String type;
        if (parType.length == 0) {
            type = "id";
        } else {
            type = parType[0];
        }
        return type;
    }
    
    public WebElement findElem(String parValue, String... parType) {
        String param2 = getAttributeType(parType);
        WebElement element = null;

        try {
            switch (param2) {
                case "id":
                    element = driver.findElement(MobileBy.id(parValue));
                    break;
                case "name":
                    element = driver.findElement(MobileBy.name(parValue));
                    break;
                case "css":
                    element = driver.findElement(MobileBy.cssSelector(parValue));
                    break;
                case "xpath":
                    element = driver.findElement(MobileBy.xpath(parValue));
                    break;
                case "link":
                    element = driver.findElement(MobileBy.linkText(parValue));
                    break;
                case "partialLink":
                    element = driver.findElement(MobileBy.partialLinkText(parValue));
                case "class":
                    element = driver.findElement(MobileBy.className(parValue));
                case "accessid":
                    element = driver.findElementByAccessibilityId(parValue);
                    break;
                case "resourceid":
                    element = driver.findElement(By.xpath("//*[@resource-id='" + parValue + "']"));
                    break;
                case "cd": // Content-desc
                    element = driver.findElement(By.xpath("//*[@content-desc='" + parValue + "']"));
                    break;
                case "text": // Content-descwaitElementContainsTobeClickable
                    element = driver.findElement(By.xpath("//*[@text='" + parValue + "']"));
                    break;
                case "contains":
                    //element = driver.findElement(By.xpath("//*[contains(@content-desc,'" + parValue + "') or @text='" + parValue + "']"));
                    element = driver.findElement(By.xpath("//*[contains(@content-desc,'" + parValue + "') or contains(@text,'" + parValue + "')]"));
                    break;
            }
        } catch (NoSuchElementException e) {
            element = null;
        }
        return element;
    }
    
    public void sendKeys(String parText, String parName, String... parType) {
        WebElement element = findElem(parName, parType);
        element.sendKeys(parText);
    }
    
    public void waitSeconds(int time) {
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }
    
	public void report(Scenario cenario, boolean status, String msg, boolean printScreen) {

		cenario.write(msg);

		if (printScreen) {
			cenario.embed(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES), "image/png");
		}

		if (status == false) {
			Assert.fail(msg);
		}

	}
    
    public void stop() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
	
}
