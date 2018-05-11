package memory.tui;

import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.*;

public class ErrorBuffer {

    public static Label label;
    public static String store;
    
    static {
	label = new Label("Error buffer");
	label.setForegroundColor(TextColor.ANSI.RED);
    }

    public static void set(String msg){
	store(msg);
	label.setText(msg);
    }

    public static void store(String str){
	System.err.println("<----"+str+"-->");
	store += str+"\n";
    }

}
