package GameLogic;

import java.util.Scanner;

public class Game {
    PrintClass printInfoClass = new PrintClass();
    byte winnerStatus = 0;
    char[] gameBoard = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
    boolean isBoxEmpty = false;
    public void startGame() {
        Scanner scan = new Scanner(System.in);

        printInfoClass.print("Enter box number to select. Enjoy!\n");

        while (true) {
            drawStartBoard();
            writeWinnerText();
            playerMove(scan);
            if (checkWin('X')) {
                winnerStatus = 1;
                continue; // Возврат из метода после выигрыша игрока.
            }
            if (isBoardAvailable()) {
                computerMove();
                drawStartBoard();
                if (checkWin('O')) {
                    winnerStatus = 2;
                    return; // Возврат из метода после выигрыша компьютера.
                }
            }
        }
    }
    public void drawStartBoard() {
        printInfoClass.print("\n\n " + gameBoard[0] + " | " + gameBoard[1] + " | " + gameBoard[2] + " ");
        printInfoClass.print("-----------");
        printInfoClass.print(" " + gameBoard[3] + " | " + gameBoard[4] + " | " + gameBoard[5] + " ");
        printInfoClass.print("-----------");
        printInfoClass.print(" " + gameBoard[6] + " | " + gameBoard[7] + " | " + gameBoard[8] + " \n");
        if (!isBoxEmpty) {
            for (int i = 0; i < 9; i++)
                gameBoard[i] = ' ';
            isBoxEmpty = true;
        }
    }//Метод рисует в консоли нашу доску

    public void writeWinnerText() {
        if (winnerStatus == 1) {
            printInfoClass.print("You won the game!");
        } else if (winnerStatus == 2) {
            printInfoClass.print("You lost the game!");
        } else if (winnerStatus == 3) {
            printInfoClass.print("It's a draw!");
        }
    }//Метод пишет выиграшный текст в зависимости от того кто выиграл

    public void playerMove(Scanner scan) {
        while (true) {
            byte input = scan.nextByte();
            if (input > 0 && input < 10) {
                if (gameBoard[input - 1] == 'X' || gameBoard[input - 1] == 'O') {
                    printInfoClass.print("That box is already in use. Enter another.");
                } else {
                    gameBoard[input - 1] = 'X';
                    break; // Break out of the loop once a valid move is made.
                }
            } else {
                printInfoClass.print("Invalid input. Enter again.");
            }
        }
    }//Метод принимает ход, проверяет не занято ли поле и ходит

    public void computerMove() {
        byte randomNumber;
        while (true) {
            randomNumber = (byte) (Math.random() * (9 - 1 + 1) + 1);
            if (gameBoard[randomNumber - 1] != 'X' && gameBoard[randomNumber - 1] != 'O') {
                gameBoard[randomNumber - 1] = 'O';
                break;
            }
        }

    }//Пк рандомно делает ход

    public boolean checkWin(char symbol) {
        // Проверка горизонтальных и вертикальных линий
        for (int i = 0; i < 3; i++) {
            if ((gameBoard[i] == symbol && gameBoard[i + 3] == symbol && gameBoard[i + 6] == symbol) ||
                    (gameBoard[3 * i] == symbol && gameBoard[3 * i + 1] == symbol && gameBoard[3 * i + 2] == symbol)) {
                return true;
            }
        }

        // Проверка диагоналей
        return (gameBoard[0] == symbol && gameBoard[4] == symbol && gameBoard[8] == symbol) ||
                (gameBoard[2] == symbol && gameBoard[4] == symbol && gameBoard[6] == symbol);
    }//Проверяет выиграл ли символ который мы передали

    public boolean isBoardAvailable() {
        for (int i = 0; i < 9; i++) {
            if (gameBoard[i] != 'X' && gameBoard[i] != 'O') {
                return true; // Если хоть одна доступная ячейка найдена, вернуть true.
            }
        }

        // Если дошли сюда, значит, все ячейки заполнены.
        winnerStatus = 3; // Устанавливаем ничью.
        return false;
    }//если все поля заполнены то у нас ничья
}