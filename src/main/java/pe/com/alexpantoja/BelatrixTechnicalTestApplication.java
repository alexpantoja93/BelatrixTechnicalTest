package pe.com.alexpantoja;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import pe.com.alexpantoja.logger.enums.LoggerType;
import pe.com.alexpantoja.logger.factory.LoggerFactory;
import pe.com.alexpantoja.logger.interfaces.BelatrixLogger;

@SpringBootApplication
public class BelatrixTechnicalTestApplication implements CommandLineRunner {

	BelatrixLogger logger;

	public static void main(String[] args) {
		SpringApplication.run(BelatrixTechnicalTestApplication.class, args);
	}

	@Override
	public void run(String... args) {

		logger = LoggerFactory.getLogger(LoggerType.CONSOLE.getType());

		logger.addMessage("Test Console - Message Info");
		logger.addWarning("Test Console - Warning Info");
		logger.addError("Test Console - Error Info");

		logger = LoggerFactory.getLogger(LoggerType.FILE.getType());
		logger.addMessage("Test File - Message Info");
		logger.addWarning("Test File - Warning Info");
		logger.addError("Test File - Error Info");

		logger = LoggerFactory.getLogger(LoggerType.DATABASE.getType());
		logger.addMessage("Test Database - Message Info");
		logger.addWarning("Test Database - Warning Info");
		logger.addError("Test Database - Error Info");

	}

}
