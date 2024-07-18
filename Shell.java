import java.util.Scanner;

import classes.Lexer.Lexer;
import classes.LexerTokenResult.LexerTokenResult;
import classes.Token.Token;

public class Shell {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("Coffex > ");
                String inputText = scanner.next();
                
                Lexer lexer = new Lexer(inputText, "SHELL");
                LexerTokenResult result = lexer.createTokens();
                
                if(result.getError() != null) {
                    System.out.println(result.getError().errorAsString());
                }
                else {
                    String s = "";
                    for (Token token : result.getTokens()) {
                        s += (token.GetType()) + ", ";
                    }
                    System.out.println(s);
                }
            }
        }
    }
}
