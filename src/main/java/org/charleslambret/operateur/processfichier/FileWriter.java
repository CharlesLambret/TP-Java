package org.charleslambret.operateur.processfichier;

import java.nio.file.*;
import java.io.*;
import java.util.List;

public interface FileWriter {
    void write(Path filePath, List<String> content) throws IOException;
}
