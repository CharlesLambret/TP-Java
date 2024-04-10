import java.io.*;
import java.nio.file.*;
import java.util.stream.Stream;

class FormatException extends Exception {
    public FormatException(String message) {
        super(message);
    }
}

public class OperateurFichier {

    public static void main(String[] args) {
        Path dirPath = Paths.get(args.length == 1 ? args[0] : System.getProperty("user.dir"));
        try (Stream<Path> paths = Files.walk(dirPath)) {
            paths.filter(path -> path.toString().endsWith(".op"))
                 .forEach(OperateurFichier::traiterFichier);
        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture du dossier.");
        }
    }

    private static void traiterFichier(Path filePath) {
        Path resPath = Paths.get(filePath.toString().replace(".op", ".res"));
        try (BufferedReader reader = Files.newBufferedReader(filePath);
             BufferedWriter writer = Files.newBufferedWriter(resPath, StandardOpenOption.CREATE)) {
                
                reader.lines().forEach(line -> {
                    try {
                        writer.write(traiterLigne(line) + "\n");
                    } catch (Exception e) {
                        try {
                            writer.write("ERROR\n");
                        } catch (IOException ioException) {
                            System.out.println("Erreur d'écriture dans le fichier: " + ioException.getMessage());
                        }
                    }
                });

            }   catch (IOException e) {
                System.out.println("Erreur lors du traitement du fichier : " + filePath.getFileName());
                }
            }

    private static String traiterLigne(String line) throws FormatException {
        String[] parts = line.split(" ");
        if (parts.length != 3) {
            throw new FormatException("Format invalide");
        }
        try {
            double num1 = Double.parseDouble(parts[0]);
            double num2 = Double.parseDouble(parts[1]);
            String op = parts[2];
            switch (op) {
                case "+":
                    return String.valueOf(num1 + num2);
                case "-":
                    return String.valueOf(num1 - num2);
                case "*":
                    return String.valueOf(num1 * num2);
                default:
                    throw new FormatException("Opérateur non supporté");
            }
        } catch (NumberFormatException e) {
            throw new FormatException("Erreur de format numérique");
        }
    }
}
