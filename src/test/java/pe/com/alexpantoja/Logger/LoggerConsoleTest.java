package pe.com.alexpantoja.Logger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pe.com.alexpantoja.logger.LoggerConsole;
import pe.com.alexpantoja.logger.config.PropertiesConfiguration;
import pe.com.alexpantoja.logger.enums.LoggerType;
import pe.com.alexpantoja.logger.factory.LoggerFactory;
import pe.com.alexpantoja.logger.interfaces.BelatrixLogger;
import pe.com.alexpantoja.logger.resources.ConsoleManager;

public class LoggerConsoleTest {

	@Before
	public final void baseSetUp() {
	}

	@After
	public final void baseTearDown() {
	}

	@Test
	public void testLoggerFactory_ConsoleType() {
		BelatrixLogger logger = LoggerFactory.getLogger(LoggerType.CONSOLE.getType());
		assertEquals(true, logger instanceof LoggerConsole);
	}

	@Test
	public void testConsoleManager_HandlerValid() {
		ConsoleManager consoleManager = ConsoleManager.getInstance(new PropertiesConfiguration());
		assertNotNull(consoleManager.getConsoleHandler());
	}

	@Test
	public void testLoggerConsole_addMessageInfo() {
		BelatrixLogger logger = LoggerFactory.getLogger(LoggerType.CONSOLE.getType());
		logger.addMessage("Test Console - Message Info ");
		assertEquals(true, logger instanceof LoggerConsole);
	}

	@Test
	public void testLoggerConsole_addMultipleMessage() {
		BelatrixLogger logger = LoggerFactory.getLogger(LoggerType.CONSOLE.getType());
		logger.addMessage("Test Multiple Console - Message Info!");
		logger.addWarning("Test Multiple Console - Message Warning!");
		logger.addError("Test Multiple Console - Message Error!");
		assertEquals(true, logger instanceof LoggerConsole);
	}

}
