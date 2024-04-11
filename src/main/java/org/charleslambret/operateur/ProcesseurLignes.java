package org.charleslambret.operateur;

import java.io.BufferedWriter;
import java.io.IOException;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;

public class ProcesseurLignes {

    public static void processLine(String line, BufferedWriter writer) {
        try {
            if (StringUtils.isBlank(line)) {
                throw new OperationException("Format invalide");
            }
            String[] parts = StringUtils.split(line, " ");
            if (parts.length != 3) {
                throw new OperationException("Format invalide");
            }
            double num1 = Double.parseDouble(parts[0]);
            double num2 = Double.parseDouble(parts[1]);
            String op = parts[2];
            OperationStrategy strategy = OperationFactory.getOperation(op);
            double result = strategy.execute(num1, num2);
            writer.write(StringUtils.join(result, "\n"));
        } catch (Exception e) {
            try {
                writer.write("ERROR\n");
                System.err.println(ExceptionUtils.getStackTrace(e));
            } catch (IOException ioException) {
                System.err.println("Erreur d'écriture dans le fichier: " + ExceptionUtils.getStackTrace(ioException));
            }
        }
    }
}
