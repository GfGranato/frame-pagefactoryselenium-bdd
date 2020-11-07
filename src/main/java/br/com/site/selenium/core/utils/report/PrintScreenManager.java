package br.com.site.selenium.core.utils.report;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import static br.com.site.selenium.core.driver.DriverFactory.getDriver;

public class PrintScreenManager {

    public static void takePrintSave() {
        try {
            File scrFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("target/printScreen/" +
                    Calendar.getInstance().getTime().getDay() + "-"
                    + Calendar.getInstance().getTime().getMonth() + "-"
                    + Calendar.getInstance().getTime().getYear() + "/"
                    + Calendar.getInstance().getTime().getHours() + "-"
                    + Calendar.getInstance().getTime().getMinutes() + "-"
                    + Calendar.getInstance().getTime().getSeconds() + ".png"));
        } catch (IOException ignore) {
        }
    }
}
