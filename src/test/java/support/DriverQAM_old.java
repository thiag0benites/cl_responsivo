package support;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofMillis;
import static java.time.Duration.ofSeconds;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.ImmutableMap;

import cucumber.api.Scenario;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;

public class DriverQAM_old {

    public static AppiumDriver driver;
    private static Scenario cenario;
    
	public DriverQAM_old(Scenario cenario) {
		DriverQAM_old.cenario = cenario;
	}

    public MobileDriver getDriver() {
        return driver;
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
            case "android":
                // DesiredCapabilities NÃO devem ser utilizadas para o Device Farm
                //desiredCapabilities.setCapability("appPackage", "com.android.chrome");
                //desiredCapabilities.setCapability("appActivity", "com.google.android.apps.chrome.Main");
                //desiredCapabilities.setCapability("browserName","");
                //desiredCapabilities.setCapability("autoWebview",true);
                //desiredCapabilities.setCapability("fullReset", "false");

                desiredCapabilities.setCapability("platformName", "Android");
                desiredCapabilities.setCapability("deviceName", "emulator-5554");
                //desiredCapabilities.setCapability("deviceName", "2921f413");
                desiredCapabilities.setCapability("automationName", "uiautomator2");
                desiredCapabilities.setCapability("autoGrantPermissions", "true");
                //desiredCapabilities.setCapability("noReset", "true");
                //desiredCapabilities.setCapability("app","C:\\Users\\HITSS\\Documents\\Gabriel\\Documentos\\Minha Claro\\Apps\\app-debugg.apk");
                desiredCapabilities.setCapability("appPackage", "com.nvt.cs");
                //desiredCapabilities.setCapability("appActivity", "com.nvt.com.minhaclaro.MainActivity");
                desiredCapabilities.setCapability("appActivity", "cs.nvt.com.minhaclaro.SplashScreenActivity");
                desiredCapabilities.setCapability("newCommandTimeout", 0);
                /* Adição de nova capability para retrocompatibilidade.
                   Após versão 1.15 do appium, ID não pode ser utilizado como seletor em Webview
                   https://github.com/appium/appium/issues/13306
                   This is expected if chromedriver is working in W3C mode.
                   The W3C standard only declares CSS and XPATH locators,
                   where location by ids and names has been dropped as obsolete, since CSS covers them.
                   There are three possible ways to workaround that:
                   - Update the unsupported locators
                   - Enforce chromedriver to JSONWP mode (set w3c chromedriver option to false)
                   - Pass the obsolete locator types to a conversion method in the client code, which automatically upgrades
                     them to CSS locators (this is what Selenium lib is currently doing)
                     https://github.com/appium/appium/issues/13306
                     https://github.com/SeleniumHQ/selenium/blob/62e867b42e503e2171f9792d706e7adba783757e/rb/lib/selenium/webdriver/remote/bridge.rb#L602-L617
                */
                desiredCapabilities.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));

                driver = new AndroidDriver<MobileElement>(url, desiredCapabilities);

                //Use a higher value if your mobile elements take time to show up.
                driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

                //this.takeScreenshot("teste Screenshot");

                // Folder to retrieve reports
                // "$DEVICEFARM_TEST_PACKAGE_PATH/*/target/surefire-reports"

                break;
            case "iphone":
                // DesiredCapabilities NÃO devem ser utilizadas para o Device Farm
                desiredCapabilities.setCapability("platformName", "iOS");
                desiredCapabilities.setCapability("deviceName", "iPhone XS Max");
                desiredCapabilities.setCapability("automationName", "XCUITest");
                desiredCapabilities.setCapability("app", "");
                desiredCapabilities.setCapability("noReset", "false ");
                desiredCapabilities.setCapability("allowTouchIdEnroll ", "true");

                driver = new IOSDriver<MobileElement>(url, desiredCapabilities);
                //Use a higher value if your mobile elements take time to show up.
                driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

                break;
            case "ChromeMobile":
            	
            	desiredCapabilities.setCapability("platformName", "Android");
            	desiredCapabilities.setCapability("deviceName", "emulator-5554");
            	desiredCapabilities.setCapability("browserName", "Chrome");
            	driver = new AndroidDriver<MobileElement>(url, desiredCapabilities);
            	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            	//WebDriverManager.chromedriver().setup();
                //desiredCapabilities.setCapability("platformName", "Android");
                
//                desiredCapabilities.setCapability("udid", "ANDROID_7");
//                desiredCapabilities.setCapability("platformVersion", "7.0");
//                desiredCapabilities.setCapability("noReset", true);
                
                //desiredCapabilities.setCapability("deviceName", "emulator-5554");
                //desiredCapabilities.setCapability("deviceName", "2921f413");
                //desiredCapabilities.setCapability("automationName", "uiautomator2");
                
                //desiredCapabilities.setCapability("autoGrantPermissions", "true");
                
                //desiredCapabilities.setCapability("appPackage", "com.android.chrome");
                //desiredCapabilities.setCapability("appActivity", "com.google.android.apps.chrome.Main");
                
                //desiredCapabilities.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
//                desiredCapabilities.setCapability("browserName", "Chrome");
                
                //desiredCapabilities.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));
                
                //driver.get("https://minhaclaro.claro.com.br");
                //driver.get("https://minhaclaro.claro.com.br/");
                //Use a higher value if your mobile elements take time to show up.
                break;
            case "Chrome":
           /*     WebDriverManager.chromedriver().setup();
                ChromeOptions optionsC = new ChromeOptions();
                // hides the info message that says chrome is being controlled by automated test software
                optionsC.addArguments(Arrays.asList(
                        "disable-infobars", "ignore-certificate-errors",
                        "disable-popup-blocking", "disable-notifications",
                        "no-sandbox"));
//                    "disable-infobars", "ignore-certificate-errors", "start-maximized","disable-popup-blocking","incognito","headless"));
                webdriver = new ChromeDriver(optionsC);
                webdriver.manage().window().setPosition(new Point(0, 0));
                webdriver.manage().window().setSize(new Dimension(1366, 768));

                try {
                    this.abrirPaginaPlanosClaro("PROD", "");
                } catch (IOException e) {
                    e.printStackTrace();
                }

                break;*/
            default:
                break;
        }
        //this.takeScreenshot("teste Screenshot");
    }

    public void abrirPaginaPlanosClaro(String env, String Msisdn) throws IOException {
        //java.io.InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("my.properties");
        //java.util.Properties properties = new Properties();
        //properties.load(inputStream);

        //String env = properties.getProperty("app.env");

        if (env.equalsIgnoreCase("LOCAL")) {
            env = ("http://localhost:3000");

        } else if (env.equalsIgnoreCase("QA")) {
            env = ("https://minhaclaroescondida.claro.com.br");

        } else if (env.equalsIgnoreCase("PROD")) {
            env = ("https://minhaclaro.claro.com.br");
        }

        switch (Msisdn) {
            case "":
                this.openURL(env);
                break;

            case "LoginHeader":
                this.openURL(env + "/mcpf/login-he.html?tel=55" + Msisdn);
                break;
        }
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public void sleep(long mili) {
        try {
            Thread.sleep(mili);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void openURL(String parUrl) {
    	driver.get(parUrl);
    }

    //Swipe by elements
    public void swipeByElements(WebElement startElement, WebElement endElement) {

        //int startX = startElement.getLocation().getX() + (startElement.getSize().getWidth() / 2);
        //int startY = startElement.getLocation().getY() + (startElement.getSize().getHeight() / 2);
        //int endX = endElement.getLocation().getX() + (endElement.getSize().getWidth() / 2);
        //int endY = endElement.getLocation().getY() + (endElement.getSize().getHeight() / 2);

        //System.out.println("START X: " + startX + " START Y:" + startY);
        //System.out.println("END X: " + endX + " END Y:" + endY);

        //new TouchAction(driver).press(point(startX, startY)).waitAction(waitOptions(ofMillis(500)))
        //        .moveTo(point(endX, endY)).release().perform();
    }

    public void testeSwipe() {
        WebElement seekBar = this.findElem("//*[@id=\"collapse180614019\"]/div[1]/div/div[1]/span[2]/span[1]/span[1]", "xpath");

        WebElement handler = this.findElem("//*[@id=\"collapse180614019\"]/div[1]/div/div[1]/span[2]/span[5]", "xpath");

        int comecoBarraX = handler.getLocation().getX();
        int comecoBarraY = handler.getLocation().getY();
        int fimBarra = seekBar.getSize().getWidth();
        //int handlerX = handler.getLocation().getX();
        //int handlerY = handler.getLocation().getY();
        //int endX = endElement.getLocation().getX() + (endElement.getSize().getWidth() / 2);
        //int endY = endElement.getLocation().getY() + (endElement.getSize().getHeight() / 2);

        //System.out.println("START X: " + startX + " START Y:" + startY);
        //System.out.println("END X: " + endX + " END Y:" + endY);

        TouchAction action = new TouchAction(driver);

        action.press(point(comecoBarraX, comecoBarraY))
                .moveTo(point(fimBarra, comecoBarraY))
                .release().perform();

        //new TouchAction(driver).
        //    press(point(comecoBarraX, comecoBarraY)).
        //    waitAction(waitOptions(ofMillis(500))).perform();
        //new TouchAction(driver).press(point(comecoBarraX, comecoBarraY)).perform();
        //.waitAction(waitOptions(ofMillis(500)))
        //.moveTo(point(endX, endY))
        //.release().perform();
    }

    public void selecionarLinha(String parValue) {
        this.waitElementAll("//tbody//*[contains(text(), \"" + parValue + "\")]//parent::*/following-sibling::*//*[@id=\"btnVisualizar\"]", "xpath");
        this.click("//tbody//*[contains(text(), \"" + parValue + "\")]//parent::*/following-sibling::*//*[@id=\"btnVisualizar\"]", "xpath");
        this.waitElementAll("//*[@id=\"menu-fixed-top-temp\"]/div/div/div[3]/div/ul[1]/li/div[1]/span[text()=\"" + parValue + "\"]", "xpath");
    }

    public void selecionarLinhaCss(String cssValue, String textValue, String idValueRow) {
        this.waitElementAll(cssValue, "css");
        List<WebElement> elements = this.findElements(cssValue, "css");
        for (WebElement element : elements) {
            if (element.getText().contains(textValue)) {
                WebElement elementRow = element.findElement(By.id(idValueRow));
                elementRow.click();
                break;
            }
        }
        //this.waitElementAll("//*[@id=\"menu-fixed-top-temp\"]/div[2]/div/div[3]/div/ul[1]/li/div[1]/span[1]/span[text()=\"" + textValue + "\"]", "xpath");
    }

    public void selecionarPacoteCss(String cssValue, String textValue, String cssValueRow) {
        this.waitElementAll(cssValue, "css");
        List<WebElement> elements = this.findElements(cssValue, "css");
        for (WebElement element : elements) {
            if (element.getText().contains(textValue)) {
                WebElement elementRow = element.findElement(By.cssSelector(cssValueRow));
                elementRow.click();
                break;
            }
        }
        //this.waitElementAll("//*[@id=\"menu-fixed-top-temp\"]/div[2]/div/div[3]/div/ul[1]/li/div[1]/span[1]/span[text()=\"" + textValue + "\"]", "xpath");
    }

    public void removerLinha(String parValue) {
        this.waitElementAll("//tbody//*[contains(text(), \"" + parValue + "\")]//parent::*/following-sibling::*//*[@id=\"btnRemover\"]", "xpath");
        this.click("//tbody//*[contains(text(), \"" + parValue + "\")]//parent::*/following-sibling::*//*[@id=\"btnRemover\"]", "xpath");
    }

    public String perdaRouboLinha(String parValue) {
        this.waitElementAll("//tbody//*[contains(text(), \"" + parValue + "\")]//parent::*/following-sibling::*//*[@class  =\"text-red padding-md-left padding-lg-top\"]", "xpath");
        return getText("//tbody//*[contains(text(), \"" + parValue + "\")]//parent::*/following-sibling::*//*[@class  =\"text-red padding-md-left padding-lg-top\"]", "xpath");
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

    public boolean isDisplayed(String parValue, String parType) {
        boolean isDisplayed = false;

        switch (parType) {
            case "id":
                isDisplayed = driver.findElement(By.id(parValue)).isDisplayed();
                break;
            case "contains":
                isDisplayed = driver.findElement(By.xpath("//*[contains(@content-desc,'" + parValue + "') or contains(@text,'" + parValue + "')]")).isDisplayed();
                break;
            case "css":
                isDisplayed = driver.findElement(By.cssSelector(parValue)).isDisplayed();
                break;
        }
        return isDisplayed;
    }

    public void clearField(String parValue, String... parType) {
        String param2 = getAttributeType(parType);
        switch (param2) {
            case "id":
                driver.findElement(MobileBy.id(parValue)).clear();
                break;
            case "name":
                driver.findElement(MobileBy.name(parValue));
                break;
            case "css":
                driver.findElement(MobileBy.cssSelector(parValue));
                break;
            case "xpath":
                driver.findElement(MobileBy.xpath(parValue));
                break;
            case "link":
                driver.findElement(MobileBy.linkText(parValue));
                break;
            case "partialLink":
                driver.findElement(MobileBy.partialLinkText(parValue));
                break;
            case "class":
                driver.findElement(MobileBy.className(parValue));
                break;
            case "accessid":
                driver.findElementByAccessibilityId(parValue);
                break;
            case "resourceid":
                driver.findElement(By.xpath("//*[@resource-id='" + parValue + "']"));
                break;
            case "cd": // Content-desc
                driver.findElement(By.xpath("//*[@content-desc='" + parValue + "']"));
                break;
            case "text": // Content-descwaitElementContainsTobeClickable
                driver.findElement(By.xpath("//*[@text='" + parValue + "']"));
                break;
            case "contains":
                //element = driver.findElement(By.xpath("//*[contains(@content-desc,'" + parValue + "') or @text='" + parValue + "']"));
                driver.findElement(By.xpath("//*[contains(@content-desc,'" + parValue + "') or contains(@text,'" + parValue + "')]"));
                break;
        }
    }

    public List<WebElement> findElements(String parValue, String... parType) {
        String param2 = getAttributeType(parType);
        List element = null;

        try {
            switch (param2) {
                case "id":
                    element = driver.findElements(By.id(parValue));
                    break;
                case "name":
                    element = driver.findElements(By.name(parValue));
                    break;
                case "css":
                    element = driver.findElements(By.cssSelector(parValue));
                    break;
                case "xpath":
                    element = driver.findElements(By.xpath(parValue));
                    break;
                case "link":
                    element = driver.findElements(By.linkText(parValue));
                    break;
                case "partialLink":
                    element = driver.findElements(By.partialLinkText(parValue));
                case "class":
                    element = driver.findElements(By.className(parValue));
            }
        } catch (NoSuchElementException e) {
            element = null;
        }
        return element;
    }

    public List<WebElement> encontrarListaElemento(String parValue, String... parType) {
        List<WebElement> element = findElements(parValue, parType);
        return element;
    }

    public void checkPdf(String param) {
        //try {
        //    PDFUtil pdfUtil = new PDFUtil();
        //    // Recupera conteúdo do PDF
        //    //String pdfText = pdfUtil.getText("/storage/emulated/0/Download/DOWNLOAD_MINHA_CLARO.pdf");
        //    String pdfText = pdfUtil.getText("/storage/emulated/0/DOWNLOAD_MINHA_CLARO.pdf");
        //    System.out.println(pdfText);
        //    boolean isPresent = pdfText.contains("total");
        //} catch (IOException e) {
        //    e.printStackTrace();
        //}

        byte[] teste = driver.pullFile("/storage/emulated/0/DOWNLOAD_MINHA_CLARO.pdf");
    }

    public void expandirNotificoes() {
        ((AndroidDriver<MobileElement>) driver).openNotifications();
    }

    public void testFingerprint() {
        ((AndroidDriver<MobileElement>) driver).fingerPrint(1);
    }

    public void clicarNotificacao() {
        this.click("android:id/status_bar_latest_event_content");
    }

    public String captureScreen(String paths) {
        this.setContext("NATIVE_APP");
        String path;
        try {
            File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            path = paths + source.getName();
            FileUtils.copyFile(source, new File(path));
        } catch (IOException e) {
            path = "Failed to capture screenshot: " + e.getMessage();
        }
        return path;
    }

    public void takeScreenshotDF(final String name) {
        String screenshotDirectory = System.getenv("DEVICEFARM_SCREENSHOT_PATH");
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        screenshot.renameTo(new File(screenshotDirectory, String.format("%s.png", name)));
    }

    public void waitElementXP(String parXp) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(parXp)));
    }

    public MobileElement findUIAutomator(String parIndex, String parValue, String... parType) {

        String param2 = getAttributeType(parType);

        MobileElement element = null;

        try {
            switch (param2) {
                case "text":
                    element = ((AndroidDriver<MobileElement>) driver).findElementByAndroidUIAutomator("new UiSelector().text(\"" + parValue + "\")");
                    break;
                case "startwithtext":
                    element = (MobileElement) ((AndroidDriver<MobileElement>) driver).findElementsByAndroidUIAutomator("new UiSelector().textStartsWith(\"" + parValue + "\")");
                    //for (MobileElement element : elementsStartingWithT) {}
                    break;
                case "textcontains":
                    element = (MobileElement) ((AndroidDriver<MobileElement>) driver).findElementsByAndroidUIAutomator("new UiSelector().textContains(\"" + parValue + "\")");
                    //for (MobileElement element : elementsTextContainsTO) {}
                    break;
                case "textMatches":
                    element = (MobileElement) ((AndroidDriver<MobileElement>) driver).findElementsByAndroidUIAutomator("new UiSelector().textMatches(\"\\w+\\s{1}\\w+\")");
                    //for (MobileElement element : elementsWith2Words) {}
                    break;
                case "resourceid":
                    element = (MobileElement) ((AndroidDriver<MobileElement>) driver).findElementByAndroidUIAutomator("new UiSelector().resourceIdMatches(\".*" + parValue + "\")");
                    break;
                case "description":
                    //Identify element using its Content Description
                    element = (MobileElement) ((AndroidDriver<MobileElement>) driver).findElementByAndroidUIAutomator("new UiSelector().description(\"" + parValue + "\")");
                    break;
                case "class":
                    element = (MobileElement) ((AndroidDriver<MobileElement>) driver).findElementByAndroidUIAutomator("new UiSelector().className(\"" + parValue + "\")");
                    break;
                case "classIndex":
                    element = (MobileElement) ((AndroidDriver<MobileElement>) driver).findElementByAndroidUIAutomator("new UiSelector().className(\"" + parValue + "\").index(" + parIndex + ")");
                    break;
            }
        } catch (NoSuchElementException e) {
            element = null;
        }
        return element;
    }

    public String getText(String parValue, String... parType) {
        WebElement element = findElem(parValue, parType);
        return element.getText();
    }

    public String getPageSource() {
        return driver.getPageSource();
    }

    public void click(String parValue, String... parType) {
        WebElement element = findElem(parValue, parType);
        element.click();
    }

    public void clickUi(String parIndex, String parValue, String... parType) {
        WebElement element = findUIAutomator(parIndex, parValue, parType);
        element.click();
    }

    public void sendKeys(String parText, String parName, String... parType) {
        WebElement element = findElem(parName, parType);
        //element.clear();
        element.sendKeys(parText);
    }

    public void sendKeysTab(String texto, String parValue, String... parType) {
        WebElement element = findElem(parValue, parType);
        element.sendKeys(texto, Keys.TAB);
    }

    public void clickSendKeys(String parText, String parName, String... parType) {
        WebElement element = findElem(parName, parType);
        //element.clear();
        this.click(parName, parType);
        this.waitSeconds(1);
        element.sendKeys(parText);
        this.esconderTeclado();
    }

    public void sendEnter() {
        driver.getKeyboard().sendKeys(Keys.ENTER);
    }

    public String checkToastMessage() {
        return this.getText("//android.widget.Toast[1]", "xpath");
    }

    public void waitSeconds(int time) {
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }

    public String getCurrentDate() {
        LocalDate localDate = LocalDate.now();
        return localDate.toString();
    }

    public String getCurrentDateMinusDays(int days) {
        LocalDate localDate = LocalDate.now().minusDays(days);
        return localDate.toString();
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

    public void closePopUp(String arg0) {
        String botaoFecharPopUp;

        try {
            if (arg0.equalsIgnoreCase("Pre-Pago")) {
                botaoFecharPopUp = ".btnCloseWalkthrough";
                this.waitElementAll(botaoFecharPopUp, "css");
                this.click(botaoFecharPopUp, "css");
            } else if (arg0.equalsIgnoreCase("Passaporte")) {
                //botaoFecharPopUp = "[onclick=\'naoAvaliar()\']";
                botaoFecharPopUp = ".btn-fechar-ri";
                this.waitElementAll(botaoFecharPopUp, "css");
                this.click(botaoFecharPopUp, "css");
                Thread.sleep(250);
            } else if (arg0.equalsIgnoreCase("Pos-Pago")) {
                //driver.switchTo().alert().dismiss();
                botaoFecharPopUp = "//*[contains(@onclick,\"lembrarMaisTarde()\") or contains(@onclick,\"lembrarMaisTarde(true)\")]";

                this.waitElementAll(botaoFecharPopUp, "xpath");
                this.click(botaoFecharPopUp, "xpath");

                //this.waitElementAll(".btn-fechar-ri", "css");
                //this.click(".btn-fechar-ri", "css");

                //Thread.sleep(500);
                //botaoFecharPopUp = ".btn-fechar-ri";
                //this.waitElementAll(botaoFecharPopUp, "css");
                //this.click(botaoFecharPopUp, "css");
                //Thread.sleep(250);
            } else if (arg0.equalsIgnoreCase("Avaliacao")) {
                botaoFecharPopUp = "//*[@onclick=\"naoAvaliar()\"]";
                this.waitElementAll(botaoFecharPopUp, "xpath");
                this.click(botaoFecharPopUp, "xpath");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else if (arg0.equalsIgnoreCase("generico")) {
                this.waitElementAll("//*[@id=\"menu-fixed-top-temp\"]//*[contains(@class,\"icon-recurso ico-pos-pago\")]", "xpath");
                botaoFecharPopUp = "//*[contains(@onclick,\"lembrarMaisTarde()\") or contains(@onclick,\"lembrarMaisTarde(true)\") or contains(@class,\"btn-fechar-ri\")]";
                this.click(botaoFecharPopUp, "xpath");
                this.click(botaoFecharPopUp, "xpath");
            } else if (arg0.equalsIgnoreCase("Roleta")) {
                this.waitElementAll("fechar-roleta", "id");
                this.click("fechar-roleta", "id");
            }
        } catch (Exception e) {
            //System.out.println("APRESENTOU ERRO ");
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
			};

			return retorno;
			
		} catch (Exception e) {
//			report(cenario, false, "Erro ao aguardar o elemento " + parName, true);
			return retorno;
		}

	}

    public void waitElementAll(String parName, String... parType) {
        //WebDriverWait wait = new WebDriverWait(driver, 90);
        WebDriverWait wait = new WebDriverWait(driver, 90);
        String param2 = getAttributeType(parType);
        try {
            switch (param2) {
                case "id":
                    wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id(parName)));
                    break;
                case "name":
                    wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.name(parName)));
                    break;
                case "css":
                    wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.cssSelector(parName)));
                    break;
                case "xpath":
                    wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath(parName)));
                    break;
                case "link":
                    wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.linkText(parName)));
                    break;
                case "class":
                    wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.className(parName)));
                    break;
                case "resourceid":
                    wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("//*[@resource-id='" + parName + "']")));
                    break;
                case "resourceidindex":
                    wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("//*[@resource-id='" + parName + "'][@index='0']")));
                    break;
                case "text":
                    wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("//*[@text='" + parName + "']")));
                    break;
                case "contains":
                    wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("//*[contains(@content-desc,'" + parName + "') or contains(@text,'" + parName + "')]")));
                    break;
                case "Accessibility":
                    wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId(parName)));
                    break;
            }
        } catch (NoSuchElementException e) {
            System.out.println("ERROR WAIT => " + e.toString());
        }
    }

    public void esperarCarregamento(String parName) {
        WebDriverWait wait = new WebDriverWait(driver, 90);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"menu-fixed-top-temp\"]//*[contains(text(),\""+ parName+ "\")]")));
    }

    public void waitElementInisibilityAll(String parName, String... parType) {
        WebDriverWait wait = new WebDriverWait(driver, 90);
        String param2 = getAttributeType(parType);
        try {
            switch (param2) {
                case "id":
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(MobileBy.id(parName)));
                    break;
                case "name":
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(MobileBy.name(parName)));
                    break;
                case "css":
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(MobileBy.cssSelector(parName)));
                    break;
                case "xpath":
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(MobileBy.xpath(parName)));
                    break;
                case "link":
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(MobileBy.linkText(parName)));
                    break;
                case "class":
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(MobileBy.className(parName)));
                    break;
                case "resourceid":
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(MobileBy.xpath("//*[@resource-id='" + parName + "']")));
                    break;
                case "resourceidindex":
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(MobileBy.xpath("//*[@resource-id='" + parName + "'][@index='0']")));
                    break;
                case "text":
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(MobileBy.xpath("//*[@text='" + parName + "']")));
                    break;
                case "contains":
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(MobileBy.xpath("//*[contains(@content-desc,'" + parName + "') or contains(@text,'" + parName + "')]")));
                    break;
                case "Accessibility":
                    wait.until(ExpectedConditions.invisibilityOfElementLocated(MobileBy.AccessibilityId(parName)));
                    break;
            }
        } catch (NoSuchElementException e) {
            System.out.println("ERROR WAIT => " + e.toString());
        }
    }

    public void waitElementClickableAll(String parName, String... parType) {
        WebDriverWait wait = new WebDriverWait(driver, 90);
        String param2 = getAttributeType(parType);
        try {
            switch (parName) {
                case "id":
                    wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id(parName)));
                    break;
                case "access":
                    wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId(parName)));
                    break;
                case "css":
                    wait.until(ExpectedConditions.elementToBeClickable(MobileBy.cssSelector(parName)));
                    break;
                case "content":
                    wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//*[@content-desc='" + parName + "']")));
                    break;
                case "text":
                    wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//*[@text='" + parName + "']")));
                    break;
                case "contains":
                    wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//*[contains(@content-desc,'" + parName + "') or @text='" + parName + "']")));
                    break;
                case "xpath":
                    wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath(parName)));
                    break;
            }
        } catch (NoSuchElementException e) {
            System.out.println("ERROR WAIT => " + e.toString());
        }
    }

    public void esconderTeclado() {
        driver.hideKeyboard();
    }

    public boolean isEnabled(String parValue, String... parType) {
        WebElement element = findElem(parValue, parType);
        return element.isEnabled();
    }

    //Tap to an element for 250 milliseconds
    public void tapByElement(AndroidElement androidElement) {
        new TouchAction(driver)
                .tap(tapOptions().withElement(element(androidElement)))
                .waitAction(waitOptions(Duration.ofMillis(250))).perform();
    }

    //Tap by coordinates
    public void tapByCoordinates(int x, int y) {
        new TouchAction(driver)
                .tap(point(x, y))
                .waitAction(waitOptions(Duration.ofMillis(250))).perform();
    }

    //Press by element
    public void pressByElement(AndroidElement element, long seconds) {
        new TouchAction(driver)
                .press(element(element))
                .waitAction(waitOptions(ofSeconds(seconds)))
                .release()
                .perform();
    }

    //Press by coordinates
    public void pressByCoordinates(int x, int y, long seconds) {
        new TouchAction(driver)
                .press(point(x, y))
                .waitAction(waitOptions(ofSeconds(seconds)))
                .release()
                .perform();
    }

    //Horizontal Swipe by percentages
    public void horizontalSwipeByPercentage(double startPercentage, double endPercentage, double anchorPercentage) {
        Dimension size = driver.manage().window().getSize();
        int anchor = (int) (size.height * anchorPercentage);
        int startPoint = (int) (size.width * startPercentage);
        int endPoint = (int) (size.width * endPercentage);

        new TouchAction(driver)
                .press(point(startPoint, anchor))
                .waitAction(waitOptions(ofMillis(1000)))
                .moveTo(point(endPoint, anchor))
                .release().perform();
    }

    //Vertical Swipe by percentages
    public void verticalSwipeByPercentages(double startPercentage, double endPercentage, double anchorPercentage) {
        // driver.verticalSwipeByPercentages(70, 30, 50);
        driver.context("NATIVE_APP");
        Dimension size = driver.manage().window().getSize();

        int anchor = (int) (size.width * (anchorPercentage / 100));
        int startPoint = (int) (size.height * (startPercentage / 100));
        int endPoint = (int) (size.height * (endPercentage / 100));

        new TouchAction(driver)
                .press(point(anchor, startPoint))
                .waitAction(waitOptions(ofMillis(500)))
                .moveTo(point(anchor, endPoint))
                .release().perform();
        driver.context("WEBVIEW_com.nvt.cs");
    }

    public void swipeByCoordinates(WebElement startElement, WebElement endElement) {
        new TouchAction(driver)
                .press(point(endElement.getLocation()))
                .waitAction(waitOptions(ofMillis(500)))
                .moveTo(point(startElement.getLocation()))
                .release().perform();
    }
/*
    public void swipeUntil(String expectedElement) {
        boolean isFoundTheElement = this.findElem(expectedElement).getText() ;
        while (isFoundTheElement == false) {
            verticalSwipeByPercentages( 0.9, 0.1, 0.5);
            isFoundTheElement = this.findElem(expectedElement);
        }
    }*/

    //Multitouch action by using an android element
    public void multiTouchByElement(AndroidElement androidElement) {
        TouchAction press = new TouchAction(driver)
                .press(element(androidElement))
                .waitAction(waitOptions(ofSeconds(1)))
                .release();

        new MultiTouchAction(driver)
                .add(press)
                .perform();
    }

    public void waitElementNotVisible(String parId) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(MobileBy.id(parId)));
    }

    public void waitElementNotVisibleCSS(String parCss) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(MobileBy.cssSelector(parCss)));
        driver.getWindowHandles();
    }

    public void waitElementNotVisibleXP(String parXp) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(MobileBy.xpath(parXp)));
    }

    public void waitElementNotVisibleClass(String parClass) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(MobileBy.className(parClass)));
    }

/*
    public static boolean waitForPresence(AppiumDriver driver, int timeLimitInSeconds, String targetResourceId) {

        boolean isElementPresent;

        try {
            mobileElement = (MobileElement) driver.findelemen("new UiSelector().resourceId(\"" + targetResourceId + "\")");
            WebDriverWait wait = new WebDriverWait(driver, timeLimitInSeconds);
            wait.until(ExpectedConditions.visibilityOf(mobileElement));
            isElementPresent = mobileElement.isDisplayed();
            return isElementPresent;
        } catch (Exception e) {
            isElementPresent = false;
            System.out.println(e.getMessage());
            return isElementPresent;
        }
    }
*/

    public boolean selected(String parValue, String... parType) {

        WebElement element = findElem(parValue, parType);
        return element.isSelected();
    }

    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    public String getContext() {
        return driver.getContext();
    }

    public void setContext(String pContext) {
        // [NATIVE_APP, WEBVIEW_com.nvt.cs, WEBVIEW_chrome, CHROMIUM]
        driver.context(pContext);
    }

    public void botaoVoltar() {
        this.setContext("NATIVE_APP");
        driver.navigate().back();
        this.setContext("WEBVIEW_com.nvt.cs");
    }

    public Set getAvailableContext() {
        return (Set<String>) driver.getContextHandles();
    }

    public void stop() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
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
}

