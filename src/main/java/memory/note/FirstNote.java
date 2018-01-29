package memory.note;

import java.time.*;

public class FirstNote extends Note{
    
    LocalDate start, end;
    String msg;
    
    public FirstNote(LocalDate s, LocalDate e, String gms){
	start=s;
	end=e;
	msg=gms;
    }

    public String textualize(){
	return ""+start+" : "+end+"\n"+msg;
    }
}
