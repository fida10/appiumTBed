package firstProject;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws MalformedURLException
    {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "DevTwo"); //sets the device name to the name of the virtual device, in this case this is DevTwo
        desiredCapabilities.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir").concat("/src/main/resources/ApiDemosTwo-debug.apk")); //the app to open on the device
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2"); //the famed uiautomator. This sets the capability that we will be using uiautomator2 elements to identify and interact with elements, similar to xpaths on web.
        AndroidDriver <AndroidElement> ad = new AndroidDriver <> (new URL("http://127.0.0.1:4723/wd/hub"),desiredCapabilities);
        ad.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        /*
        The above step creates an android driver, which is what we will use to pass commands to the android device, similar to chromedriver. It needs 2 params -->
            * The URL to the appium server. The server runs on port 4723 by default. http://127.0.0.1 is the default home address for the local machine.
            * Pass the DesiredCapabilities that was defined before into the Android Driver to implement them.

        The <AndroidElement> is to specify the types of elements that this Android Driver will work with, in this case it will be Android Elements
         */

        ad.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
        ad.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
        ad.findElementById("android:id/checkbox").click();
        ad.findElementByXPath("//android.widget.TextView[@text='WiFi settings']").click();
        ad.findElementByClassName("android.widget.EditText").sendKeys("bal");
        //ad.findElementByXPath("//android.widget.Button[@text='OK']").click();
        ad.findElementByAndroidUIAutomator("text(\"OK\")").click();

        int aSize = ad.findElementsByAndroidUIAutomator("new UiSelector().clickable(true)").size();
        System.out.println(aSize);


    }
}
