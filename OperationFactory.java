public class OperationFactory {
    public static OperationStrategy getOperation(String op) throws OperationException {
        switch (op) {
            case "+":
            return String.valueOf(num1 + num2);
            case "-":
            return String.valueOf(num1 - num2);
            case "*":
            return String.valueOf(num1 * num2);
            default:
                throw new OperationException("Opérateur non supporté: " + op);
        }
    }
}
