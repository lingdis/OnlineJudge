package parameterGenerator;

public class IntGenerator extends QuestionParameterGenerator<Integer>{

	@Override
	public Integer generate(String str) {
		// TODO Auto-generated method stub
		return Integer.parseInt(str);
	}

	@Override
	public Class getParameterType() {
		// TODO Auto-generated method stub
		return Integer.class;
	}

}
