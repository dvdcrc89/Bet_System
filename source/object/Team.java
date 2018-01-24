package object;

import java.io.Serializable;

public class Team implements Serializable {

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

	public void setGoalSAway(int goalSAway) {
		this.goalSAway = goalSAway;
	}
}
