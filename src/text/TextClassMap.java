package memory.text;

import java.io.File;
import java.util.*;
import memory.tools.*;

public class TextClassMap{

    private static Map<String, Class<? extends TextClass>> map = new HashMap<>();

    static{
	put(BasicTxt.class);
    }


    //note: using simple name, but name collisions need to be avoided
    public static <T extends TextClass> void put(Class<T> c){
	System.out.println(c.getSimpleName());
	map.put(c.getSimpleName(), c);
    }

    public static TextClass get(String className, String id, String body) throws Exception{
	System.out.println(className);
	Class<? extends TextClass> c = map.get(className);
	return (TextClass) c.getConstructor(new Class[]{String.class, String.class}).newInstance(id, body);
    }

    public static List<TextClass> getAll(String path)throws Exception{
	List<TextClass> texts = new ArrayList<>();
	for (File file: FileTool.getFiles(path)){
	    String[] arr = file.getName().split("_");
	    String className = arr[0];
	    String id = (arr.length>1)?arr[1]:"";
	    String body = FileTool.read(file.getAbsolutePath());
	    texts.add(get(className, id, body));
	}
	return texts;
    }
}
