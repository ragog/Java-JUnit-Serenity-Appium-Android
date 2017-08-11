package net.serenity.samples.parameterized;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import net.thucydides.core.webdriver.Configuration;
import net.thucydides.core.webdriver.SystemPropertiesConfiguration;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import static net.thucydides.core.ThucydidesSystemProperty.THUCYDIDES_BATCH_COUNT;
import static org.assertj.core.api.StrictAssertions.*;

public class TestSteps {

    @Step
    public void perform_addition(AppiumDriver driver) {

        /* Get the elements. */
        MobileElement buttonTwo = (MobileElement) (driver.findElement(By.id("net.ludeke.calculator:id/digit2")));
        MobileElement buttonPlus = (MobileElement) (driver.findElement(By.id("net.ludeke.calculator:id/plus")));

        /* Add two and two. */
        buttonTwo.click();
        buttonPlus.click();
        buttonTwo.click();

    }

    @Step
    public void compute_and_verify_result(AppiumDriver driver) {

        /* Press '=' button */
        MobileElement buttonEquals = (MobileElement) (driver.findElement(By.id("net.ludeke.calculator:id/equal")));
        buttonEquals.click();

        /* Check if within given time the correct result appears in the designated field. */
        MobileElement resultField = (MobileElement) (driver.findElement(By.xpath("//android.widget.EditText[1]")));
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.textToBePresentInElement(resultField, "4"));

    }

}