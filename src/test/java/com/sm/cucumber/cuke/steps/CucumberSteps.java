package com.sm.cucumber.cuke.steps;

import java.util.logging.Logger;

import org.mule.MessageExchangePattern;
import org.mule.api.MuleEvent;
import org.mule.api.processor.MessageProcessor;
import org.mule.tck.MuleTestUtils;
import org.mule.util.IOUtils;

import com.sm.cucumber.common.MuleEmbeddedServer;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CucumberSteps {

	private static final Logger LOGGER = Logger.getLogger("CucumberSteps");

	@Given("^The scenario with \"([^\"]*)\" and scenario description \"([^\"]*)\"$")
	public void The_scenario_with_and_scenario_description(String arg1,
			String arg2) throws Throwable {
		LOGGER.info("Scenario ID : " + arg1);
		LOGGER.info("Scenario Description : " + arg2);
	}

	@When("^The Source system \"([^\"]*)\" sends \"([^\"]*)\" to Destination system \"([^\"]*)\"$")
	public void The_Source_system_sends_to_Destination_system(String arg1,
			String arg2, String arg3) throws Throwable {
		LOGGER.info("Source System : " + arg1);
		LOGGER.info("File Name : " + arg2);
		LOGGER.info("Destination System : " + arg3);

		String flowName = "mulecucumberFlow";
		Object payload = IOUtils.getResourceAsString(arg2, this.getClass());
		MuleEvent event = MuleTestUtils.getTestEvent(payload,
				MessageExchangePattern.REQUEST_RESPONSE,
				MuleEmbeddedServer.getMuleContext());
		MessageProcessor messageProcessor = MuleEmbeddedServer.getMuleContext()
				.getRegistry().lookupObject(flowName);
		event = messageProcessor.process(event);
		LOGGER.info("Mule Event Response : " + event.getMessageAsString());
	}

	@Then("^one acknowledge message will come from \"([^\"]*)\" to \"([^\"]*)\"$")
	public void one_acknowledge_message_will_come_from_to(String arg1,
			String arg2) throws Throwable {
		LOGGER.info("Destination System : " + arg1);
		LOGGER.info("Source System : " + arg2);
	}

}
