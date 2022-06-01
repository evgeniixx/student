public class Rook extends ChessPiece {
    public Rook(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (coordinatesIsTrue(line, column, toLine, toColumn) && pieceExists(chessBoard, line, column)) {
            if ((chessBoard.board[toLine][toColumn] == null || !chessBoard.board[toLine][toColumn].color.equals(this.color))) {
                if (line == toLine && column == toColumn) return false;

                if (line == toLine) {
                    if (column < toColumn) {
                        for (int i = column + 1; i <= toColumn; ++i)
                            if (chessBoard.board[line][i] != null &&
                                    chessBoard.board[line][i].getColor().equals(this.color)) return false;
                    } else {
                        for (int i = column - 1; i >= toColumn; --i)
                            if (chessBoard.board[line][i] != null &&
                                    chessBoard.board[line][i].getColor().equals(this.color)) return false;
                    }
                } else if (column == toColumn) {
                    if (line < toLine) {
                        for (int i = line + 1; i <= toLine; ++i)
                            if (chessBoard.board[i][column] != null &&
                                    chessBoard.board[i][column].getColor().equals(this.color)) return false;
                    } else {
                        for (int i = line - 1; i >= toLine; --i)
                            if (chessBoard.board[i][column] != null &&
                                    chessBoard.board[i][column].getColor().equals(this.color)) return false;
                    }
                } else {
                    return false;
                } return true;
            }
        } else return false;
        return false;
    }

    @Override
    public String getSymbol() {
        return "Rook ";
    }
}
