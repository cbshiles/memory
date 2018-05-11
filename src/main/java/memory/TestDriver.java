package memory;

import java.io.IOException;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;



import memory.tools.*;
import memory.tui.Tui;
import memory.text.*;
import java.util.*;

public class TestDriver{

    //TODO: property file to specify root directory

    public static String configFile = "config.properties";
    
    private static final Logger log = LogManager.getLogger(TestDriver.class);

    public static Tui tui;
    
    public static void main(String[] args) throws Exception{
    	
    	log.trace("dog");

	try {
	Properties props = Io.loadProperties(configFile);
	String storageRoot = props.getProperty("storage_root");
	String home = props.getProperty("homepage");
	System.out.println(".-->"+storageRoot);
	//System.out.println(TextClassMap.getAll(storageRoot));

	tui = new Tui(storageRoot, home);
	tui.start();
	} catch (Exception ex){
	    if (tui != null) tui.close();
	    System.out.println(ex);
	}
    }
}
