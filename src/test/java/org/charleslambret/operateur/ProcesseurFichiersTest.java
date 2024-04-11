package org.charleslambret.operateur;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import java.nio.file.Path;
import java.nio.file.Files;
import java.io.IOException;
import java.util.List;

class ProcesseurFichiersTest {

    @Test
    void processDirectory(@TempDir Path tempDir) throws IOException {
        Path inputFile = tempDir.resolve("test.op");
        Files.writeString(inputFile, "2 3 +\n");

        ProcesseurFichiers.processDirectory(tempDir.toString());

        Path outputFile = tempDir.resolve("test.res");
        List<String> lines = Files.readAllLines(outputFile);
        assert lines.get(0).equals("5.0");
    }
}
