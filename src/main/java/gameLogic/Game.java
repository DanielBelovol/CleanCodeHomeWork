package gameLogic;

import gameLogic.move.Move;
import gameLogic.win.PrintWinnerText;
import gameLogic.win.WinChecker;

import java.util.Scanner;

public class Game {
    private Move move = new Move();
    private PrintWinnerText printWinnerText = new PrintWinnerText();
    private WinChecker winChecker = new WinChecker();


    private byte winnerStatus;
    private char[] gameBoard;
    private boolean isBoxEmpty;

    public Game(byte winnerStatus, char[] gameBoard, boolean isBoxEmpty) {
        this.winnerStatus = winnerStatus;
        this.gameBoard = gameBoard;
        this.isBoxEmpty = isBoxEmpty;
    }

    public void startGame() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter box number to select. Enjoy!\n");

        while (true) {
            darwBoard();
            printWinnerText.writeWinnerText(winnerStatus);
            move.playerMove(scan, gameBoard);
            if (winChecker.checkWin('X', gameBoard)) {
                winnerStatus = 1;
                continue; // Возврат из метода после выигрыша игрока.
            }
            if (isBoardAvailable()) {
                move.computerMove(gameBoard);
                darwBoard();
                if (winChecker.checkWin('O', gameBoard)) {
                    winnerStatus = 2;
                }
            }
        }
    }

    public void darwBoard() {//Метод рисует в консоли нашу доску
        System.out.println("\n\n " + gameBoard[0] + " | " + gameBoard[1] + " | " + gameBoard[2] + " ");
        System.out.println("-----------");
        System.out.println(" " + gameBoard[3] + " | " + gameBoard[4] + " | " + gameBoard[5] + " ");
        System.out.println("-----------");
        System.out.println(" " + gameBoard[6] + " | " + gameBoard[7] + " | " + gameBoard[8] + " \n");
        if (!isBoxEmpty) {
            for (int i = 0; i < 9; i++) {
                gameBoard[i] = ' ';
            }
            isBoxEmpty = true;
        }
    }

    public boolean isBoardAvailable() {
        for (int i = 0; i < 9; i++) {
            if (gameBoard[i] != 'X' && gameBoard[i] != 'O') {
                return true; // Если хоть одна пустая ячейка найдена, вернуть true.
            }
        }
        // Если дошли сюда, значит, все ячейки заполнены.
        winnerStatus = 3; // Устанавливаем ничью.
        return false;
    }
}
