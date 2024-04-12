package org.charleslambret.operateur.processfichier;

import java.nio.file.*;
import java.io.*;
import java.util.List;

public interface FileReader {
    List<String> read(Path filePath) throws IOException;
}

