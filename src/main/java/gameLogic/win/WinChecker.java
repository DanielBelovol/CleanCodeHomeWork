package gameLogic.win;

public class WinChecker {
    public boolean checkWin(char symbol,char[] gameBoard) {
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
}
