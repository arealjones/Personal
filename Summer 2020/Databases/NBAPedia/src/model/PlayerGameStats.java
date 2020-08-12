package model;

public class PlayerGameStats {
    private int playerGameStatId;
    private int FG;
    private int FGA;
    private double FGP;
    private int FG3;
    private int FG3A;
    private double FG3P;
    private int FT;
    private int FTA;
    private double FTP;
    private int ORB;
    private int DRB;
    private int TRB;
    private int AST;
    private int STL;
    private int TOV;
    private int PTS;
    private int PF;
    private int BLK;
    private Games game;
    private PlayerSeasons playerSeason;

    public PlayerGameStats(int playerGameStatId, int FG, int FGA, double FGP, int FG3, int FG3A, double FG3P, int FT, int FTA, double FTP, int ORB, int DRB, int TRB, int AST, int STL, int TOV, int PTS, int PF, int BLK, Games game, PlayerSeasons playerSeason) {
        this.playerGameStatId = playerGameStatId;
        this.FG = FG;
        this.FGA = FGA;
        this.FGP = FGP;
        this.FG3 = FG3;
        this.FG3A = FG3A;
        this.FG3P = FG3P;
        this.FT = FT;
        this.FTA = FTA;
        this.FTP = FTP;
        this.ORB = ORB;
        this.DRB = DRB;
        this.TRB = TRB;
        this.AST = AST;
        this.STL = STL;
        this.TOV = TOV;
        this.PTS = PTS;
        this.PF = PF;
        this.BLK = BLK;
        this.game = game;
        this.playerSeason = playerSeason;
    }

    public PlayerGameStats() {
    }

    public PlayerGameStats(int playerGameStatId, int FG, int FGA, double FGP, int FG3, int FG3A) {
        this.playerGameStatId = playerGameStatId;
        this.FG = FG;
        this.FGA = FGA;
        this.FGP = FGP;
        this.FG3 = FG3;
        this.FG3A = FG3A;
    }

    public int getPlayerGameStatId() {
        return playerGameStatId;
    }

    public void setPlayerGameStatId(int playerGameStatId) {
        this.playerGameStatId = playerGameStatId;
    }

    public int getFG() {
        return FG;
    }

    public void setFG(int FG) {
        this.FG = FG;
    }

    public int getFGA() {
        return FGA;
    }

    public void setFGA(int FGA) {
        this.FGA = FGA;
    }

    public double getFGP() {
        return FGP;
    }

    public void setFGP(double FGP) {
        this.FGP = FGP;
    }

    public int getFG3() {
        return FG3;
    }

    public void setFG3(int FG3) {
        this.FG3 = FG3;
    }

    public int getFG3A() {
        return FG3A;
    }

    public void setFG3A(int FG3A) {
        this.FG3A = FG3A;
    }

    public double getFG3P() {
        return FG3P;
    }

    public void setFG3P(double FG3P) {
        this.FG3P = FG3P;
    }

    public int getFT() {
        return FT;
    }

    public void setFT(int FT) {
        this.FT = FT;
    }

    public int getFTA() {
        return FTA;
    }

    public void setFTA(int FTA) {
        this.FTA = FTA;
    }

    public double getFTP() {
        return FTP;
    }

    public void setFTP(double FTP) {
        this.FTP = FTP;
    }

    public int getORB() {
        return ORB;
    }

    public void setORB(int ORB) {
        this.ORB = ORB;
    }

    public int getDRB() {
        return DRB;
    }

    public void setDRB(int DRB) {
        this.DRB = DRB;
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

    public int getTOV() {
        return TOV;
    }

    public void setTOV(int TOV) {
        this.TOV = TOV;
    }

    public int getPTS() {
        return PTS;
    }

    public void setPTS(int PTS) {
        this.PTS = PTS;
    }

    public int getPF() {
        return PF;
    }

    public void setPF(int PF) {
        this.PF = PF;
    }

    public int getBLK() {
        return BLK;
    }

    public void setBLK(int BLK) {
        this.BLK = BLK;
    }

    public Games getGame() {
        return game;
    }

    public void setGame(Games game) {
        this.game = game;
    }

    public PlayerSeasons getPlayerSeason() {
        return playerSeason;
    }

    public void setPlayerSeason(PlayerSeasons playerSeason) {
        this.playerSeason = playerSeason;
    }
}
