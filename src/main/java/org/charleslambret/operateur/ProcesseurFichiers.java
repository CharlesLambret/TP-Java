package org.charleslambret.operateur;

import org.charleslambret.operateur.processfichier.FileReader;
import org.charleslambret.operateur.processfichier.FileWriter;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


public class ProcesseurFichiers {

    private FileReader fileReader;
    private FileWriter fileWriter;

    public ProcesseurFichiers(FileReader fileReader, FileWriter fileWriter) {
        this.fileReader = fileReader;
        this.fileWriter = fileWriter;
    }

    public void processFile(Path filePath) throws IOException {
        List<String> lines = fileReader.read(filePath);
        List<String> results = processLines(lines);
        fileWriter.write(filePath.resolveSibling(filePath.getFileName().toString().replace(".op", ".res")), results);
    }

    private List<String> processLines(List<String> lines) {
        return new ArrayList<>(); 
    }
}