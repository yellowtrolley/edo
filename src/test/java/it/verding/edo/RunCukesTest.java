package it.verding.edo;


import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/*
 * This is the Cucumber entry point class.
 * By default, Maven only picks up test classes that end with Test.
 */
@RunWith(Cucumber.class)
@CucumberOptions(format = { "pretty", "html:target/cucumber" }, glue = {"it.verding.edo", "cucumber.runtime.java.spring.hooks"} )
public class RunCukesTest {
}