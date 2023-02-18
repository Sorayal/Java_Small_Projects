package tictactoegame;

public class Player {

  private String _name = "";
  private String _symbol = "";

  public Player(String name) {
    this._name = name;
    this._symbol = name.substring(0, 1);
  }

  public String getName() {
    return this._name;
  }

  public String getSymbol() {
    return this._symbol;
  }
}
