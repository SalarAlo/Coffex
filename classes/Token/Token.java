package classes.Token;
import Enum.TokenType;

public class Token {
    private TokenType type;
    private String value;

    public Token(TokenType type, String numStr) {
        this.value = numStr;
        this.type = type;
    }
    public Token(TokenType type) {
        this.type = type;
    }

    public TokenType GetType() { return type; }
    public String GetValue() { return value; }
}
