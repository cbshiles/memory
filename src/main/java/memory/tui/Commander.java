package memory.tui;

import java.util.*;

import memory.note.Pointer;
import memory.tools.*;
import java.io.*;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


public class Commander{

    public MainDisplay md;

    private static final Logger log = LogManager.getLogger(Commander.class);

    public Commander(MainDisplay m){
	md = m;
    }

    public void writeTmp(String content) throws IOException{
	Io.write("/tmp/memory.tmp", content, false);
    }

    public void cmd(String[] args)throws IOException{
	char firstChar = args[0].charAt(0);
	if (Character.isLetter(firstChar)){
	    switch (args[0]){
	    case "exit":
		writeTmp("EXIT");
		throw new BadCodeException("Exiting memory.");
	    case "new":
		writeTmp(md.path+"/"+args[1]);
		throw new BadCodeException("RUNNING EMACS");
	    default:
		ErrorBuffer.set("letter");
	    }
	} else if (Character.isDigit(firstChar)){
	    try {
		int x = Integer.parseInt(args[0]);
		Pointer p = md.getPointer(x);
		if (p.isFolder){
		    md.setPath(p.fullName);
		} else {
		    writeTmp(p.fullName);
		    throw new BadCodeException("RUNNING EMACS");
		}
		ErrorBuffer.set(p.name);
	    } catch (NumberFormatException ex){
		ErrorBuffer.set("Invalid number: "+args[0]);
	    }
	} else {
	    ErrorBuffer.set("atm, commands must start w/ letter or digit");
	}
    }
}
