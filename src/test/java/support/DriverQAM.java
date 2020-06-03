package support;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

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
				// element = driver.findElement(By.xpath("//*[contains(@content-desc,'" +
				// parValue + "') or @text='" + parValue + "']"));
				element = driver.findElement(By.xpath(
						"//*[contains(@content-desc,'" + parValue + "') or contains(@text,'" + parValue + "')]"));
				break;
			}
		} catch (NoSuchElementException e) {
			element = null;
		}
		return element;
	}

	public void clear(String parValue, String... parType) {
		try {
			WebElement element = findElem(parValue, parType);
			element.clear();
		} catch (Exception e) {
			report(cenario, false, "Não foi possível limpar campo " + parValue, true);
		}
	}

	public void moveToElementJs(String parValue, String... parType) {

		WebElement element = findElem(parValue, parType);

		try {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			waitSeconds(1);
		} catch (Exception e) {
			report(cenario, false, "Não foi possível mover para o elemento " + parValue, true);
		}

	}

	public void moveToElement(String parValue, String... parType) {

		WebElement element = findElem(parValue, parType);

		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN);
		actions.moveToElement(element).click().perform();

	}

	public List<WebElement> findListElements(String parValue, String... parType) {
		List<WebElement> element = (List<WebElement>) findElem(parValue, parType);
		return element;
	}

	public String getText(String parValue, String... parType) {

		try {
			WebElement element = findElem(parValue, parType);
			return element.getText();
		} catch (Exception e) {
			report(cenario, false, "Não foi possível o texto do elemento " + parValue, true);
			return null;
		}
	}

	public void sendEnter() {
		driver.getKeyboard().sendKeys(Keys.ENTER);
	}

	public void sendKeysTab(String texto, String parValue, String... parType) {
		WebElement element = findElem(parValue, parType);
		element.sendKeys(texto, Keys.TAB);
	}

	public void sendKeys(String parText, String parName, String... parType) {
		WebElement element = findElem(parName, parType);
		element.sendKeys(parText);
	}

	public void selectByText(String parText, String parName, String... parType) {
		try {
			WebElement element = findElem(parName, parType);
			Select dropdown = new Select(element);
			dropdown.selectByVisibleText(parText);
		} catch (Exception e) {
			report(cenario, false, "Não foi possível selecionar item " + parText + " no combobox " + parName, true);
		}
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

	public void waitElement(String parName, String parType) {

		boolean isVisible = true;

		try {
			WebDriverWait wait = new WebDriverWait(driver, 60);

			switch (parType) {
			case "id":
				if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(parName))) == null) {
					isVisible = false;
				}
				break;

			case "class":
				if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(parName))) == null) {
					isVisible = false;
				}
				break;
			}

			if (!isVisible) {
				report(cenario, false, "Falha ao aguardar o elemento " + parName, true);
			}

		} catch (Exception e) {
			report(cenario, false, "Erro ao aguardar o elemento " + parName, true);
		}

	}

	public void stop() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}

	public void click(String parValue, String... parType) {
		WebElement element = findElem(parValue, parType);
		element.click();
	}

	public boolean waitElementTimeOut(String parName, String parType, int timeOut) {

		boolean retorno = false;

		try {
			WebDriverWait wait = new WebDriverWait(driver, timeOut);

			switch (parType) {
			case "id":
				if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(parName))) != null) {
					retorno = true;
				}
				break;

			case "class":
				if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(parName))) != null) {
					retorno = true;
				}
				break;

			case "xpath":
				if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(parName))) != null) {
					retorno = true;
				}
				break;

			case "css":
				if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(parName))) != null) {
					retorno = true;
				}
				break;
			}

			return retorno;

		} catch (Exception e) {
//			report(cenario, false, "Erro ao aguardar o elemento " + parName, true);
			return retorno;
		}

	}

	public void browserScroll(String direction, int coordinate) {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		try {
			switch (direction) {
			case "up":
				js.executeScript("window.scrollBy(0,-" + Integer.toString(coordinate) + ")");
				break;

			case "down":
				js.executeScript("window.scrollBy(0," + Integer.toString(coordinate) + ")");
				break;

			case "left":
				js.executeScript("window.scrollBy(-" + Integer.toString(coordinate) + ",0)");
				break;

			case "right":
				js.executeScript("window.scrollBy(" + Integer.toString(coordinate) + ",0)");
				break;
			}

			waitSeconds(1);

		} catch (Exception e) {
			report(cenario, false, "Não foi possível fazer o scroll " + direction, true);
		}
	}
	
}
