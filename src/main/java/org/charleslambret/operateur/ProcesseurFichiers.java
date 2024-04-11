package org.charleslambret.operateur;

import java.nio.file.*;
import java.io.*;
import java.util.List; 

public class ProcesseurFichiers {

    public static void processOperations(List<OperationData> operations, String directory) throws IOException {
        for (OperationData opData : operations) {
            String outputFileName = opData.getFileName().replace(".op", ".res");
            Path outputPath = Paths.get(directory, outputFileName);

            try (BufferedWriter writer = Files.newBufferedWriter(outputPath, StandardOpenOption.CREATE)) {
                String operation = opData.getParam1() + " " + opData.getOperator() + " " + opData.getParam2();
                try {
                    OperationStrategy strategy = OperationFactory.getOperation(opData.getOperator());
                    double result = strategy.execute(opData.getParam1(), opData.getParam2());
                    writer.write(operation + " = " + result + "\n");
                } catch (OperationException e) {
                    writer.write(operation + " = ERROR\n");  
                }
            }
        }
    }   
}

