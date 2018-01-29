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

    private static Map<String, Class<? extends TextClass>> map = new HashMap<>();

    static{
	for (Class<? extends TextClass> c: Lzt.listIt(BasicTxt.class)){
	    put(c);
	}
    }


    //note: using simple name, but name collisions need to be avoided
    public static <T extends TextClass> void put(Class<T> c){
	System.out.println(c.getSimpleName());
	map.put(c.getSimpleName(), c);
    }

    private static TextClass transform(File file) throws Exception{
	String body = Io.read(file.getAbsolutePath());
	Pair<String, String> nameParts = parseName(file.getName());
	Class<? extends TextClass> c = map.get(nameParts.a);
	return (TextClass) c.getConstructor(new Class[]{String.class, String.class}).newInstance(nameParts.b, body);
    }

    /**
     * a is the class name
     * b is the id
     */
    private static Pair<String, String> parseName(String fname){
	String[] arr = fname.split("_");
	return new Pair<>(arr[0], (arr.length>1)?arr[1]:null);
    }

    public static TextClass get(String path, String id)throws Exception{
	TextClass text = null;
	for (File file: Io.getFiles(path)){
	    if (id.equals(parseName(file.getName()).b))
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
