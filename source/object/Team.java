package object;

import com.sun.istack.internal.NotNull;

import java.io.Serializable;
import java.util.Collection;

public class Team implements Serializable,Comparable {

	private static final long serialVersionUID = -3942570304764550707L;

    private String name;
    private int points;
    private int matchPlayed;
    private int won;
    private int lost;
    private int tie;
    private int goalF;
    private int goalS;
    private int matchPlayedHome;
    private int wonHome;
    private int lostHome;
    private int tieHome;
    private int goalFHome;
    private int goalSHome;
    private int matchPlayedAway;
    private int wonAway;
    private int lostAway;
    private int tieAway;
    private int goalFAway;
    private int goalSAway;

    public Team(String name) {
        this.name = name;
        this.points = 0;
        this.matchPlayed = 0;
        this.won = 0;
        this.lost = 0;
        this.tie = 0;
        this.goalF = 0;
        this.goalS = 0;
        this.matchPlayedHome = 0;
        this.wonHome = 0;
        this.lostHome = 0;
        this.tieHome = 0;
        this.goalFHome = 0;
        this.goalSHome = 0;
        this.matchPlayedAway = 0;
        this.wonAway = 0;
        this.lostAway = 0;
        this.tieAway = 0;
        this.goalFAway = 0;
        this.goalSAway = 0;
    }

    public Team(String name, int points, int matchPlayed, int won, int lost, int tie, int goalF, int goalS, int matchPlayedHome, int wonHome, int lostHome, int tieHome, int goalFHome, int goalSHome, int matchPlayedAway, int wonAway, int lostAway, int tieAway, int goalFAway, int goalSAway) {
        this.name = name;
        this.points = points;
        this.matchPlayed = matchPlayed;
        this.won = won;
        this.lost = lost;
        this.tie = tie;
        this.goalF = goalF;
        this.goalS = goalS;
        this.matchPlayedHome = matchPlayedHome;
        this.wonHome = wonHome;
        this.lostHome = lostHome;
        this.tieHome = tieHome;
        this.goalFHome = goalFHome;
        this.goalSHome = goalSHome;
        this.matchPlayedAway = matchPlayedAway;
        this.wonAway = wonAway;
        this.lostAway = lostAway;
        this.tieAway = tieAway;
        this.goalFAway = goalFAway;
        this.goalSAway = goalSAway;
    }

    public void setGoal(int goalFatti, int goalSub, boolean isHome){
        this.goalF+=goalFatti;
        this.goalS+=goalSub;
        if(isHome) {
            this.goalFHome+=goalFatti;
            this.goalSHome+=goalSub;
        } else {
            this.goalFAway+=goalFatti;
            this.goalSAway+=goalSub;
        }


    }
    public void sum(Team team2){
        this.points += team2.getPoints();
        this.matchPlayed += team2.getMatchPlayed();
        this.won += team2.getWon();
        this.lost += team2.getLost();
        this.tie += team2.getTie();
        this.goalF += team2.getGoalF();
        this.goalS += team2.getGoalS();
        this.matchPlayedHome += team2.getMatchPlayedHome() ;
        this.wonHome += team2.getWonHome() ;
        this.lostHome += team2.getLostHome() ;
        this.tieHome += team2.getTieHome() ;
        this.goalFHome += team2.getGoalFHome();
        this.goalSHome += team2.getGoalSHome();
        this.matchPlayedAway += team2.getMatchPlayedAway() ;
        this.wonAway += team2.getWonAway() ;
        this.lostAway += team2.getLostAway();
        this.tieAway += team2.getTieAway() ;
        this.goalFAway += team2.getGoalFAway() ;
        this.goalSAway += team2.getGoalSAway() ;



    }
    public void hasWon(boolean isHome) {
        this.points += 3;
        this.matchPlayed += 1;
        this.won += 1;
        if (isHome) {
            this.matchPlayedHome += 1;
            this.wonHome += 1;
        } else {
            this.matchPlayedAway += 1;
            this.wonAway += 1;

        }
    }
    public void tie(boolean isHome){
        this.points+=1;
        this.matchPlayed+=1;
        this.tie+=1;
        if(isHome){
            this.matchPlayedHome+=1;
            this.tieHome+=1;
        } else {
            this.matchPlayedAway+=1;
            this.tieAway+=1;
        }

    }
    public void lost(boolean isHome){
        this.matchPlayed+=1;
        this.lost+=1;
        if(isHome){
            this.matchPlayedHome+=1;
            this.lostHome+=1;
        } else {
            this.matchPlayedAway+=1;
            this.lostAway+=1;
        }

    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public int getMatchPlayed() {
        return matchPlayed;
    }

    public int getWon() {
        return won;
    }

    public int getLost() {
        return lost;
    }

    public int getTie() {
        return tie;
    }

    public int getGoalF() {
        return goalF;
    }

    public int getGoalS() {
        return goalS;
    }

    public int getMatchPlayedHome() {
        return matchPlayedHome;
    }

    public int getWonHome() {
        return wonHome;
    }

    public int getLostHome() {
        return lostHome;
    }

    public int getTieHome() {
        return tieHome;
    }

    public int getGoalFHome() {
        return goalFHome;
    }

    public int getGoalSHome() {
        return goalSHome;
    }

    public int getMatchPlayedAway() {
        return matchPlayedAway;
    }

    public int getWonAway() {
        return wonAway;
    }

    public int getLostAway() {
        return lostAway;
    }

    public int getTieAway() {
        return tieAway;
    }

    public int getGoalFAway() {
        return goalFAway;
    }

    public int getGoalSAway() {
        return goalSAway;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setMatchPlayed(int matchPlayed) {
        this.matchPlayed = matchPlayed;
    }

    public void setWon(int won) {
        this.won = won;
    }

    public void setLost(int lost) {
        this.lost = lost;
    }

    public void setTie(int tie) {
        this.tie = tie;
    }

    public void setGoalF(int goalF) {
        this.goalF = goalF;
    }

    public void setGoalS(int goalS) {
        this.goalS = goalS;
    }

    public void setMatchPlayedHome(int matchPlayedHome) {
        this.matchPlayedHome = matchPlayedHome;
    }

    public void setWonHome(int wonHome) {
        this.wonHome = wonHome;
    }

    public void setLostHome(int lostHome) {
        this.lostHome = lostHome;
    }

    public void setTieHome(int tieHome) {
        this.tieHome = tieHome;
    }

    public void setGoalFHome(int goalFHome) {
        this.goalFHome = goalFHome;
    }

    public void setGoalSHome(int goalSHome) {
        this.goalSHome = goalSHome;
    }

    public void setMatchPlayedAway(int matchPlayedAway) {
        this.matchPlayedAway = matchPlayedAway;
    }

    public void setWonAway(int wonAway) {
        this.wonAway = wonAway;
    }

    public void setLostAway(int lostAway) {
        this.lostAway = lostAway;
    }

    public void setTieAway(int tieAway) {
        this.tieAway = tieAway;
    }

    public void setGoalFAway(int goalFAway) {
        this.goalFAway = goalFAway;
    }

    @Override
    public String toString() {
        return
                name  +
                        " " + points +
                        " " + matchPlayed +
                        " " + won +
                        " " + lost +
                        " " + tie +
                        " " + goalF +
                        ":" + goalS +
                        " " + matchPlayedHome +
                        " " + wonHome +
                        " " + lostHome +
                        " " + tieHome +
                        " " + goalFHome +
                        ":" + goalSHome +
                        " " + matchPlayedAway +
                        " " + wonAway +
                        " " + lostAway +
                        " " + tieAway +
                        " " + goalFAway +
                        ":" + goalSAway+"\n"
                ;
    }

    @Override
    public int compareTo(@NotNull Object o) {
        int point=((Team)o).getPoints();
        /* For Ascending order*/
        return point-this.points;
    }
}