package main.utilities;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Trace {
	
	private static Trace _instance = null;		
	public Logger getLogger (Object o) {
		return Logger.getLogger(o.getClass().getName());
	}
	
	private Trace() {
		//String userDir = System.getProperty("user.dir");
		//String configFile = String.format("%s\\%s\\%s.properties",userDir, "properties","log4j");
		//String configFile = String.format("%s\\%s.properties",userDir,"log4j");
		PropertyConfigurator.configure("log4j.properties");
	}
	
	public static Trace getInstance() {
		if (_instance == null) {
			synchronized (Trace.class) {
				_instance = new Trace();
			}
		}
		return _instance;
	}

}
