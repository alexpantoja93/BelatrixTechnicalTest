package pe.com.alexpantoja.logger.config;

public class PropertiesConfiguration extends LoggerConfiguration {

	private static final long serialVersionUID = 1L;

	@Override
	public String getProperty(final String property) {
		String message = null;
		if (property.equals("logger.logFilePath")) {
			message = "./LogFile/logFile.txt";
		} else if (property.equals("logger.bd.userName")) {
			message = "alexpantoja";
		} else if (property.equals("logger.bd.password")) {
			message = "alexpantoja";
		} else if (property.equals("logger.bd.jdbcDriver")) {
			message = "com.mysql.cj.jdbc.Driver";
		} else if (property.equals("logger.bd.dbUrl")) {
			message = "jdbc:mysql://127.0.0.1:3306/BELATRIX_TECHNICAL_TEST";
		}

		return message;
	}

}