package memory.tools;

import java.util.List;

public class Str{

        public static String concat(List<String> lzt, String glue){
	if (glue==null)glue="";
	StringBuffer sb = new StringBuffer();
	for (String str: lzt)
	    sb.append(str+glue);
	return sb.toString();
    }

}
