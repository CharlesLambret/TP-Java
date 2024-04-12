package org.charleslambret.operateur;

import java.nio.file.*;
import java.io.*;
import java.util.List;
import java.util.stream.Stream;

public class ProcesseurFichiers {

    public static void processDirectory(String dirPath) {
        Path path = Paths.get(dirPath);
        try (Stream<Path> paths = Files.walk(path)) {
            paths.filter(p -> p.toString().endsWith(".op"))
                 .forEach(ProcesseurFichiers::processFile);
        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture du dossier: " + e.getMessage());
        }
    }

    private static void processFile(Path filePath) {
        Path resPath = Paths.get(filePath.toString().replace(".op", ".res"));
        try (BufferedReader reader = Files.newBufferedReader(filePath);
             BufferedWriter writer = Files.newBufferedWriter(resPath, StandardOpenOption.CREATE)) {
            reader.lines().forEach(line -> ProcesseurLignes.processLine(line, writer));
        } catch (IOException e) {
            System.out.println("Erreur lors du traitement du fichier : " + filePath.getFileName());
        }
    }

    public static void processOperations(List<OperationData> operations, String directory) throws IOException {
        for (OperationData opData : operations) {
            if ("OP".equals(opData.getType())) {
                String outputFileName = opData.getFileName() + ".res"; 
                Path outputPath = Paths.get(directory, outputFileName);
                try (BufferedWriter writer = Files.newBufferedWriter(outputPath, StandardOpenOption.CREATE)) {
                    String expression = String.format("%.2f %s %.2f", opData.getParam1(), opData.getOperator(), opData.getParam2());
                    try {
                        OperationStrategy strategy = OperationFactory.getOperation(opData.getOperator());
                        double result = strategy.execute(opData.getParam1(), opData.getParam2());
                        writer.write(expression + " = " + String.format("%.2f", result) + "\n");
                    } catch (OperationException e) {
                        writer.write(expression + " = ERROR\n");
                    }
                }
            }
        }
    }
}
