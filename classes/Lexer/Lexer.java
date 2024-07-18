package classes.Lexer;

import java.util.*;

import Enum.TokenType;
import classes.Errors.IllegalCharacterError.IllegalCharacterError;
import classes.LexerTokenResult.LexerTokenResult;
import classes.Position.Position;
import classes.Token.Token;

public class Lexer {
    private String text;
    private Character currentChar;
    private Position pos;

    public Lexer(String text, String fileName) {
        pos = new Position(-1, 1, -1, fileName, text);
        currentChar = null;
        this.text = text;
        advance();
    }

    public void advance() {
        pos.advance(currentChar);
        currentChar = pos.getIndex() < text.length() ? text.charAt(pos.getIndex()) : null;
    }

    public LexerTokenResult createTokens() {
        List<Token> tokens = new ArrayList<Token>();

        while (currentChar != null) {
            if(Character.isWhitespace(currentChar)){
                advance();
                continue;
            } else if (Character.isDigit(currentChar)) {
                tokens.add(makeNumber());
            } else if (currentChar == '+') {
                tokens.add(new Token(TokenType.PLUS));
                advance();
            } else if (currentChar == '*') {
                tokens.add(new Token(TokenType.MULTIPLY));
                advance();
            } else if (currentChar == '/') {
                tokens.add(new Token(TokenType.DIVIDE));
                advance();
            } else if (currentChar == '-') {
                tokens.add(new Token(TokenType.MINUS));
                advance();
            } else if (currentChar == '(') {
                tokens.add(new Token(TokenType.LEFT_PARANTHESIS));
                advance();
            } else if (currentChar == ')') {
                tokens.add(new Token(TokenType.RIGHT_PARENTHESIS));
                advance();
            } else {
                // Default case, nothing to do
                var character = Character.valueOf(currentChar);
                var posStart = pos.copy();
                advance();
                return new LexerTokenResult(
                    new ArrayList<Token>(), 
                    new IllegalCharacterError(posStart, pos, "'"+character+"'")
                ); 
            }            
        }

        return new LexerTokenResult(tokens, null);
    }

    private Token makeNumber() {
        String numStr = "";
        Integer dotCount = 0;

        while (currentChar != null && (Character.isDigit(currentChar) || currentChar == '.')) {
            if (currentChar == '.') {
                if(dotCount == 1) break;
                dotCount++;
                numStr += currentChar;
            }
            else {
                numStr += currentChar;
            }

            advance();
        }

        return dotCount == 1 ? new Token(TokenType.FLOAT, numStr) : new Token(TokenType.INT, numStr);
    }
}