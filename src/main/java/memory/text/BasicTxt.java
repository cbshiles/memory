package memory.text;

public class BasicTxt extends TextClass{


    public String str;

    public BasicTxt(String id, String content){
	str = content;
    }
    
    public String textualize(){
	return str;
    }
    
}
