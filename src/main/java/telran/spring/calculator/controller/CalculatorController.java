package telran.spring.calculator.controller;

import java.util.*;
import org.springframework.web.bind.annotation.*;
import telran.spring.calculator.dto.OperationData;
import telran.spring.calculator.service.Operation;

@RestController
@RequestMapping("calculator")
public class CalculatorController {
	Map<String, Operation> operations;

	public CalculatorController(Map<String, Operation> operations) {
		this.operations = operations;
	}

	@PostMapping
	String sendMessage(@RequestBody OperationData operationData) {
		Operation operation = operations.get(operationData.operationName);
		return operation != null ? operation.execute(operationData) : "Wrong type " + operationData.operationName;
	}

	@GetMapping
	Set<String> getTypes() {
		return operations.keySet();
	}

}
