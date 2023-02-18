package tictactoe;

import java.util.Scanner;

public class Player {
    int number;
    Scanner scanner = new Scanner(System.in);  
    
    public Player(int number){
       this.number = number; 
    }
    
    public int getTurn(){
        System.out.println("Your turn, Player " + number);
        int input = scanner.nextInt();
        if(input >= 0 && input < 9){
            return input;
        }
        System.out.println("Invalid input");
        return getTurn();
    }
    
    public boolean validateTurn(int[]board, int turnField){
        return board[turnField] == -1;
    }
}
