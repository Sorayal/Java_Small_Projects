package tictactoegame;

import java.util.Scanner;

public class Turn {

  private static final Scanner scanner = new Scanner(System.in);
  private static Turn _turn = null;

  private Turn() {
  }

  public static Turn getInstance() {
    if (_turn == null) {
      _turn = new Turn();
    }
    return _turn;
  }

  public static void makeTurn(String[] gameBoard, int turn, Player player) {

    boolean hasNoInputError = false;

    while (!hasNoInputError) {
      if (turn < 0 || turn >= gameBoard.length) {
        System.out.println("Invalid turn. Make a valid turn: ");
        turn = makeNewTurn();
      } else if (ConditionCheck.checkFreeField(gameBoard, turn)) {
        gameBoard[turn] = player.getSymbol();
        hasNoInputError = true;
      } else {
        System.out.println("Field blocked. Make a new turn: ");
        turn = makeNewTurn();
      }
    }
  }

  private static int makeNewTurn() {
    Scanner scanner = getScanner();
    try {
      return (scanner.nextInt());
    } catch (Exception e) {
      e.printStackTrace();
      return -1;
    }
  }

  private static Scanner getScanner() {
    return scanner;
  }
}
