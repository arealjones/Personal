package MVC.tictactoe.controller;

import MVC.tictactoe.model.GameState;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Player {
    private String character;
    private List<String> errorLog;
    private GameState state;

    public Player(String character, GameState state) {
        this.state = state;
        this.character = character;
        this.errorLog = new ArrayList<>();
    }

    public String getCharacter() {
        return this.character;
    }

    private boolean isValidInput(String turn) {
        final Pattern COORD = Pattern.compile("[012] [012]");
        return COORD.matcher(turn).matches();
    }

    public boolean makeMove(String turn) {
        if (!this.isValidInput(turn)) {
            this.errorLog.add("Invalid input! Enter your move in the format: row col. row and col must be 0, 1, or 2");
            return false;
        }
        int row = Integer.parseInt(turn.substring(0,1));
        int col = Integer.parseInt(turn.substring(2));
        if (!this.state.isSquareOpen(row, col)) {
            this.errorLog.add("Square is taken. Try again.");
            return false;
        }
        this.state.updateBoard(row, col, this.character);
        return true;
    }

    public String getLastError() {
        if (this.errorLog.size() == 0)
            return "No errors";
        return this.errorLog.get(this.errorLog.size() - 1);
    }


}
