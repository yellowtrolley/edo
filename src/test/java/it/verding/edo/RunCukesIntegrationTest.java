package it.verding.edo;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/*
 * This is the Cucumber entry point class, commonly named RunCukes, 
 * but since we are running cucumber during integration testing, 
 * we need to name the class as RunCukesIntegrationTest.
 */
@RunWith(Cucumber.class)
@CucumberOptions( glue = {"it.verding.edo"} )
public class RunCukesIntegrationTest {
}