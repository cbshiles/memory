package memory.tools;

import java.util.*;
public class ListTool{
    
    @SafeVarargs
    public static <T> List<T> listIt(T... t) {
	List<T> lzt = new ArrayList<T>();
	for (T i : t) {
	    lzt.add(i);
	}
	return lzt;
    }
}
