package parameterGenerator;

import java.util.ArrayList;

public abstract class QuestionParameterGenerator<T> {
	
	public abstract T generate(String str);
	
	public abstract Class getParameterType();

	
	public static void main(String args[]){
		System.out.println("here");
		
		ArrayList<QuestionParameterGenerator> list = new ArrayList<QuestionParameterGenerator>();
		
		list.add(new IntGenerator());
		list.add(new StringGenerator());
		list.add(new IntListGenerator());
		
		ArrayList<String> arguStrs = new ArrayList<String>();
		arguStrs.add("123");
		arguStrs.add("abcdef");
		arguStrs.add("1,4,5,6,7");
		
		for(int i=0;i<list.size();i++){
			Object o = list.get(i).generate(arguStrs.get(i));
			System.out.println(o.toString());
		}
	}
}
