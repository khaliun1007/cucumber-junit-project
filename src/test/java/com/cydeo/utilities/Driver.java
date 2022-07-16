package com.cydeo.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    //Creating a private constructor we're closing access
    // to the object of this class from outside class
    private Driver() {
    }

    //We make WebDriver private, because we want to close access from outside of class
    //We make it static, because we'll use it inside static method
    //private static WebDriver driver;
    private static InheritableThreadLocal<WebDriver> driverPool= new InheritableThreadLocal<>();

    public static WebDriver getDriver() {

        if (driverPool.get() == null) {

            // We read browserType from configuration.properties with
            // help of ConfigurationReader class' getProperty() method
            String browserType = ConfigurationReader.getProperty("browser");

            switch (browserType) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
            }

        }
        return driverPool.get();
    }

    public static void closeDriver(){
        if(driverPool.get() !=null){
            driverPool.get().quit(); // this line will terminate the existing driver session. with using this driver will not be even null.
            driverPool.remove();
        }
    }
}