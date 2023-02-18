package tictactoe;

public class TicTacToe {

    public static void main(String[] args) {
        System.out.println("Welcome to Tic Tac Toe\n\n");
        int turnPlayer = 0;
        int winner = -1;
        int [] gameBoard = new int[9];
        
        for (int i = 0; i < gameBoard.length; i++) {
            gameBoard[i] = -1;
        }
        Player firstPlayer = new Player(0);
        Player secondPlayer = new Player(1);
        Player[] players = new Player[2];
        players[0] = firstPlayer;
        players[1] = secondPlayer;
        
        
        while(winner == -1){
            drawBoard(gameBoard);
            int turnField = players[turnPlayer].getTurn();
            if(players[turnPlayer].validateTurn(gameBoard, turnField)){
               gameBoard[turnField] = players[turnPlayer].number; 
               turnPlayer = (turnPlayer + 1) % 2;
            }
            winner = checkForWinner(gameBoard);
        }  
        System.out.println("You won, Player " + winner );
        System.out.println("Ende");
    }
    

    
    public static void drawBoard(int[] board){
        System.out.println(board[0] + " | " + board[1] + " | " + board[2]);
        System.out.println("------------");
        System.out.println(board[3] + " | " + board[4] + " | " + board[5]);
        System.out.println("------------");
        System.out.println(board[6] + " | " + board[7] + " | " + board[8]);
    }
    
    public static int checkForWinner(int[] board){
        int winner;
        if(board[0] == board[1] && board[0] == board[2] && board[0] != -1){
            winner = board[0];
        }
        else if(board[3] == board[4] && board[3] == board[5] && board[3] != -1){
            winner = board[3];
        }
        else if(board[6] == board[7] && board[6] == board[8] && board[6] != -1){
            winner = board[6];
        }
        else if(board[0] == board[3] && board[0] == board[6] && board[0] != -1){
            winner = board[0];
        }
        else if(board[1] == board[4] && board[1] == board[7] && board[1] != -1){
            winner = board[1];
        }
        else if(board[2] == board[5] && board[2] == board[8] && board[2] != -1){
            winner = board[2];
        }
        else if(board[0] == board[4] && board[0] == board[8] && board[0] != -1){
            winner = board[0];
        }
        else if(board[2] == board[4] && board[2] == board[6] && board[2] != -1){
            winner = board[2];
        }
        else{
            winner = -1;
        }
        return winner;
    }
}
