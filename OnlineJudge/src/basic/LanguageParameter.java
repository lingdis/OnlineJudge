package basic;

public class LanguageParameter {
	
	//int languangeParameterId;
	RawParameter rawParameter;
	Object languageParameterObj;
	
	public Object getRawParameterObj(){
		
		return rawParameter.getRawParameterObj();
	}
	

	public RawParameter getRawParameter() {
		return rawParameter;
	}
	public void setRawParameter(RawParameter rawParameter) {
		this.rawParameter = rawParameter;
	}
	public Object getLanguageParameterObj() {
		return languageParameterObj;
	}
	public void setLanguageParameterObj(Object languageParameterObj) {
		this.languageParameterObj = languageParameterObj;
	}
	
	
	
}
