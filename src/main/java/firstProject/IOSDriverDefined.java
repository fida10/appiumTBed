package firstProject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class IOSDriverDefined {

	AppiumDriverLocalService server = null;

	public static void main(String[] args)  throws MalformedURLException, InterruptedException{
		IOSDriverDefined instanceCreated = new IOSDriverDefined();
		AppiumDriver <MobileElement> driver = instanceCreated.setupDesiredCapForIOS();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElementByXPath("//XCUIElementTypeButton[@name = 'Allow']").click();
		System.out.println(driver.getStatus().toString());

		instanceCreated.getServer().stop();
		System.out.println("Server has stopped");

//		AppiumDriverLocalService server = AppiumDriverLocalService
//				.buildService(new AppiumServiceBuilder()
////						.withEnvironment(environment)
//								.usingDriverExecutable(new File("/opt/homebrew/bin/node"))
//								.withAppiumJS(new File("/Users/fida20/.npm-packages/bin/appium"))
//								.usingAnyFreePort()
//								.withArgument(GeneralServerFlag.SESSION_OVERRIDE)
////								.withEnvironment(System.getenv())
////								.withLogFile(new File("//Users/fida20/Programming/JavaProjects/MavenProjects/MobileAutomationProjects/firstAppiumProject/appiumLog.txt"))
//				);
//		server.start();
//		System.out.println(server.getUrl());
//		System.out.println("Server has started");
//
//		Map<String, String> env = System.getenv();
//		System.out.println("PATH is --> " + System.getenv("PATH"));
//		for (String envName : env.keySet()) {
//			System.out.format("%s=%s%n",
//					envName,
//					env.get(envName));
//		}
	}

	public IOSDriver <MobileElement> setupDesiredCapForIOS() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

		desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "SE_SecondGenPractice");
		desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "IOS");
		desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
		desiredCapabilities.setCapability(MobileCapabilityType.APP, "//Users/fida20/Programming/JavaProjects/MavenProjects/MobileAutomationProjects/firstAppiumProject/src/main/resources/MoneyGram.app.zip");
		desiredCapabilities.setCapability("noReset", true); //ensures that the application does not reinstall every time reset is called
		desiredCapabilities.setCapability("platformVersion", "14.4");
		desiredCapabilities.setCapability("useNewWDA", true);
		desiredCapabilities.setCapability("showXcodeLog", true);

		HashMap<String, String> environment = new HashMap();
		environment.put("PATH", "/usr/local/bin:" + System.getenv("PATH"));

		server = AppiumDriverLocalService
				.buildService(new AppiumServiceBuilder()
						.withEnvironment(environment)
//						.usingDriverExecutable(new File("//opt/homebrew/Cellar/node/15.8.0/bin/node"))
//						.withAppiumJS(new File("//Users/fida20/.npm-packages/lib/node_modules/appium/build/lib/main.js"))
						.usingAnyFreePort()
						.withArgument(GeneralServerFlag.SESSION_OVERRIDE)
						.withLogFile(new File("//Users/fida20/Programming/JavaProjects/MavenProjects/MobileAutomationProjects/firstAppiumProject/appiumLog.txt"))
				);
		server.start();

//		IOSDriver <MobileElement> iosDriver = new IOSDriver<MobileElement>(new URL("http://127.0.0.1:34528/wd/hub"), desiredCapabilities);
		IOSDriver <MobileElement> iosDriver = new IOSDriver<MobileElement>(server.getUrl(), desiredCapabilities);

		return iosDriver;
	}
	public AppiumDriverLocalService getServer() {
		return server;
	}
}
