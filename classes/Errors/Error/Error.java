package classes.Errors.Error;

import classes.Position.Position;

public class Error {
    private String errorName;
    private String errorDetails;
    private Position posStart;
    private Position posEnd;

    public Error(Position posStart, Position posEnd, String errorName, String errorDetails) {
        this.posEnd = posEnd;
        this.posStart = posStart;
        this.errorName = errorName;
        this.errorDetails = errorDetails;
    }

    public String errorAsString() {
        return errorName+":"+errorDetails+", FILE="+posStart.getFileName()+", line"+posStart.getLine();
    }
}
