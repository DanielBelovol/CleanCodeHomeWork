package GameLogic.Win;

import Print.PrintClass;

public class PrintWinnerText {
    PrintClass printClass = new PrintClass();
    public void writeWinnerText(byte winnerStatus) {
        if (winnerStatus == 1) {
            printClass.print("You won the game!");
        } else if (winnerStatus == 2) {
            printClass.print("You lost the game!");
        } else if (winnerStatus == 3) {
            printClass.print("It's a draw!");
        }
    }//Метод пишет выиграшный текст в зависимости от того кто выиграл
}
