package memory.tui;

import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.*;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class ErrorBuffer {

    private static final Logger log = LogManager.getLogger(ErrorBuffer.class);
    public static Label label;
    public static String store;
    
    static {
	label = new Label("Error buffer");
	label.setForegroundColor(TextColor.ANSI.RED);
    }

    public static void set(String msg){
	store(msg);
	label.setText(msg);
	log.info("ErrorBuffer: "+msg);
    }

    public static void store(String str){
	store += str+"\n";
    }

}
