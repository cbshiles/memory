package memory.note;

import memory.tools.*;

public class Pointer{

    public boolean isFolder;
    public String path, name, fullName;

    public Pointer (String p, String n){
	path = p;
	name = n;
	fullName = path+"/"+name;
	isFolder = !Io.isFile(fullName);
    }

    public String toString(){
	return name+" "+(isFolder?"Folder":"Note");
    }
}
