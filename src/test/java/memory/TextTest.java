import static org.junit.Assert.*;
import org.junit.*;
import memory.tools.*;
import memory.note.*;
import java.util.*;

public class TextTest {

    /**
     * Make a directory, put a FirstNote in there, read it,
     * delete it, delete directory
     * Will bork on windows atm
     */
    @Test
    public void basic(){
	String name = "abcddcbbaaa";
	String path = "/tmp/"+name;
	Io.mkdir(path);
	String noteName = "zzzz";
	String notePath = path+"/"+noteName;
	boolean trueBit = true;

	Note n = new FirstNote(null, null, "Hello Memory!");
	
	List<String> lzt = Io.ls(path);
	trueBit &= (lzt.size() == 1);
	if (trueBit)
	    trueBit &= lzt.get(0).equals(noteName);
	
	Io.delete(noteName);
	Io.delete(name);
	assertTrue(trueBit);
    }

}
