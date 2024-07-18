package classes.Position;

public class Position {
    private Integer index;
    private Integer line;
    private Integer column;
    private String fileName;
    private String fileTxt;

    public Position(Integer index, Integer line, Integer column, String fileName, String fileTxt) {
        this.index = index;
        this.line = line;
        this.column = column;
        this.fileName = fileName;
        this.fileTxt = fileTxt;
    }

    public Position advance(Character currentChar) {
        index++;
        column++;

        if(currentChar == null) {
            return this;
        }

        if (currentChar == '\n'){
            line++;
            column = 0;
            index = 0;
        }

        return this;
    }

    public Position copy() {
        return new Position(index, line, column, fileName, fileTxt);
    }

    public Integer getIndex() {
        return index;
    }

    public String getFileName() {
        return fileName;
    }
    public Integer getLine() {
        return line;
    }
}
