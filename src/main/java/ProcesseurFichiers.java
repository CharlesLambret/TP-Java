package src.main.java;
import java.nio.file.*;
import java.io.*;
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
}
