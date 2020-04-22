package MVC.tictactoe.model;


public class GameState {
    private static final String EMPTY = " ";
    private static final int SIZE = 3;
    private static final int MIDDLE = 1;
    private int playCount;
    private String[][] boardState;
    private Play playStatus;

    public GameState() {
        this.playStatus = Play.X_TURN;
        this.boardState = new String[SIZE][SIZE];
        this.playCount = 0;
        this.populateBoardState();
    }

    private void populateBoardState() {
        for (int r = 0; r < SIZE; r++) {
            for (int c = 0; c < SIZE; c++) {
                this.boardState[r][c] = " ";
            }
        }
    }

    public String[][] getBoardState() {
        return this.boardState;
    }

    public boolean isSquareOpen(int row, int col) {
        return this.boardState[row][col].equals(EMPTY);
    }

    public Play getPlayStatus() {
        return this.playStatus;
    }

    public void updateBoard(int row, int col, String piece) {
        this.boardState[row][col] = piece;
        this.playCount++;
        this.checkAndUpdatePlay(piece);
    }

    private void checkAndUpdatePlay(String piece) {
        if (this.hasLine(piece)) {
            this.setWinner(piece);
        } else if (this.noMoves())
            this.playStatus = Play.NO_WINNER;
        else this.toggleTurn(piece);
    }

    private void setWinner(String piece) {
        if (this.playStatus == Play.X_TURN)
            this.playStatus = Play.X_WINS;
        else this.playStatus = Play.O_WINS;
    }

    private void toggleTurn(String piece) {
        if (this.playStatus == Play.X_TURN)
            this.playStatus = Play.O_TURN;
        else this.playStatus = Play.X_TURN;
    }

    private boolean noMoves() {
        return this.playCount == SIZE * SIZE;
    }

    private boolean hasLine(String piece) {
        int MIN_MOVES_FOR_LINE = 5;
        if (this.playCount < MIN_MOVES_FOR_LINE)
            return false;
        return this.checkMiddleSquare(piece) || this.verticalMatch(piece, MIDDLE-1)
                || this.verticalMatch(piece, MIDDLE+1) || this.horizontalMatch(piece, MIDDLE-1)
                || this.horizontalMatch(piece, MIDDLE+1);
    }

    private boolean checkMiddleSquare(String piece) {
        if (!this.boardState[MIDDLE][MIDDLE].equals(piece))
            return false;
        return this.verticalMatch(piece, MIDDLE) || this.horizontalMatch(piece, MIDDLE) || this.diagonalMatch(piece);
    }

    private boolean verticalMatch(String piece, int col) {
        return this.boardState[MIDDLE - 1][col].equals(piece) && this.boardState[MIDDLE][col].equals(piece)
                && this.boardState[MIDDLE + 1][col].equals(piece);
    }

    private boolean horizontalMatch(String piece, int row) {
        return this.boardState[row][MIDDLE - 1].equals(piece) && this.boardState[row][MIDDLE].equals(piece)
                && this.boardState[row][MIDDLE+1].equals(piece);
    }

    private boolean diagonalMatch(String piece) {
        return this.boardState[MIDDLE-1][MIDDLE-1].equals(piece) && this.boardState[MIDDLE+1][MIDDLE+1].equals(piece)
                || this.boardState[MIDDLE+1][MIDDLE-1].equals(piece) && this.boardState[MIDDLE-1][MIDDLE+1].equals(piece);
    }

}
