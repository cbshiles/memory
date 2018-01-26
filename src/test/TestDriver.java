package memory.test;

import java.io.IOException;
import memory.tools.*;
import memory.text.*;
import java.util.*;

public class TestDriver{

    //TODO: property file to specify root directory

    public static String configFile = "config.properties";
    
    public static void main(String[] args) throws Exception{

	Properties props = Io.loadProperties(configFile);
	String storageRoot = props.getProperty("storage_root");
	String path = "/home/brenan/code/memory/sandbox/test.z";
	//	String wpath = "/home/brenan/code/memory/sandbox/test.w";
	//FileTool.writeIfNew(wpath, "ass");
	System.out.println("-->"+storageRoot);
	System.out.println(TextClassMap.getAll(storageRoot));
    }
}
