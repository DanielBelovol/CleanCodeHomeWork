package gameLogic.move;

import print.PrintClass;

import java.util.Scanner;

public class Move {
    PrintClass printClass = new PrintClass();
    public void computerMove(char[] gameBoard){
        byte randomNumber;
        while (true) {
            randomNumber = (byte) (Math.random() * (9 - 1 + 1) + 1);
            if (gameBoard[randomNumber - 1] != 'X' && gameBoard[randomNumber - 1] != 'O') {
                gameBoard[randomNumber - 1] = 'O';
                break;
            }
        }
    }
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
