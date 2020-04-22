package MVC.tictactoe.view;

/**
 * Draws a 3 x 3 board for a tic-tac-toe game
 */
public class Board {
    public static final int SIZE = 3;


    /**
     * Creates a string representation of a board. Row & column indices are drawn to make it easier for the human to ID
     * which square they want place their piece in.
     * @param squares A 2D array representing the board status. The first index is the row and the second index is the
     *                column. Each entry represents a square on the board. To align properly, the value of a square should
     *                be a single character, either a space (empty square), an X, or an O.
     * @return A String representation of the board.
     *
     */
    public static String createBoard(String[][] squares) {
        StringBuilder sb = new StringBuilder();
        sb.append("    0   1   2 ").append(System.lineSeparator());
        sb.append("  -------------").append(System.lineSeparator());
        for (int r = 0; r < SIZE; r++) {
            sb.append(r).append(" |");
            for (int c = 0; c < SIZE; c++) {
                sb.append(" ").append(squares[r][c]).append(" |");
            }
            sb.append(System.lineSeparator());
        }
        sb.append("  -------------").append(System.lineSeparator());
        return sb.toString();
    }
}
