package testSuiteBDD;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/testSuiteBDD/SwagLab.feature"},
        glue= {"testSuiteBDD"},
        tags= "@swaglabs"
        
)

public class TestRunner extends AbstractTestNGCucumberTests
{

}
