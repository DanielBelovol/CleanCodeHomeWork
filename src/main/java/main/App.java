package main;
import gameLogic.Game;

public class App {
    public static void main(String[] args) {
        byte winnerStatus = 0;
        char[] gameBoard = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        boolean isBoxEmpty = false;
        Game game = new Game(winnerStatus,gameBoard,isBoxEmpty);
        game.startGame();
    }
}