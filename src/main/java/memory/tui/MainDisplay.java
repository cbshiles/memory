package memory.tui;

import memory.note.Pointer;
import memory.tools.*;
import com.googlecode.lanterna.gui2.Label;
import java.util.*;

public class MainDisplay {

    public String root, path;
    StringBuilder sb = new StringBuilder();
    int lc = 0; //line count
    public Label label = new Label("");
    List<Pointer> pointers = new ArrayList<>();
    
    public MainDisplay(String root, String path){
	this.root = root;
	this.path = path;
	setDisplay();
    }

    public void setDisplay(){
	addLine(new Pointer (path, ".."));
	for (String fname: Io.ls(path)){
	    Pointer p = new Pointer (path, fname);
	    addLine(p);
	    ErrorBuffer.set(p.fullName);
	}
	label.setText(flush());
    }

    public void setPath(String p){
	path = p;
	pointers = new ArrayList<>();
	setDisplay();
    }
    
    private void addLine(Pointer p){
	pointers.add(p);
	sb.append((lc++)+" "+p+"\n");
    }

    private String flush(){
	String ret = sb.toString();
	sb.setLength(lc = 0);
	return ret;
    }

    public Pointer getPointer(int index){
	if (index < 0 || index >= pointers.size()){
	    ErrorBuffer.set("There is no item "+index+" on this list.");
	    return null;
		}
	return pointers.get(index);
    }
    
}
