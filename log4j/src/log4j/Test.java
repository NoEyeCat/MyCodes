package log4j;

import org.apache.log4j.Logger;

public class Test {
	public static void main(String[] args) {
		Logger logger=Logger.getLogger(Test.class);
		logger.debug("这是一个debug信息");
	}
}
