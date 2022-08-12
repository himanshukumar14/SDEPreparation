package Strategy;

public class ExampleApplication {

	public static void main(String[] args) {
		Context context = new Context();

		String action = args[0];
		String first = args[1];
		String second = args[2];
		
		if (action == "addition")
			context.setStrategy(new ConcreteStrategyAdd());
		
		if (action == "subtraction")
			context.setStrategy(new ConcreteStrategySubtract());
	

		if (action == "multiplication")
			context.setStrategy(new ConcreteStrategyMultiply());

		int result = context.executeStrategy(Integer.valueOf(first), Integer.valueOf(second));
		System.out.println(result);
	}
}
