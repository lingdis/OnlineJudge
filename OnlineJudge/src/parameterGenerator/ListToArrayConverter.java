package parameterGenerator;

import java.util.ArrayList;

public class ListToArrayConverter extends ParameterConverter<ArrayList<Integer>,int[]> {

	
	
	
	@Override
	public int[] convert(ArrayList<Integer> from) {
		// TODO Auto-generated method stub
		
		int[] result = new int[from.size()];
		for(int i=0;i<result.length;i++){
			result[i] = from.get(i);
		}
		return result;
	}

}
