package GameLogic.Move;

import Print.PrintClass;

import java.util.Scanner;

public class UserMove {
    PrintClass printClass = new PrintClass();
    public void playerMove(Scanner scan, char[] gameBoard) {
        while (true) {
            byte input = scan.nextByte();
            if (input > 0 && input < 10) {
                if (gameBoard[input - 1] == 'X' || gameBoard[input - 1] == 'O') {
                    printClass.print("That box is already in use. Enter another.");
                } else {
                    gameBoard[input - 1] = 'X';
                    break; // Break out of the loop once a valid move is made.
                }
            } else {
                printClass.print("Invalid input. Enter again.");
            }
        }
    }//Метод принимает ход, проверяет не занято ли поле и ходит
}
