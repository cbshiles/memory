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

    //TODO: property file to specify root directory

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
	    System.out.println(".-->"+storageRoot);
	    //System.out.println(TextClassMap.getAll(storageRoot));

	    // Process emacs = Runtime.getRuntime().exec("emacs -nw");
	    // emacs.waitFor();
	    // ErrorBuffer.store("emacs is alive: "+emacs.isAlive());
	    // errinput = new BufferedReader(new InputStreamReader(emacs.getErrorStream()));
	    
	    tui = new Tui(storageRoot, home);
	    tui.start();
	} catch (Exception ex){
	    if (tui != null) tui.close();
	    log.error(ex.getStackTrace().toString());
	}
	//System.out.println(ErrorBuffer.store);
	String add = "";
	while (errinput.ready()){
	    log.info(errinput.readLine());
	}
    }
}
