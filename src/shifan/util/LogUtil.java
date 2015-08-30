package shifan.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;

public class LogUtil {
	private static Logger log = LogManager.getRootLogger();
	
	public static Logger getLogger(){
		log.info(new SimpleDateFormat("yyyy-MM-hh HH:mm:ss").format(new Date()));
		return log;
	}
	

}
