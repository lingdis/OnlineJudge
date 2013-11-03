package basic;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import javax.tools.JavaCompiler.CompilationTask;

public class JavaJudger extends Judger{

	
	
	
	public JavaJudger(LanguageQuestion languageQuestion, String code) {
		super(languageQuestion, code);
	}

	@Override
	public JudgeResult judge(){
		
		long currentTime = System.currentTimeMillis();
		String tempCodeFile = currentTime + this.languageQuestion.getMapKey();
		File file = new File(tempCodeFile);
		
		// do not consider the file name exist situation temporarily
		if(!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try {
			FileWriter fileWriter = new FileWriter(file);
			fileWriter.write(code);
			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();
		StandardJavaFileManager javaFileManager = javaCompiler.getStandardFileManager(null, null, null);
		
		Iterable codeFiles = javaFileManager.getJavaFileObjects(tempCodeFile);
		//in here, may be we could use a queue to contain all the file need to compile and a thread just
		//get get code from this queue to compile
		
		Iterator ite = codeFiles.iterator();
		
		// just for fun
		while(ite.hasNext()){
			JavaFileObject jfo = (JavaFileObject) ite.next();
			System.out.println(jfo.getClass());
			System.out.println(jfo.toUri());
			System.out.println(jfo.getKind());
		}
		
		CompilationTask compilationTask = javaCompiler.getTask(null, javaFileManager, null, null, null, codeFiles);
		compilationTask.call();
		try {
			javaFileManager.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
