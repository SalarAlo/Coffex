package classes.Errors.IllegalCharacterError;

import classes.Errors.Error.Error;
import classes.Position.Position;

public class IllegalCharacterError extends Error {

    public IllegalCharacterError(Position startPos, Position endPos, String errorDetails) {
        super(startPos, endPos, "ILLEGAL CHARACTER", errorDetails);
    }
    
}
