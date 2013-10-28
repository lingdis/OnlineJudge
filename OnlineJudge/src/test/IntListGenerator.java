package test;

import java.util.ArrayList;

public class IntListGenerator extends TestGeneric<ArrayList<Integer>>{

	@Override
	public ArrayList<Integer> generate(String str) {
		// TODO Auto-generated method stub
		
		String arr[] = str.split(",");
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<arr.length;i++){
			list.add(Integer.parseInt(arr[i]));
		}
		
		return list;
	}

}
