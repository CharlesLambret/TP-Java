package src.main.java;
import java.util.Map;
import java.util.function.DoubleBinaryOperator;

public class OperationFactory {
    private static final Map<String, DoubleBinaryOperator> operations = Map.of(
        "+", (a, b) -> a + b,
        "-", (a, b) -> a - b,
        "*", (a, b) -> a * b
    );

    public static OperationStrategy getOperation(String op) throws OperationException {
        DoubleBinaryOperator operation = operations.get(op);
        if (operation == null) {
            throw new OperationException("Opérateur non supporté: " + op);
        }
        return (num1, num2) -> operation.applyAsDouble(num1, num2);
    }
}
