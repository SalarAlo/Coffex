package classes.LexerTokenResult;
import classes.Errors.Error.Error;
import classes.Token.Token;

import java.util.*;

public class LexerTokenResult {
    private Error err;
    private List<Token> tokens = new ArrayList<Token>();

    public LexerTokenResult(List<Token> tokens, Error err) {
        this.tokens = tokens;
        this.err = err;
    }

    public List<Token> getTokens() { return tokens; }
    
    public Error getError() { return err; }
}
