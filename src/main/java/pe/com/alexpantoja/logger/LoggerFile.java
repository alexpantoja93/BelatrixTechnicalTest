package pe.com.alexpantoja.logger;

import java.util.logging.Level;

import org.apache.logging.log4j.util.Strings;

import pe.com.alexpantoja.logger.config.LoggerConfiguration;
import pe.com.alexpantoja.logger.exception.MessageException;
import pe.com.alexpantoja.logger.interfaces.BelatrixLogger;
import pe.com.alexpantoja.logger.resources.FileManager;

public class LoggerFile implements BelatrixLogger {
	
	private FileManager manager;
	
	public LoggerFile(LoggerConfiguration configuration) {
		this.manager = new FileManager(configuration);
		logger.addHandler(this.manager.getFileHandler());
	}
	
	public void addMessage(String message) {
		if (Strings.isBlank(message)) {
			throw new MessageException("Message must be specified");
		}
		logger.log(Level.INFO, message);
	}

	public void addWarning(String message) {
		if (Strings.isBlank(message)) {
			throw new MessageException("Warning must be specified");
		}
		logger.log(Level.WARNING, message);
	}

	public void addError(String message) {
		if (Strings.isBlank(message)) {
			throw new MessageException("Error must be specified");
		}
		logger.log(Level.SEVERE, message);
	}

}
