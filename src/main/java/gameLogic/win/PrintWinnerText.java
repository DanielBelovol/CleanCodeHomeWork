package gameLogic.win;

public class PrintWinnerText {
    public void writeWinnerText(byte winnerStatus) {
        if (winnerStatus == 1) {
            System.out.println("You won the game!");
        } else if (winnerStatus == 2) {
            System.out.println("You lost the game!");
        } else if (winnerStatus == 3) {
            System.out.println("It's a draw!");
        }
    }//Метод пишет выиграшный текст в зависимости от того кто выиграл
}
