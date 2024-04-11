package org.charleslambret.operateur;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.nio.file.Path;
import java.nio.file.Files;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

class ProcesseurFichiersTest {

    @Test
    void processOperations(@TempDir Path tempDir) throws IOException, OperationException {
        List<OperationData> operations = new ArrayList<>();
        operations.add(new OperationData("test.op", 2, 3, "+"));

        ProcesseurFichiers.processOperations(operations, tempDir.toString());

        Path outputFile = tempDir.resolve("test.res");
        List<String> lines = Files.readAllLines(outputFile);
        assert lines.get(0).equals("5.0");
    }
}
