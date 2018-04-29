package memory.text;

import java.io.IOException;

import memory.tools.*;

public abstract class TextClass{
	
	public String fname;
	
	public TextClass(String fname) {
		this.fname = fname;
	}

    public abstract String textualize();
    
    public void save() throws IOException {
    	Io.write(fname, textualize(), false);
    }
    
}
