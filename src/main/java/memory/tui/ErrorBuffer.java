package memory.tui;

import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.*;

public class ErrorBuffer {

    public static Label label;

    static {
	label = new Label("Error buffer");
	label.setForegroundColor(TextColor.ANSI.RED);
    }

    public static void set(String msg){
	label.setText(msg);
    }
    
}
