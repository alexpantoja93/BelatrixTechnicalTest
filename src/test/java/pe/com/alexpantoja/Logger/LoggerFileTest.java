package pe.com.alexpantoja.Logger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pe.com.alexpantoja.logger.LoggerFile;
import pe.com.alexpantoja.logger.config.PropertiesConfiguration;
import pe.com.alexpantoja.logger.enums.LoggerType;
import pe.com.alexpantoja.logger.factory.LoggerFactory;
import pe.com.alexpantoja.logger.interfaces.BelatrixLogger;
import pe.com.alexpantoja.logger.resources.FileManager;

public class LoggerFileTest {
	
	@Before
	public final void baseSetUp() {}
	
	@After
	public final void baseTearDown() {}
	
	@Test
    public void testLoggerFactory_FileType() {
		BelatrixLogger logger = LoggerFactory.getLogger(LoggerType.FILE.getType());
        assertEquals(true, logger instanceof LoggerFile);
    }
		
	@Test
    public void testFileManager_HandlerValid() {
		FileManager fileManager = new FileManager(new PropertiesConfiguration());
		assertNotNull(fileManager.getFileHandler());
    }
	
	@Test
    public void testLoggerFile_addMessageInfo() {
		BelatrixLogger logger = LoggerFactory.getLogger(LoggerType.FILE.getType());
		logger.addMessage("Test - Message Info ");
        assertEquals(true, logger instanceof LoggerFile);
    }
	
	@Test
    public void testLoggerFile_addMultipleMessage() {
		BelatrixLogger logger = LoggerFactory.getLogger(LoggerType.FILE.getType());
		logger.addMessage("Test Multiple - Message Info!");
		logger.addWarning("Test Multiple - Message Warning!");
        assertEquals(true, logger instanceof LoggerFile);
    }
	
}
