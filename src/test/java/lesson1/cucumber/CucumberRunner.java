package lesson1.cucumber;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags= "@smokeTest",features="src\\test\\resources\\cucumber")
public class CucumberRunner extends AbstractTestNGCucumberTests {
}