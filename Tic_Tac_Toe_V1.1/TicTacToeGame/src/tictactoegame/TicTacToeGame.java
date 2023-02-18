package tictactoegame;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class TicTacToeGame {

  public static void main(String[] args) {
    String[] gameBoard = new String[9];
    Arrays.fill(gameBoard, " ");

    Player[] players = new Player[2];
    Scanner scanner = new Scanner(System.in);
    for (int i = 0; i < 2; i++) {
      System.out.println(i + 1 + ". Player, enter your name: ");
      players[i] = new Player(scanner.next());
    }

    int round = 1;
    int i = 0;
    int turn = 0;
    String winner = "";

    while (Objects.equals(winner, "")) {
      Board.drawBoard(gameBoard, round);
      try {
        System.out.printf("Make a turn, %s : ", players[i].getName());
        turn = scanner.nextInt();
        Turn.makeTurn(gameBoard, turn, players[i]);
      } catch (Exception e) {
        System.out.println(e.getMessage());
        scanner.nextLine();
        continue;
      }

      if (ConditionCheck.checkWin(gameBoard)) {
        winner = players[i].getName();
      }
      i = (i + 1) % 2;
      round++;
    }
    scanner.close();
    Board.drawBoard(gameBoard, round - 1);
    System.out.println("Winner is: " + winner);
  }
}
