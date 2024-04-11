package org.charleslambret.operateur;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class OperationFactoryTest {

    @Test
    void getOperationAddition() throws OperationException {
        Assertions.assertDoesNotThrow(() -> {
            OperationStrategy addition = OperationFactory.getOperation("+");
            Assertions.assertEquals(5.0, addition.execute(2, 3));
        });
    }

    @Test
    void getOperationSubtraction() throws OperationException {
        Assertions.assertDoesNotThrow(() -> {
            OperationStrategy subtraction = OperationFactory.getOperation("-");
            Assertions.assertEquals(-1.0, subtraction.execute(2, 3));
        });
    }

    @Test
    void getOperationMultiplication() throws OperationException {
        Assertions.assertDoesNotThrow(() -> {
            OperationStrategy multiplication = OperationFactory.getOperation("*");
            Assertions.assertEquals(6.0, multiplication.execute(2, 3));
        });
    }

    @Test
    void getOperationUnsupported() {
        Assertions.assertThrows(OperationException.class, () -> {
            OperationFactory.getOperation("/");
        });
    }
}
