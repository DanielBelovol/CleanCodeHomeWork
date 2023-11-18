package GameLogic.Move;

public class ComputerMove {
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
}
