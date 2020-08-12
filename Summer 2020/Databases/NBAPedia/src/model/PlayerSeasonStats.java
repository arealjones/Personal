package model;

public class PlayerSeasonStats {
  private double FGP;
  private double FG3P;
  private double FTP;
  private int TRB;
  private int AST;
  private int STL;
  private int PTS;
  private int BLK;
  private String season;
  private PlayerSeasons playerSeason;

  public PlayerSeasonStats(double FGP, double FG3P, double FTP, int TRB, int AST, int STL, int PTS,
      int BLK, String season, PlayerSeasons playerSeason) {
    this.FGP = FGP;
    this.FG3P = FG3P;
    this.FTP = FTP;
    this.TRB = TRB;
    this.AST = AST;
    this.STL = STL;
    this.PTS = PTS;
    this.BLK = BLK;
    this.season = season;
    this.playerSeason = playerSeason;
  }

  public double getFGP() {
    return FGP;
  }

  public void setFGP(double FGP) {
    this.FGP = FGP;
  }

  public double getFG3P() {
    return FG3P;
  }

  public void setFG3P(double FG3P) {
    this.FG3P = FG3P;
  }

  public double getFTP() {
    return FTP;
  }

  public void setFTP(double FTP) {
    this.FTP = FTP;
  }

  public int getTRB() {
    return TRB;
  }

  public void setTRB(int TRB) {
    this.TRB = TRB;
  }

  public int getAST() {
    return AST;
  }

  public void setAST(int AST) {
    this.AST = AST;
  }

  public int getSTL() {
    return STL;
  }

  public void setSTL(int STL) {
    this.STL = STL;
  }

  public int getPTS() {
    return PTS;
  }

  public void setPTS(int PTS) {
    this.PTS = PTS;
  }

  public int getBLK() {
    return BLK;
  }

  public void setBLK(int BLK) {
    this.BLK = BLK;
  }

  public String getSeason() {
    return season;
  }

  public void setSeason(String season) {
    this.season = season;
  }

  public PlayerSeasons getPlayerSeason() {
    return playerSeason;
  }

  public void setPlayerSeason(PlayerSeasons playerSeason) {
    this.playerSeason = playerSeason;
  }
}
