package basic;

import java.io.File;

public abstract class Judger {
	
	public static final String compileFilePath = "D:\\onlineJudge";
	
	LanguageQuestion languageQuestion;
	String code;
	
	public Judger(LanguageQuestion languageQuestion, String code){
		this.languageQuestion = languageQuestion;
		this.code = code;
	}
	
	public abstract JudgeResult judge();
}
