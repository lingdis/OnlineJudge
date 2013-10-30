package parameterGenerator;

public abstract class ParameterConverter<From,To> {
	
	public abstract To convert(From from);
}
