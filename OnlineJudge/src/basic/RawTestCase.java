package basic;

import java.util.ArrayList;
import java.util.List;

import parameterGenerator.GeneratorFactory;
import parameterGenerator.QuestionParameterGenerator;

public class RawTestCase {
	
	int testCaseId;
	int questionId;
	int testCaseNo;
	
	 
	//String strReturnValue; 
	//Object rawReturnValue;
	//make the the returnValue as last of parameters
	
	List<StrParameter> strParameters;
	List<Object> rawParameters;
	
	
	public void generateRawParameters(){
		
		for(int i=0;i<strParameters.size();i++){
			
			//QuestionParameterGenerator parameterGenerator = GeneratorFactory.getGenerator(rawParameterTypes.get(i));
			//parameterGenerator.generate(strParameters.get(i).)
		}
	}
}
