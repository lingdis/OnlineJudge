package basic;


public class LanguageQuestion {
	
	public enum LanguageSet{
		Java, CPP
	}
	
	RawQuestion rawQuestion;
	LanguageSet languageType;

	
	public String getMapKey(){
		
		String questionName = rawQuestion.getName();
		String keyStr = languageType.name() + questionName;
		
		return keyStr;
	}
	
	public List<List<Object>> getMapValue(){
		
	}
	
	
}
