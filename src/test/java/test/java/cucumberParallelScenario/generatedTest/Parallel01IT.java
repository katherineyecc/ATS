package test.java.cucumberParallelScenario.generatedTest;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        features = {"/Users/sandra/git/ATS/src/test/java/test/pcucumber/pcucumberExp2.feature:6"},
        plugin = {"json:/Users/sandra/git/ATS/target/cucumber-parallel/json/1.json"},
        monochrome = true,
        glue = {"test.pcucumber"})
public class Parallel01IT {
}
