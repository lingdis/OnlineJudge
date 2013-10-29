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
	
	List<RawParameter> rawParameters;
	
	public List<RawParameter> getRawParameters(){
		
		return rawParameters;
	}

}
