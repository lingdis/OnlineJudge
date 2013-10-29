package test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Iterator;

import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;


//��������ֻ��jdk6�������
public class CompilerTest {
	//window����Ļ�����\r\t �س�����
	public static void main(String[] args) throws IOException, ClassNotFoundException, Exception {
		//�õ�ϵͳ��ǰ��·��,����java���̵�·��(E:\workspace\base)
		System.out.println(System.getProperty("user.dir"));
		
		//�ڳ������java�ļ����б��룬ҲӦ�þ��Ƕ�̬������
		
		writejavaFile();
		//�õ�ϵͳ��ǰ��java��������Ҳ����javac
		JavaCompiler javac=ToolProvider.getSystemJavaCompiler();
		//������jre�����л�������Ϊ����Ǵ����汾��������javac�ȣ���Ҫʹ��jdk����,�������null
		//�ȵõ�һ���ļ��������
		//�ö���ĵ�һ����������ϼ�����,
		StandardJavaFileManager javafile=javac.getStandardFileManager(null, null, null);
		String filename = "D:/JavaTest.java";
		String txtFilename = "D:/Test.java";
		//String classFilename = "D:/JavaTest.class";
		//���뵥Ԫ�������ж��
		Iterable units=javafile.getJavaFileObjects(filename,filename,txtFilename);
		
		
		
		
		Iterator ite = units.iterator();
		while(ite.hasNext()){
			JavaFileObject jfo = (JavaFileObject) ite.next();
			System.out.println(jfo.getClass());
			System.out.println(jfo.toUri());
			System.out.println(jfo.getKind());
		}
		
		//��������
		//CompilationTask t=javac.getTask(null, javafile, null, null, null, units);
		CompilationTask t=javac.getTask(null, null, null, null, null, units);
		t.call();
		javafile.close();
		
		////�Ѹղ���D:/�����ɵ�class�ļ�JavaTest.class���ؽ��ڴ沢����ʵ������
		URL[] urls=new URL[]{new URL("file:/d:/")};
		URLClassLoader classload=new URLClassLoader(urls);
		Class clazz=classload.loadClass("JavaTest");
		Method method=clazz.getMethod("main", String[].class);
		
		//ע�⣬����Method��ķ���invoke(Object,Object), main��������Run�ľ�̬����������ʱ�ǲ���Ҫ����ʵ���ġ�
		//Java��ͨ����������������е�main����ʱҪע�������
		//http://www.cnblogs.com/duancanmeng/archive/2012/04/14/2524614.html
		method.invoke(clazz.newInstance(),(Object)new String[]{});
		
	}
	//����java�ļ�
	public static void writejavaFile() throws IOException{
		File file=new File("D:/JavaTest.java");
		if(!file.exists()){
			file.createNewFile();
		}
		FileWriter fw = new FileWriter(file);
		fw.write(javaClassContent());
		fw.close();
	}
	//���ַ������ӳ�һ��java��
	public static String javaClassContent(){
		String rt="\r\n";
		String java=new String();
		java+="public class JavaTest{"+rt;
		java+=" public static void main(String[] args){"+rt;
		java+="		System.out.println(\"hello world\");"+rt;
		java+="		show();"+rt;
		java+="	}"+rt;
		java+="	public static void show(){"+rt;
		java+="		for(int i=0;i<4;i++){"+rt;
		java+="			System.out.println(\"i=:\"+i);"+rt;
		java+="		}"+rt;
		java+="	}"+rt;
		java+="}";
		return java;
	}
	/**
	 * ���н����
	 * hello world
	 * i=:0
	 * i=:1
	 * i=:2
	 * i=:3
	 */
}