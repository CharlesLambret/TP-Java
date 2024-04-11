package org.charleslambret.operateur;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class OperationFactoryTest {

    @Test
    void getOperationSupported() throws OperationException {
        Assertions.assertDoesNotThrow(() -> {
            OperationStrategy addition = OperationFactory.getOperation("+");
            Assertions.assertNotNull(addition);
            Assertions.assertEquals(5.0, addition.execute(2, 3));
        });
    }

    @Test
    void getOperationUnsupported() {
        Assertions.assertThrows(OperationException.class, () -> {
            OperationFactory.getOperation("/");
        });
    }
}
