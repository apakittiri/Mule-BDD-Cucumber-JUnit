package com.sm.cucumber.cuke;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.mule.api.MuleException;

import com.sm.cucumber.common.MuleEmbeddedServer;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "classpath:feature/CucumberFeature.feature" }, glue = "com.sm.cucumber.cuke.steps", strict = true, format = {
		"pretty", "html:target/cucumber", "json:target/Cucumber.json" })
public class CucumberTest {

	@BeforeClass()
	public static void initTestEnvironment() {
		System.out.println("Initialize Test Environment");
		try {
			MuleEmbeddedServer.initialize();
		} catch (Exception e) {
			System.out.println("Mule Embedded Server cannot be iniatilaized.");
			e.printStackTrace();
		}
		System.out.println("Test Environment initialized.");
	}

	@AfterClass()
	public static void destroyTestEnvironment() throws MuleException {
		System.out.println("Destroy Test Environment.");
		MuleEmbeddedServer.close();
		System.out.println("Test Environment destroyed.");
	}

}
