package mainProcess;

import java.util.List;
import java.util.Map;

import basic.JudgeResult;
import basic.LanguageQuestion;
import basic.LanguageQuestion.LanguageSet;
import basic.RawQuestion;

public class MainProcess {
	
	Map<String, RawQuestion> rawQuestionCache; 
	Map<String, LanguageQuestion> languageQuestionCache;
	
	
	public JudgeResult judge(String questionName, String code, String languageType){
		
		LanguageSet languageEnum = LanguageQuestion.LanguageSet.valueOf(languageType);
		String languageQuestionKey = questionName + '_' + languageType;
		if(!languageQuestionCache.containsKey(languageQuestionKey)){
			
			String rawQuestionKey = "raw_" + questionName;
			
			if(!rawQuestionCache.containsKey(rawQuestionKey)){
				
				//�����ݿ������һ��Question���丽��
				RawQuestion rawQuestion = new RawQuestion();
				
				rawQuestion.generateParameter();
				//List<List<Object>> rawQuestionValue = rawQuestion.getMapValue();
				rawQuestionCache.put(rawQuestionKey, rawQuestion);
				
			}
			
			LanguageQuestion languageQuestion = new LanguageQuestion();
			
		}
		return null;
	}
	
	
}
