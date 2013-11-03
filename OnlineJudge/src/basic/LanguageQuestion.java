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
	
	List<List<Object>> testCaseParameterObjsLists;
	
	public LanguageQuestion(String languageType,RawQuestion rawQuestion) {
		
		this.languageType = LanguageSet.valueOf(languageType);
		this.rawQuestion = rawQuestion;
		
		init(); // get the question parameter mapping relation
	}

	public void init(){
		
		languageTestCases = new ArrayList<LanguageTestCase>();
	}
	
	public void generateParameter(){
		
		List<ParameterConverter> parameterConverters = new ArrayList<ParameterConverter>();
		List<Integer> parameterPoses = new ArrayList<Integer>();
		for(int i=0;i<languageParameterSpecifics.size();i++){
			parameterConverters.add(ConverterFactory.getConverter(languageParameterSpecifics.get(i).getParameterConverterType()));
			parameterPoses.add(languageParameterSpecifics.get(i).getLanguageParameterPos());
		}
		
		testCaseParameterObjsLists = new ArrayList<List<Object>>();
		
		for(int i=0;i<languageTestCases.size();i++){
			
			List<Object> testCaseParameterObjs = new ArrayList<Object>();
			
			LanguageTestCase languageTestCase = languageTestCases.get(i);
			RawTestCase rawTestCase =  languageTestCase.getRawTestCase();
			List<RawParameter> rawParameters =  rawTestCase.getRawParameters();
			List<LanguageParameter> languageParameters = languageTestCase.getLanguageParameter();
			for(int j=0;j<parameterConverters.size();j++){
				
				
				int parameterPos = parameterPoses.get(j);
				RawParameter rawParameter = rawParameters.get(parameterPos);
				LanguageParameter languageParameter = languageParameters.get(j);
				languageParameter.setRawParameter(rawParameter);
				Object languageParameterObj = parameterConverters.get(j).convert(rawParameter.getRawParameterObj());
				// I think here must throw some exception
				languageParameter.setLanguageParameterObj(languageParameterObj);
				testCaseParameterObjs.add(languageParameterObj);
			}
			
			testCaseParameterObjsLists.add(testCaseParameterObjs);
		}
		
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
