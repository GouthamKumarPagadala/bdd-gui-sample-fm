package com.bdd.manager;

import com.bdd.steps.AppStepDefinitions;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.bdd.enumerations.BrowserType;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class DriverManager {

    private WebDriver driver;

    static final Logger LOGGER = LoggerFactory.getLogger(AppStepDefinitions.class);

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    private Properties properties;

    public Properties getProperties() {
        if (this.properties != null) {
            return this.properties;
        } else {
            return loadProperties();
        }
    }

    public int explicitWaitTimeDuration = Integer.parseInt(getProperty("explicitWaitTimeDuration"));

    public String getProperty(String key) {
        return StringUtils.isNotBlank(getProperties().getProperty(key)) ? getProperties().getProperty(key) : System.getProperty(key);
    }

    public Properties loadProperties() {
        try {
            this.properties = new Properties();
            String propertyFileName = StringUtils.isNotBlank(System.getProperty("env")) ? "application-" + System.getProperty("env") + ".properties" : "application.properties";
            properties.load(this.getClass().getClassLoader().getResourceAsStream(propertyFileName));
            return properties;
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            return null;
        }
    }

    public void launchApplication(String url, BrowserType browser) {
        switch (browser) {
            case Chrome:
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("disable-dev-shm-usage");
                // options.addArguments("--no-sandbox");
                // options.addArguments("--headless");
                driver = new ChromeDriver(options);
                break;
            case Firefox:
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case Edge:
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case GRID_CHROME:
                try {
                    ChromeOptions opts = new ChromeOptions();
                    opts.setCapability(CapabilityType.BROWSER_NAME, org.openqa.selenium.remote.BrowserType.CHROME);
                    opts.setCapability(CapabilityType.PLATFORM_NAME, Platform.LINUX);
                    // Test Name opts.setCapability("name", "myTestName");
                    // Build Name
                    opts.setCapability("build", "myTestBuild");
                    // Idle TimeOut
                    opts.setCapability("idleTimeout", 150);
                    // Screen Resolution
                    opts.setCapability("screenResolution", "1920x1080");
                    // Timezone
                    opts.setCapability("tz", "Europe/Berlin");

                    opts.addArguments("disable-dev-shm-usage");
                    // opts.addArguments("--no-sandbox");
                    // opts.addArguments("--headless");
                    driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), opts);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

            default:
                break;
        }
        if(Boolean.parseBoolean(getProperty("maximizeWindow"))){
            driver.manage().window().maximize();
        }
        if(Boolean.parseBoolean(getProperty("implicitWaitTimeDuration"))){
            driver.manage().timeouts().implicitlyWait(Long.parseLong(getProperty(getProperty("implicitWaitTimeDuration"))), TimeUnit.SECONDS);
        }
        if(Boolean.parseBoolean(getProperty("pageLoadWaitTimeDuration"))){
            driver.manage().timeouts().pageLoadTimeout(Long.parseLong(getProperty(getProperty("pageLoadWaitTimeDuration"))), TimeUnit.SECONDS);
        }
        if(Boolean.parseBoolean(getProperty("scriptWaitTimeDuration"))){
            driver.manage().timeouts().setScriptTimeout(Long.parseLong(getProperty(getProperty("scriptWaitTimeDuration"))), TimeUnit.SECONDS);
        }
        driver.get(url);
    }
}
