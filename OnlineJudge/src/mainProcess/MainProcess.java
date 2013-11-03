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
				
				//从数据库里面读一个Question及其附属
				RawQuestion rawQuestion = new RawQuestion();
				
				rawQuestion.generateParameter();
				//List<List<Object>> rawQuestionValue = rawQuestion.getMapValue();
				rawQuestionCache.put(rawQuestionKey, rawQuestion);
				
			}
			
			RawQuestion rawQuestion = rawQuestionCache.get(rawQuestionKey);
			LanguageQuestion languageQuestion = new LanguageQuestion(languageType,rawQuestion);
			languageQuestion.generateParameter();
			languageQuestionCache.put(languageQuestionKey, languageQuestion);
			
		}
		
		
		
		return null;
	}
	
	
}
