package telran.spring.calculator.service;

import java.util.HashMap;
import java.util.function.BiFunction;

import org.springframework.stereotype.Service;

import telran.spring.calculator.dto.ArithmeticOperationData;
import telran.spring.calculator.dto.OperationData;

@Service("arithmetic operation")
public class ArithmeticSimpleOperation implements Operation {

	private static HashMap <String, BiFunction<Double, Double, String>> operations;
	 
	 static {
		 operations = new HashMap<>();
		 operations.put("+", (o1, o2) -> String.valueOf(o1+o2));
		 operations.put("-", (o1, o2) -> String.valueOf(o1-o2));
		 operations.put("/", (o1, o2) -> String.valueOf(o1/o2));
		 operations.put("*", (o1, o2) -> String.valueOf(o1*o2));
	 }

		@Override
		public String execute(OperationData data) {
			ArithmeticOperationData aod = (ArithmeticOperationData) data;
			var function = operations.getOrDefault(data.additionalData,
					(o1, o2) -> "wrong sign");
			return function.apply(aod.operand1, aod.operand2);
		}

}
