package com.maveric.capstone.tests;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(features = "Features" , glue = "com.maveric.capstone.stepdefs"  , stepNotifications = true,tags = "@execute")


public class TestRunner {

}
