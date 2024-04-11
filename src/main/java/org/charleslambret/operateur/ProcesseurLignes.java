package org.charleslambret.operateur;

import java.io.BufferedWriter;
import java.io.IOException;

public class ProcesseurLignes {

    public static void processLine(String line, BufferedWriter writer) {
        try {
            String[] parts = line.split(" ");
            if (parts.length != 3) {
                throw new OperationException("Format invalide");
            }
            double num1 = Double.parseDouble(parts[0]);
            double num2 = Double.parseDouble(parts[1]);
            String op = parts[2];
            OperationStrategy strategy = OperationFactory.getOperation(op);
            double result = strategy.execute(num1, num2);
            writer.write(String.valueOf(result) + "\n");
        } catch (Exception e) {
            try {
                writer.write("ERROR\n");
            } catch (IOException ioException) {
                System.out.println("Erreur d'écriture dans le fichier: " + ioException.getMessage());
            }
        }
    }
}
