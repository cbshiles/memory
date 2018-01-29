package memory.note;

import memory.tools.*;

/**
 * This class serves as the interface between the data retrevial code and the end user code such as a terminal or web app.
 */
public class Membrane{

    private String folder = "";
    
    String createNote(){
	return null;
    }

    void deleteNote(String id)throws Exception{

    }

    void modifyNote(String id)throws Exception{

    }

    Note getNote(String id) throws Exception{
	return (FirstNote) TextClassMap.get(folder, id);
    }
		    
}
