public abstract class ChessPiece {
    String color;
    boolean check = true;

    public ChessPiece(String color) {
        this.color = color;
    }

    public abstract String getColor();
    public abstract boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn);
    public abstract String getSymbol();


    protected boolean checkPiecePos(int pos) {
        return pos >= 0 && pos <= 7;
    }

    protected boolean coordinatesIsTrue(int line, int column, int toLine, int toColumn) {
        return checkPiecePos(line) && checkPiecePos(toLine) && checkPiecePos(column) && checkPiecePos(toColumn);
    }

    protected boolean pieceExists(ChessBoard chessBoard, int line, int column) {
        return chessBoard.board[line][column] != null && chessBoard.board[line][column].equals(this);
    }
}