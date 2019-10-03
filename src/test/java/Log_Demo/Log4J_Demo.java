package Log_Demo;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class Log4J_Demo {

	static Logger logger = LogManager.getLogger("Log_Demo11");

	public static void main(String[] args) {

		System.out.println("\n Hello Huy...! \n");

		logger.info("infor message");
		logger.error("error message");
		logger.warn("warn message");
		logger.fatal("fatal message");

		System.out.println("hihi");
	}

}
