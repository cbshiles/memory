package memory.text;

public class BasicTxt extends TextClass{

    public String str;

    public BasicTxt(String fname, String content){
    	super(fname);
    	str = content;
    }
    
    public String textualize(){
    	return str;
    }
    
}
