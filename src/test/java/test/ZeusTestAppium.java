package test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.remote.MobileCapabilityType;

public class ZeusTestAppium {
	WebDriver driver;
	WebElement element;
	//
	By btnGuest = By.id("com.upax.zeusgeneric:id/zlo_button_guest");
	By intName = By.id("com.upax.zeusgeneric:id/zlo_edittext_name");
	By intMail = By.id("com.upax.zeusgeneric:id/zlo_edittext_email");
	By intPassw = By.id("com.upax.zeusgeneric:id/zlo_edittext_password");
	

	//Message
	By elementZ = By.id("com.upax.zeusgeneric:id/zlo_imageview_zeus");
	
	
  @BeforeClass
  public void setUP() {
	  try {
		  	
			DesiredCapabilities cap = new DesiredCapabilities();
			
			cap.setCapability(CapabilityType.PLATFORM_NAME, "android");
			cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11 RKQ1.200826.002");
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, "joyeuse");
			cap.setCapability("automationName","uiautomator2");
			cap.setCapability("appPackage", "com.upax.zeusgeneric");
			cap.setCapability("appActivity", ".uimodules.splash.ZGSplashActivity");
			cap.setCapability("appium:noReset", true);
			cap.setCapability("noSign", true);
			cap.setCapability("autoGrantPermissions", true);
			
			URL url = new URL("http://127.0.0.1:4723/wd/hub");
			driver = new RemoteWebDriver(url,cap);
			
		}catch(Exception e) {System.out.print(e);}
  }
@SuppressWarnings("deprecation")
@Test
  public void testSGuest() {
		  driver.findElement(btnGuest).click();
		  driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		  driver.findElement(elementZ).isDisplayed();
		  driver.findElement(intName).click();
		  element.sendKeys("hello word");
  }
  
}