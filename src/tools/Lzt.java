package memory.tools;

import java.util.*;
public class Lzt{

    /**
     * Make a list of Objects
     * @param t The Objects to turn into a list
     * @return List<T> 
     */
    @SafeVarargs
    public static <T> List<T> listIt(T... t) {
	List<T> lzt = new ArrayList<T>();
	for (T i : t) {
	    lzt.add(i);
	}
	return lzt;
    }
}
