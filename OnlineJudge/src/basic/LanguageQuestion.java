package basic;

import java.util.List;


public class LanguageQuestion {
	
	public enum LanguageSet{
		JAVA, CPP
	}
	
	RawQuestion rawQuestion;
	LanguageSet languageType;
	
	
	public void generateParameter(){
		
	}
	
	
	
	public String getMapKey(){
		
		String questionName = rawQuestion.getName();
		String keyStr = languageType.name() + "_" + questionName;
		
		return keyStr;
	}
	
	public List<List<Object>> getMapValue(){
		
		return null;
	}
	
	
}
