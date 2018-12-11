package pe.com.alexpantoja.logger;

import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.logging.Level;

import org.apache.logging.log4j.util.Strings;

import pe.com.alexpantoja.logger.config.LoggerConfiguration;
import pe.com.alexpantoja.logger.enums.MessageType;
import pe.com.alexpantoja.logger.exception.MessageException;
import pe.com.alexpantoja.logger.interfaces.BelatrixLogger;
import pe.com.alexpantoja.logger.resources.DatabaseManager;

public class LoggerDatabase implements BelatrixLogger {

	private DatabaseManager manager;

	public LoggerDatabase(LoggerConfiguration configuration) {
		this.manager = DatabaseManager.getInstance(configuration);
	}

	public void addMessage(String message) {
		if (Strings.isBlank(message)) {
			throw new MessageException("Message must be specified");
		}
		try {
			this.manager.createLogTable();
			String errorMessage = "Message " + DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + " "
					+ message;
			this.manager.insertMessageBD(errorMessage, MessageType.MESSAGE.getId());
			logger.log(Level.INFO, message);
		} catch (SQLException e) {
			logger.log(Level.SEVERE, e.getMessage());
		}

	}

	public void addWarning(String message) {
		if (Strings.isBlank(message)) {
			throw new MessageException("Warning must be specified");
		}
		try {
			this.manager.createLogTable();
			String errorMessage = "Warning " + DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + " "
					+ message;
			this.manager.insertMessageBD(errorMessage, MessageType.WARNING.getId());
			logger.log(Level.INFO, message);
		} catch (SQLException e) {
			logger.log(Level.SEVERE, e.getMessage());
		}

	}

	public void addError(String message) {
		if (Strings.isBlank(message)) {
			throw new MessageException("Error must be specified");
		}

		try {
			this.manager.createLogTable();
			String errorMessage = "Error " + DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + " "
					+ message;
			this.manager.insertMessageBD(errorMessage, MessageType.ERROR.getId());
			logger.log(Level.INFO, message);
		} catch (SQLException e) {
			logger.log(Level.SEVERE, e.getMessage());
		}
	}

}