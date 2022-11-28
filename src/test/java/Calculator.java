import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.util.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Calculator {

    AndroidDriver<AndroidElement> driver;

    @BeforeClass
    void setup() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","emulator-5554");
        capabilities.setCapability("platformName","android");
        capabilities.setCapability("appPackage","com.android.calculator2");
        capabilities.setCapability("appActivity","com.android.calculator2.Calculator");
        capabilities.setCapability("noReset",true);
        capabilities.setCapability("automationName","UIAutomator2");
        URL url = new URL("http://127.0.0.1:4723/wd/hub/");
        driver = new AndroidDriver<AndroidElement>(url,capabilities);
    }

//    @Test
//    void testOne(){
//        MobileElement btnOne = (MobileElement)driver.findElementById("com.android.calculator2:id/digit_1");
//        btnOne.click();
//        //27 + 89 =
//    }

    @Test
    void testTwo(){
        MobileElement btnTwo = (MobileElement) driver.findElementById("com.android.calculator2:id/digit_2");
        MobileElement btnSeven = (MobileElement) driver.findElementById("com.android.calculator2:id/digit_7");
        MobileElement btnEight = (MobileElement) driver.findElementById("com.android.calculator2:id/digit_8");
        MobileElement btnNine = (MobileElement) driver.findElementById("com.android.calculator2:id/digit_9");

        MobileElement btnPlus = (MobileElement) driver.findElementById("com.android.calculator2:id/op_add");
        MobileElement btnEquals = (MobileElement) driver.findElementById("com.android.calculator2:id/eq");

        btnTwo.click();
        btnSeven.click();
        btnPlus.click();
        btnEight.click();
        btnNine.click();
        btnEquals.click();

        MobileElement result = (MobileElement) driver.findElementById("com.android.calculator2:id/result");

        System.out.println("The result is " + result.getText());

    }



}
