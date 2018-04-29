package memory.tools;

import java.io.File;
import java.util.*;
import memory.text.*;

/**
 * Acts like, a static tool class, maybe should be in that package
 * Leave rest of text classes in this package
 * Contains map of class names to the actual classes
 * This is used to create an object (which inherits from TextClass) from a text file
 */
public class TextClassMap{

    private static Map<String, Class<? extends TextClass>> map = null;

    public static final String metaDelimiter = "@$#@$#@%#^#SLAK 43@%RWF2 @#$RWR@#@2##||#@R#";

    //note: using simple name, but name collisions need to be avoided
    public static <T extends TextClass> void put(Class<T> c){
	System.out.println(c.getSimpleName());
	map.put(c.getSimpleName(), c);
    }

    public static void setMap(List<Class<? extends TextClass>> lzt){
	map = new HashMap<>();
	for (Class<? extends TextClass> c: lzt){
	    put(c);
	}
    }

    public static Class<? extends TextClass> get (String key){
	if (map == null) throw new BadCodeException("Class map not set yet.");
	return map.get(key);
    }

    /**
     * Takes a file, reads the metadata, and creates a new TextClass
     * with a constructor which takes the file's name and the body of the file.
     */
    private static TextClass transform(File file) throws Exception{
	String body = Io.read(file.getAbsolutePath());
	int i = body.indexOf(metaDelimiter);
	Metadata meta = null;
	TextClass ret;
	if (i != -1){
	    meta = new Metadata(body.substring(0, i));
	    body = body.substring(i+metaDelimiter.length());
	    ret = get(meta.getClassName()).getConstructor
		(new Class[]{String.class, Metadata.class, String.class})
		.newInstance(file.getName(), meta, body);
	} else {
	    ret = new BasicTxt(file.getName(), body);
	}
	return ret;
    }

    public static TextClass get(String path, String id)throws Exception{
	TextClass text = null;
	for (File file: Io.getFiles(path)){
	    if (id.equals(file.getName()))
		text = transform(file);
	}
	return text;
    }
    
    public static List<TextClass> getAll(String path)throws Exception{
	List<TextClass> texts = new ArrayList<>();
	for (File file: Io.getFiles(path)){
	    texts.add(transform(file));
	}
	return texts;
    }
}
