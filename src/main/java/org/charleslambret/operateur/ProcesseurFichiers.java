package org.charleslambret.operateur;

import java.nio.file.*;
import java.io.*;
import java.util.List;

public class ProcesseurFichiers {

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
