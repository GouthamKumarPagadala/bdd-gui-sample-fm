package com.bdd.junitrunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
		glue={"com.bdd.manager","com.bdd.steps"},
		features = "classpath:Features/",
		tags = "@Gatling and @Delete",
		//tags = "@Negative and @Web",
		monochrome = true,
		plugin = {
				"pretty",
				"json:target/cucumber.json",
				"html:target/cucumber.html"
		}
		)
public class RunCucumber {

}
