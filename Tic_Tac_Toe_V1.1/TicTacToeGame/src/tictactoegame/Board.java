package tictactoegame;

public class Board {

  private static Board _board = null;

  private Board() {
  }

  public static Board getInstance() {
    if (_board == null) {
      _board = new Board();
    }
    return _board;
  }

  public static void drawBoard(String[] gameBoard, int round) {
    System.out.println(round + ". Round");
    System.out.println(gameBoard[0] + " | " + gameBoard[1] + " | " + gameBoard[2]);
    System.out.println("---------");
    System.out.println(gameBoard[3] + " | " + gameBoard[4] + " | " + gameBoard[5]);
    System.out.println("---------");
    System.out.println(gameBoard[6] + " | " + gameBoard[7] + " | " + gameBoard[8]);
  }
}
