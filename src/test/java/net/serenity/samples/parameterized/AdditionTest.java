package net.serenity.samples.parameterized;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import net.serenity.samples.parameterized.util.ResultReporter;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.UserStoryCode;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.TestData;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collection;

@RunWith(SerenityParameterizedRunner.class)
@UserStoryCode("US01")
@Concurrent
public class AdditionTest {

    @Rule
    public TestName testName = new TestName();

    @Rule
    public TestWatcher watcher = new TestWatcher() {
        @Override
        protected void failed(Throwable e, Description description) {
            System.out.println(testName.getMethodName() + " ended on " + device +
                    "; test report: " + driver.getCapabilities().getCapability("testobject_test_report_url"));
            resultReporter.saveTestStatus(driver.getSessionId().toString(), false);
            driver.quit();
        }

        @Override
        protected void succeeded(Description description) {
            System.out.println(testName.getMethodName() + " ended on " + device +
                    "; test report: " + driver.getCapabilities().getCapability("testobject_test_report_url"));
            resultReporter.saveTestStatus(driver.getSessionId().toString(), true);
            driver.quit();
        }
    };

    @TestData
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][]{{"LG_Nexus_5X_free"}, {"Motorola_Moto_E_2nd_gen_free"}, {"Google_Pixel_real"}});
    }

    private ResultReporter resultReporter = new ResultReporter();

    @Steps
    TestSteps steps;
    private final String device;

    private AppiumDriver driver;
    public AdditionTest(String device) {
        this.device = device;
    }

    @Before
    public void setup() {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("testobject_api_key", System.getenv("TESTOBJECT_API_KEY"));
        capabilities.setCapability("testobject_device", device);
        capabilities.setCapability("testobject_appium_version", "1.6.5");

        try {
            driver = new AndroidDriver(new URL(System.getenv("APPIUM_URL")), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        System.out.println(testName.getMethodName() + " starting on " + device +
                "; live view: " + driver.getCapabilities().getCapability("testobject_test_live_view_url"));

    }

    @Test
    public void thisTestShouldFail() {
        steps.compute_and_verify_result(driver);
    }

    @Test
    public void thisTestShouldSucceed() {
        steps.perform_addition(driver);
        steps.compute_and_verify_result(driver);
    }

}
