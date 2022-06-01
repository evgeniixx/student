public class Horse extends ChessPiece {
    public Horse(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (coordinatesIsTrue(line, column, toLine, toColumn) &&  pieceExists(chessBoard, line, column)) {
            if (line != toLine && column != toColumn && (chessBoard.board[toLine][toColumn] == null) ||
                    !chessBoard.board[toLine][toColumn].color.equals(this.color)) {


                int[][] positions = new int[][]{
                        {line - 2, column - 1}, {line - 2, column + 1},
                        {line + 2, column - 1}, {line + 2, column + 1},
                        {line - 1, column - 2}, {line - 1, column + 2},
                        {line + 1, column - 2}, {line + 1, column + 2}};

                for (int[] position : positions) {
                    if (position[0] == toLine && position[1] == toColumn)
                        return true;
                }
            }

        } else return false;
        return false;
    }


    @Override
    public String getSymbol() {
        return "Horse ";
    }

}