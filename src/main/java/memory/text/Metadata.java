package memory.text;

import java.time.LocalDate;
import java.util.*;

public class Metadata{
	public static final String s = " ";
    String name;
    Map<String, String> map = new HashMap<>();
    
    public Metadata(String str){
	String[] daters = str.split(s);
	name = daters[0];
	for (int x=1; x<daters.length-1; x+=2) {
		map.put(daters[x], daters[x+1]);
	}
    }

    public String getClassName(){
	return name;
    }
    
    public LocalDate getDate(String key) {
    	return LocalDate.parse(map.get(key));
    }
    
    public String getString(String key) {
    	return map.get(key);
    }
    
    @Override
    public String toString() {
    	StringBuilder sb = new StringBuilder(name);
    	for (String key: map.keySet()) {
    		sb.append(s+key+s+map.get(key));
    	}
    	return sb.toString();
    }
}
