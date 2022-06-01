public class Bishop extends ChessPiece {
    public Bishop(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (coordinatesIsTrue(line, column, toLine, toColumn) && pieceExists(chessBoard, line, column)) {
            if (line != toLine && column != toColumn && (chessBoard.board[toLine][toColumn] == null) ||
                    !chessBoard.board[toLine][toColumn].color.equals(this.color)) {
                if (Math.abs(toLine - line) == Math.abs(toColumn - column)) {

                    int lineDir;
                    int columnDir;

                    if (line < toLine) {
                        lineDir = 1;
                    } else {
                        lineDir = -1;
                    }

                    if (column < toColumn) {
                        columnDir = 1;
                    } else {
                        columnDir = -1;
                    }

                    int y = column + columnDir;
                    for (int x = line + lineDir; x != toLine; x += lineDir) {

                        if (chessBoard.board[x][y] != null) {
                            return false;
                        }
                        y += columnDir;
                    }

                    return true;
                }
            }
        } else return false;
        return false;
    }

    @Override
    public String getSymbol() {
        return "Bish ";
    }
}
