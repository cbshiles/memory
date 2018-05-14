package memory;
import java.io.*;
import java.io.IOException;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;



import memory.tools.*;
import memory.tui.*;
import memory.text.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class TestDriver{

    public static String configFile = "config.properties";
    private static final Logger log = LogManager.getLogger(TestDriver.class);
    public static Tui tui;
    
    public static void main(String[] args) throws Exception{
    	log.trace("dog");

	BufferedReader errinput = null;
	try {
	    Properties props = Io.loadProperties(configFile);
	    String storageRoot = props.getProperty("storage_root");
	    String home = props.getProperty("homepage");

	    tui = new Tui(storageRoot, home);
	    tui.start();
	} catch (IOException ex){
	    if (tui != null) tui.close();
	    log.error(ex.getStackTrace().toString());
	} catch (BadCodeException ex){
	    System.out.println(ex);
	}

	
    }
}
