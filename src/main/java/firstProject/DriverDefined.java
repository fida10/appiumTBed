package firstProject;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverDefined {
	public AndroidDriver<AndroidElement> setupDesiredCap() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "SE_SecondGenPractice"); //sets the device name to the name of the virtual device, in this case this is DevTwo
		desiredCapabilities.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir").concat("/src/main/resources/ApiDemosTwo-debug.apk")); //the app to open on the device
		desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2"); //the famed uiautomator. This sets the capability that we will be using uiautomator2 elements to identify and interact with elements, similar to xpaths on web.
		AndroidDriver<AndroidElement> ad = new AndroidDriver <> (new URL("http://127.0.0.1:4723/wd/hub"),desiredCapabilities);
		ad.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return ad;
	}
}
