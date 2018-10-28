package genre;

public enum Genre implements GenreInterface{
  ACTION(3), CHILREN(2), HORROR(4), NERD(1), ROMANCE(5);

  private int numVal;

  Genre(int numVal) {
    this.numVal = numVal;
  }

  public int getNumVal() {
    return numVal;
  }
}
