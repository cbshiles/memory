package memory;

import java.io.IOException;
import memory.tools.*;
import memory.tui.Tui;
import memory.text.*;
import java.util.*;

public class TestDriver{

    //TODO: property file to specify root directory

    public static String configFile = "config.properties";

    public static Tui tui;
    
    public static void main(String[] args) throws Exception{

	try {
	Properties props = Io.loadProperties(configFile);
	String storageRoot = props.getProperty("storage_root");
	String home = props.getProperty("homepage");
	System.out.println(".-->"+storageRoot);
	//System.out.println(TextClassMap.getAll(storageRoot));

	tui = new Tui(storageRoot, home);
	tui.start();
	} catch (Exception ex){
	    tui.close();
	    System.out.println(ex);
	}
    }
}
