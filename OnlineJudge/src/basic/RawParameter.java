package basic;

public class RawParameter {
	
	int testCaseId;
	int rawParameterSpecificId;
	String rawParameterStr;
	Object rawParameterObj;
	
	public void setRawParameterObj(Object obj){
		
		this.rawParameterObj = obj;
	}
	
	public String getRawParameterStr(){
		
		return rawParameterStr;
	}
}
