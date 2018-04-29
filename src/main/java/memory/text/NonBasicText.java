package memory.text;

import memory.tools.TextClassMap;

public abstract class NonBasicText extends TextClass{

    Class<? extends NonBasicText> clas;
    
    public NonBasicText(String fname, Class<? extends NonBasicText> c){
    	super(fname);
    	clas = c;
    }

    public String getClassName(){
    	return clas.getName();
    }

    public abstract Metadata getMetadata();
    
    public abstract String getBody();
    
    @Override 
    public String textualize() {
    	return getMetadata().toString()+TextClassMap.metaDelimiter+getBody();
    }
}
