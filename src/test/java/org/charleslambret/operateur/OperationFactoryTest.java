package org.charleslambret.operateur;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OperationFactoryTest {

    @Test
    public void testGetOperation() {
        try {
            OperationStrategy addition = OperationFactory.getOperation("+");
            Assertions.assertNotNull(addition);
            Assertions.assertEquals(30.0, addition.execute(10.0, 20.0), 0.001);
            
            OperationStrategy soustraction = OperationFactory.getOperation("-");
            Assertions.assertNotNull(soustraction);
            Assertions.assertEquals(-10.0, soustraction.execute(10.0, 20.0), 0.001);
            
            OperationStrategy multiplication = OperationFactory.getOperation("*");
            Assertions.assertNotNull(multiplication);
            Assertions.assertEquals(200.0, multiplication.execute(10.0, 20.0), 0.001);
            
            OperationFactory.getOperation("/"); // L'opérateur division n'est pas supporté
            Assertions.fail("Devrait lancer une OperationException");
        } catch (OperationException e) {
            Assertions.assertEquals("Opérateur non supporté: /", e.getMessage());
        }
    }
}
