package MVC.tictactoe.view;

import MVC.tictactoe.controller.Player;
import MVC.tictactoe.model.GameState;
import MVC.tictactoe.model.Play;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GameState state = new GameState();
        Player x = new Player("X", state);
        Player o = new Player("O", state);
        Scanner scanner = new Scanner(System.in);

        System.out.println(Board.createBoard(state.getBoardState()));
        while(state.getPlayStatus() == Play.X_TURN || state.getPlayStatus() == Play.O_TURN) {
            Player currentPlayer;
            if (state.getPlayStatus() == Play.X_TURN) {
                currentPlayer = x;
            }
            else currentPlayer = o;
            System.out.println(currentPlayer.getCharacter() + "'s turn! Enter your move in the format: row col");
            String nextMove = scanner.nextLine();
            while (!currentPlayer.makeMove(nextMove)) {
                System.out.println(currentPlayer.getLastError());
                nextMove = scanner.nextLine();
            }
            System.out.println(Board.createBoard(state.getBoardState()));
        }
        if (state.getPlayStatus() == Play.NO_WINNER)
            System.out.println("Game over. No winner");
        else if (state.getPlayStatus() == Play.X_WINS)
            System.out.println("X wins!");
        else if (state.getPlayStatus() ==  Play.O_WINS)
            System.out.println("O wins!");
    }
}
