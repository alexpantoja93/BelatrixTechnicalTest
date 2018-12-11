package pe.com.alexpantoja.logger.factory;

import pe.com.alexpantoja.logger.LoggerConsole;
import pe.com.alexpantoja.logger.LoggerDatabase;
import pe.com.alexpantoja.logger.LoggerFile;
import pe.com.alexpantoja.logger.config.PropertiesConfiguration;
import pe.com.alexpantoja.logger.config.LoggerConfiguration;
import pe.com.alexpantoja.logger.enums.LoggerType;
import pe.com.alexpantoja.logger.exception.LoggerTypeException;
import pe.com.alexpantoja.logger.interfaces.BelatrixLogger;

public class LoggerFactory {

	private LoggerFactory() {
		super();
	}

	public static BelatrixLogger getLogger(String type) {
		if (LoggerType.FILE.getType().equals(type)) {
			return new LoggerFile(new PropertiesConfiguration());
		} else if (LoggerType.CONSOLE.getType().equals(type)) {
			return new LoggerConsole(new PropertiesConfiguration());
		} else if (LoggerType.DATABASE.getType().equals(type)) {
			return new LoggerDatabase(new PropertiesConfiguration());
		} else {
			throw new LoggerTypeException("Invalid configuration | Logger type not valid!");
		}
	}

	public static BelatrixLogger getLogger(String type, LoggerConfiguration configuration) {
		if (LoggerType.FILE.getType().equals(type)) {
			return new LoggerFile(configuration);
		} else if (LoggerType.CONSOLE.getType().equals(type)) {
			return new LoggerConsole(configuration);
		} else if (LoggerType.DATABASE.getType().equals(type)) {
			return new LoggerDatabase(configuration);
		} else {
			throw new LoggerTypeException("Logger type not valid!");
		}
	}

}
