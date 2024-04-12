package org.charleslambret.operateur.ProcessFichiers;

import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import java.util.List;

public class ImplementationFileWriter implements FileWriter {
    @Override
    public void write(Path filePath, List<String> content) throws IOException {
        Files.write(filePath, content);
    }
}