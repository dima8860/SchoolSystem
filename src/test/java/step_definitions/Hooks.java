package step_definitions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Driver;
import utilities.Log;
import utilities.TempStorage;

public class Hooks {

    @Before
    public void setUp(Scenario scenario){
        //anything that you want to run before each Scenario
        TempStorage.clear();
        Log.start(scenario.getName());
    }

    @After
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()) {
            byte [] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        }


        Driver.quitDriver();

    }
}
