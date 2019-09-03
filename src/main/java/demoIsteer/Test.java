package demoIsteer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Test {

	private static final Logger logger = LogManager.getLogger(Test.class);

	
//	public Test()
//	{
//		PropertyConfigurator.configure("resources/log4j2.properties");
//	}
	public static void main(String[] args) {

		logger.info("in java main");
		logger.debug("in log debud");
	}
}
