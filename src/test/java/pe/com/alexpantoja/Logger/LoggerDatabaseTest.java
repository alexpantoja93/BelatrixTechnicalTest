package pe.com.alexpantoja.Logger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pe.com.alexpantoja.logger.LoggerDatabase;
import pe.com.alexpantoja.logger.config.PropertiesConfiguration;
import pe.com.alexpantoja.logger.enums.LoggerType;
import pe.com.alexpantoja.logger.enums.MessageType;
import pe.com.alexpantoja.logger.factory.LoggerFactory;
import pe.com.alexpantoja.logger.interfaces.BelatrixLogger;
import pe.com.alexpantoja.logger.resources.DatabaseManager;

public class LoggerDatabaseTest {
	
	@Before
	public final void baseSetUp() {}
	
	@After
	public final void baseTearDown() {}
	
	@Test
    public void testLoggerFactory_DatabaseType() {
		BelatrixLogger logger = LoggerFactory.getLogger(LoggerType.DATABASE.getType());
        assertEquals(true, logger instanceof LoggerDatabase);
    }
	
	@Test
    public void testDatabaseManager_BDConnectionValid() {
		DatabaseManager bdManager = DatabaseManager.getInstance(new PropertiesConfiguration());
		try {
			assertTrue(bdManager.getConnection().isValid(0));
		} catch (SQLException e) {
			assertTrue(false);
		}
    }
	
	@Test
    public void testDatabaseManager_insertMessage() {
		try {
			DatabaseManager bdManager = DatabaseManager.getInstance(new PropertiesConfiguration());
			bdManager.createLogTable();
			bdManager.insertMessageBD("Test insert message DB", MessageType.MESSAGE.getId());
			assertTrue(true);
		} catch (Exception e) {
			assertTrue(false);
		}
    }
	
	@Test
    public void testLoggerDatabase_addLog() {
		try {
			BelatrixLogger logger = LoggerFactory.getLogger(LoggerType.DATABASE.getType());
			logger.addMessage("Test Multiple - Message Info!");
			logger.addWarning("Test Multiple - Message Warning!");
	        assertTrue(true);
		} catch (Exception e) {
			assertTrue(false);
		}
    }
	
}
