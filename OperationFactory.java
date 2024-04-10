public class OperationFactory {
    public static OperationStrategy getOperation(String op) throws OperationException {
        switch (op) {
            case "+":
            return new Addition();
            case "-":
            return new Soustraction();
            case "*":
            return new Multiplication();
            default:
                throw new OperationException("Opérateur non supporté: " + op);
        }
    }
}
