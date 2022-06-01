public class Queen extends ChessPiece {
    public Queen(String color) {
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
        } else if (coordinatesIsTrue(line, column, toLine, toColumn) && pieceExists(chessBoard, line, column)) {
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
        return "Queen ";
    }
}
