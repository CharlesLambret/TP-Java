package org.charleslambret.operateur.ProcessFichiers;

import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import java.util.List;

public class ImplementationFileReader implements FileReader {
    @Override
    public List<String> read(Path filePath) throws IOException {
        return Files.readAllLines(filePath);
    }
}
