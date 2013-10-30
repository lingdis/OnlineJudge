package basic;

import java.util.ArrayList;
import java.util.List;

import parameterGenerator.ConverterFactory;
import parameterGenerator.ParameterConverter;


public class LanguageQuestion {
	
	public enum LanguageSet{
		JAVA, CPP
	}
	
	RawQuestion rawQuestion;
	LanguageSet languageType;
	
	List<LanguageParameterSpecific> languageParameterSpecifics;
	List<LanguageTestCase> languageTestCases;
	
	
	public void init(){
		
		languageTestCases = new ArrayList<LanguageTestCase>();
	}
	
	public void generateParameter(){
		
		List<ParameterConverter> parameterConverters = new ArrayList<ParameterConverter>();
		for(int i=0;i<languageParameterSpecifics.size();i++){
			parameterConverters.add(ConverterFactory.getConverter(languageParameterSpecifics.get(i).getParameterConverterType()));
		}
		
		for(int i=0;i<languageParameterSpecifics)
		
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
