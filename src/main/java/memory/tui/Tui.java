package memory.tui;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import java.io.IOException;

public class Tui {

    MainDisplay ds;
    Commander cmdr;
    Screen screen;
    Terminal terminal;
    BasicWindow window;
    MultiWindowTextGUI gui;
    
    public Tui (String root, String home){
	String path = root;
	if (path.charAt(path.length()-1) != '/'){
	    path += "/";
	}
	if (home != null){
	    path += home;
	}
	ds = new MainDisplay(root, path);
	cmdr = new Commander(ds);
    }

    public void start ()throws IOException{
	        // Setup terminal and screen layers
	terminal = new DefaultTerminalFactory().createTerminal();
        screen = new TerminalScreen(terminal);
        screen.startScreen();

        // Create panel to hold components
        Panel panel = new Panel();
        panel.setLayoutManager(new GridLayout(1));

        panel.addComponent(ds.label);

	TextBox tb = new TextBox();
        panel.addComponent(tb);

        panel.addComponent(new EmptySpace(new TerminalSize(0,0))); // Empty space underneath labels
        panel.addComponent(new Button("Submit", new Runnable() {
		@Override
		public void run() {
		    cmdr.cmd(tb.getText().trim().split("[ \\t]+"));
		}
	    }));
        panel.addComponent(ErrorBuffer.label);

	// Create window to hold the panel
        window = new BasicWindow();
        window.setComponent(panel);

        // Create and start gui
        gui = new MultiWindowTextGUI(screen, new DefaultWindowManager(), new EmptySpace(TextColor.ANSI.BLUE));
        gui.addWindowAndWait(window);
    }

    public void close() throws IOException{
	window.close();
	screen.stopScreen();
	terminal.close();
    }
    
}
