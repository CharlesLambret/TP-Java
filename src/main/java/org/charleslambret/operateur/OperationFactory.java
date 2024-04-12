package org.charleslambret.operateur;

import java.util.Map;
import java.util.function.DoubleBinaryOperator;
import org.apache.commons.lang3.Validate;

public class OperationFactory {
    private Map<String, DoubleBinaryOperator> operations;

    public OperationFactory() {
        operations = Map.of(
            "+", (a, b) -> a + b,
            "-", (a, b) -> a - b,
            "*", (a, b) -> a * b
        );
    }

    public OperationStrategy getOperation(String op) throws OperationException {
        Validate.notNull(op, "Le symbole de l'opération ne peut pas être null");
        DoubleBinaryOperator operation = operations.get(op);
        if (operation == null) {
            throw new OperationException("Opérateur non supporté: " + op);
        }
        return (num1, num2) -> operation.applyAsDouble(num1, num2);
    }
}
