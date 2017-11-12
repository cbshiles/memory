package memory;

import java.io.IOException;
import memory.tools.*;
import memory.text.*;

public class TestDriver{

    //TODO: property file to specify root directory

    public static void main(String[] args) throws Exception{
	String path = "/home/brenan/code/memory/sandbox/test.z";
	//	String wpath = "/home/brenan/code/memory/sandbox/test.w";
	//FileTool.writeIfNew(wpath, "ass");
	String textRoot = "/home/brenan/code/memory/sandbox/";
	System.out.println(TextClassMap.getAll(textRoot));
    }
}
