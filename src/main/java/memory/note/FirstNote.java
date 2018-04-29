package memory.note;

import java.time.*;

import memory.text.Metadata;

public class FirstNote extends Note {

	LocalDate start, end;
	String body;
	Metadata meta;

	public FirstNote(String fname, LocalDate s, LocalDate e, String msg) {
		super(fname, FirstNote.class);
		start = s;
		end = e;
		body = msg;
		meta = new Metadata(getClassName() + " start " + start + " end " + end);
	}

	public FirstNote(String fname, Metadata meta, String msg) {
		super(fname, FirstNote.class);
		this.meta = meta;
		body = msg;
	}

	@Override
	public Metadata getMetadata() {
		return meta;
	}

	@Override
	public String getBody() {
		return body;
	}
}
