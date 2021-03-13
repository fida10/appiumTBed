package firstProject;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;

import java.net.MalformedURLException;
import java.time.Duration;

public class Gestures {
	public static void main(String[] args) throws MalformedURLException {
		longPress();
	}

	private static void longPress() throws MalformedURLException {
		DriverDefined d = new DriverDefined();
		AndroidDriver<AndroidElement> ad = d.setupDesiredCap();

		TouchAction t = new TouchAction (ad);
		/*
		* This is the equivalent of Actions for mobile. It is used to simulate any touch actions, similar to how Actions is used to simulate any action with the keyboard.
		*/

		ad.findElementByXPath("//android.widget.TextView[@text = 'Views']").click();
		ad.findElementByXPath("//android.widget.TextView[@text = 'Expandable Lists']").click();
		ad.findElementByXPath("//android.widget.TextView[@text = '1. Custom Adapter']").click();
		t.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(ad.findElementByXPath("//android.widget.TextView[@text = 'People Names']"))).withDuration(Duration.ofSeconds(2))).release().perform(); //similar to ending actions with build and perform, we end all TouchActions with a perform.
		/*
		 * This codeblock on line 29 basically tells appium to long press for 2 seconds, before releasing and performing the action.
		 */
	}
	private static void swipe() throws MalformedURLException {
		DriverDefined d = new DriverDefined();
		AndroidDriver<AndroidElement> ad = d.setupDesiredCap();

		TouchAction t = new TouchAction (ad);
	}
}
