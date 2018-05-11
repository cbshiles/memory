package memory.tui;

import java.util.*;

import memory.note.Pointer;
import memory.tools.*;
import java.io.*;

public class Commander{

    public MainDisplay md;

    public Commander(MainDisplay m){
	md = m;
    }

    public void cmd(String[] args){
	char firstChar = args[0].charAt(0);
	if (Character.isLetter(firstChar)){
	    ErrorBuffer.set("letter");
	} else if (Character.isDigit(firstChar)){
	    try {
		int x = Integer.parseInt(args[0]);
		Pointer p = md.getPointer(x);
		if (p.isFolder){
		    md.setPath(p.fullName);
		} else {
		    Process emacs = Runtime.getRuntime().exec("emacsclient "+p.fullName);
		    ErrorBuffer.store("emacs is alive: "+emacs.isAlive());
		    BufferedReader errinput = new BufferedReader(new InputStreamReader(emacs.getErrorStream()));
		    String add = "";
		    while (errinput.ready()){
			add += errinput.readLine();
		    }
		    ErrorBuffer.store(add);
		}
		ErrorBuffer.set(p.name);
	    } catch (NumberFormatException ex){
		ErrorBuffer.set("Invalid number: "+args[0]);
	    } catch (BadCodeException ex){
		ErrorBuffer.set(ex.toString());
	    } catch (IOException ex){
		ErrorBuffer.set(ex.toString());
	    }
	} else {
	    ErrorBuffer.set("atm, commands must start w/ letter or digit");
	}
    }
}
