package basic;

import java.util.List;

public class LanguageTestCase {
	
	
	int languageTestCaseId;
	RawTestCase rawTestCase;
	
	List<LanguageParameter> languageParameter;
	
	public LanguageTestCase(){
		
	}

	public int getLanguageTestCaseId() {
		return languageTestCaseId;
	}

	public void setLanguageTestCaseId(int languageTestCaseId) {
		this.languageTestCaseId = languageTestCaseId;
	}

	public RawTestCase getRawTestCase() {
		return rawTestCase;
	}

	public void setRawTestCase(RawTestCase rawTestCase) {
		this.rawTestCase = rawTestCase;
	}

	public List<LanguageParameter> getLanguageParameter() {
		return languageParameter;
	}

	public void setLanguageParameter(List<LanguageParameter> languageParameter) {
		this.languageParameter = languageParameter;
	}
	

}

