package basic;

import java.util.ArrayList;
import java.util.List;

import parameterGenerator.GeneratorFactory;
import parameterGenerator.QuestionParameterGenerator;

public class RawQuestion {
	
	String name;
	String discription;
	
	List<RawTestCase> rawTestCases;
	List<RawParameterSpecific> rawParameterSpecifics;
	List<List<Object>> testCaseParameterObjsLists;
	
	public String getName(){
		return name;
	}
		
	public void generateParameter(){
		
		testCaseParameterObjsLists = new ArrayList<List<Object>>();
		
		List<QuestionParameterGenerator> parameterGenerators = new ArrayList<QuestionParameterGenerator>();
		for(int i=0;i<rawParameterSpecifics.size();i++){
			parameterGenerators.add(GeneratorFactory.getGenerator(rawParameterSpecifics.get(i).getAppParameterType()));
		}
		for(int i=0;i<rawTestCases.size();i++){
			
			RawTestCase testCase = rawTestCases.get(i);
			List<RawParameter> rawParameters = testCase.getRawParameters();
			List<Object> testCaseParameterObjs = new ArrayList<Object>();
			for(int j=0;j<parameterGenerators.size();j++){
				
				String parameterStr = rawParameters.get(j).getRawParameterStr();
				Object parameterObj = parameterGenerators.get(j).generate(parameterStr);
				testCaseParameterObjs.add(parameterObj);
				rawParameters.get(j).setRawParameterObj(parameterObj);
			}
			
		}
	}
	
	public String getMapKey(){
		
		String keyStr = "raw" + name;
		
		return keyStr;
	}
	
	public List<List<Object>> getMapValue(){
		
		return testCaseParameterObjsLists;
	}
}
