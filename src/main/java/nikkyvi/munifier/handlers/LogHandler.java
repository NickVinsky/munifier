package nikkyvi.munifier.handlers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import nikkyvi.munifier.Munifier;

public class LogHandler {
	
	private static Logger logger;

	public static Logger getLogger() {
		if (logger == null) {
			logger = LogManager.getFormatterLogger(Munifier.MODID);
		}
		return logger;
	}
}
