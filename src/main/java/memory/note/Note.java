package memory.note;

import memory.text.Metadata;
import memory.text.NonBasicText;

public abstract class Note extends NonBasicText{

	public Note(String fname, Class<? extends NonBasicText> c) {
		super(fname, c);
	}

	@Override
	public Metadata getMetadata() {
		return new Metadata(getClassName());
	}

}
