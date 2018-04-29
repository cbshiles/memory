package memory.note;

import memory.text.Metadata;
import memory.text.NonBasicText;

public class Folder extends NonBasicText{
	
	String dir;
	
	public Folder(String dir) {
		super(dir+"/mem.folder", Folder.class);
		this.dir = dir;
	}

	@Override
	public Metadata getMetadata() {
		return new Metadata(getClassName());
	}

	@Override
	public String getBody() {
		return "";
	}
	
	public void del() {
		//recursively delete
	}
	
	

}
