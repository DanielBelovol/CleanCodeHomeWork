package GameLogic;

import java.util.Scanner;

public class Game {
    PrintClass printInfoClass = new PrintClass();
    boolean boxAvailable = false;
    byte winner = 0;
    char[] board = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
    boolean boxEmpty = false;
    byte input;
    public void startGame() {
        Scanner scan = new Scanner(System.in);

        printInfoClass.print("Enter box number to select. Enjoy!\n");

        while (true) {
            drawStartBoard();
            writeWinnerText();
            playerMove(scan);
            if (checkWin('X')) {
                winner = 1;
                continue; // Возврат из метода после выигрыша игрока.
            }
            if (isBoardAvailable()) {
                computerMove();
                drawStartBoard();
                if (checkWin('O')) {
                    winner = 2;
                    return; // Возврат из метода после выигрыша компьютера.
                }
            }
        }
    }
    public void drawStartBoard() {
        printInfoClass.print("\n\n " + board[0] + " | " + board[1] + " | " + board[2] + " ");
        printInfoClass.print("-----------");
        printInfoClass.print(" " + board[3] + " | " + board[4] + " | " + board[5] + " ");
        printInfoClass.print("-----------");
        printInfoClass.print(" " + board[6] + " | " + board[7] + " | " + board[8] + " \n");
        if (!boxEmpty) {
            for (int i = 0; i < 9; i++)
                board[i] = ' ';
            boxEmpty = true;
        }
    }//Метод рисует в консоли нашу доску

    public boolean writeWinnerText() {
        if (winner == 1) {
            printInfoClass.print("You won the game!");
            return true;
        } else if (winner == 2) {
            printInfoClass.print("You lost the game!");
            return true;
        } else if (winner == 3) {
            printInfoClass.print("It's a draw!");
            return true;
        }
        return false;
    }//Метод пишет выиграшный текст в зависимости от того кто выиграл

    public void playerMove(Scanner scan) {
        while (true) {
            input = scan.nextByte();
            if (input > 0 && input < 10) {
                if (board[input - 1] == 'X' || board[input - 1] == 'O') {
                    printInfoClass.print("That box is already in use. Enter another.");
                } else {
                    board[input - 1] = 'X';
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
            if (board[randomNumber - 1] != 'X' && board[randomNumber - 1] != 'O') {
                board[randomNumber - 1] = 'O';
                break;
            }
        }

    }//Пк рандомно делает ход

    public boolean checkWin(char symbol) {
        // Проверка горизонтальных и вертикальных линий
        for (int i = 0; i < 3; i++) {
            if ((board[i] == symbol && board[i + 3] == symbol && board[i + 6] == symbol) ||
                    (board[3 * i] == symbol && board[3 * i + 1] == symbol && board[3 * i + 2] == symbol)) {
                return true;
            }
        }

        // Проверка диагоналей
        return (board[0] == symbol && board[4] == symbol && board[8] == symbol) ||
                (board[2] == symbol && board[4] == symbol && board[6] == symbol);
    }//Проверяет выиграл ли символ который мы передали

    public boolean isBoardAvailable() {
        for (int i = 0; i < 9; i++) {
            if (board[i] != 'X' && board[i] != 'O') {
                return true; // Если хоть одна доступная ячейка найдена, вернуть true.
            }
        }

        // Если дошли сюда, значит, все ячейки заполнены.
        winner = 3; // Устанавливаем ничью.
        return false;
    }//если все поля заполнены то у нас ничья
}


