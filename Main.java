public class Main {
    public static void main(String[] args) {
        String dirPath = args.length == 1 ? args[0] : System.getProperty("user.dir");
        ProcesseurFichiers.processDirectory(dirPath);
    }
}
