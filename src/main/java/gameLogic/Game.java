package gameLogic;

import gameLogic.move.Move;
import gameLogic.win.PrintWinnerText;
import gameLogic.win.WinChecker;
import Print.PrintClass;

import java.util.Scanner;

public class Game {
    Move move = new Move();
    PrintClass printClass = new PrintClass();
    PrintWinnerText printWinnerText = new PrintWinnerText();
    WinChecker winChecker = new WinChecker();


    public byte winnerStatus = 0;
    char[] gameBoard = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
    public boolean isBoxEmpty = false;

    public Game(byte winnerStatus,char[] gameBoard,boolean isBoxEmpty){
        this.winnerStatus = winnerStatus;
        this.gameBoard = gameBoard;
        this.isBoxEmpty = isBoxEmpty;
    }

    public void startGame() {
        Scanner scan = new Scanner(System.in);

        printClass.print("Enter box number to select. Enjoy!\n");

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
        printClass.print("\n\n " + gameBoard[0] + " | " + gameBoard[1] + " | " + gameBoard[2] + " ");
        printClass.print("-----------");
        printClass.print(" " + gameBoard[3] + " | " + gameBoard[4] + " | " + gameBoard[5] + " ");
        printClass.print("-----------");
        printClass.print(" " + gameBoard[6] + " | " + gameBoard[7] + " | " + gameBoard[8] + " \n");
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
