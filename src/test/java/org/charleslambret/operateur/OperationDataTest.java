package org.charleslambret.operateur;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OperationDataTest {

    @Test
    public void testGetters() {
        OperationData operationData = new OperationData("file", 10.0, 20.0, "+", "type");
        Assertions.assertEquals("type", operationData.getType());
        Assertions.assertEquals("file", operationData.getFileName());
        Assertions.assertEquals(10.0, operationData.getParam1(), 0.001);
        Assertions.assertEquals(20.0, operationData.getParam2(), 0.001);
        Assertions.assertEquals("+", operationData.getOperator());
    }
}
