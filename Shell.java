import java.io.*;

public class Shell {
    public static void main(String[] args) {
        try {
            if (args.length > 1) {
                System.out.println("Usage: Coffex [script]");
                System.exit(64);
            } else if (args.length == 1) {
                runFile(args[0]);
            } else {
                runPrompt();
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    private static void runFile(String path) throws IOException {
        String fileContent = getFileContent(path);
        System.out.println(fileContent);
        run(fileContent);
    }

    private static String getFileContent(String path) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(path);
        InputStreamReader input = new InputStreamReader(fileInputStream);
        BufferedReader fileReader = new BufferedReader(input);

        StringBuilder stringBuilder = new StringBuilder();
        String currentLine = fileReader.readLine();
        while (currentLine != null) {
            stringBuilder.append(currentLine).append("\n");
            currentLine = fileReader.readLine();
        }
        return stringBuilder.toString();
    }

    private static void runPrompt() throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input);

        for (;;) {
            System.out.print("Coffex > ");
            String line = reader.readLine();
            if (line == null) break;
            run(line);
        }
    }

    private static void run(String source) {
        // Scanner scanner = new Scanner(source);
        // List<Token> tokens = scanner.scanTokens();

        // // For now, just print the tokens.
        // for (Token token : tokens) {
        //     System.out.println(token);
        // }
    }
}
