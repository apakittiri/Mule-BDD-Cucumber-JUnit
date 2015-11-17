package com.sm.cucumber.common;

import java.io.File;
import java.io.IOException;

import org.mule.api.MuleContext;
import org.mule.api.MuleException;
import org.mule.config.spring.SpringXmlConfigurationBuilder;
import org.mule.context.DefaultMuleContextFactory;

public class MuleEmbeddedServer {

	private static MuleContext muleContext;

	public static void initialize() throws IOException, MuleException {
		final String curPath = new File(".").getCanonicalPath();
		muleContext = new DefaultMuleContextFactory()
				.createMuleContext(new SpringXmlConfigurationBuilder(curPath
						+ "/src/test/app/mule-config.xml"));
		muleContext.start();
	}

	public static void close() throws MuleException {
		muleContext.stop();
	}

	public static MuleContext getMuleContext() {
		return muleContext;
	}

}