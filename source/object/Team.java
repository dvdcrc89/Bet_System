package object;

import java.io.Serializable;

public class Team implements Serializable {

	private static final long serialVersionUID = -3942570304764550707L;
	private String name;
	private int points;
	private int matchPlayed;
	private int win;
	private int lost;
	private int tie;
	private int goalMake;
	private int goalLose;
	private int matchPlayedHome;
	private int wonHome;
	private int lostHome;
	private int tieHome;
	private int goalMakeHome;
	private int goalLoseHome;
	private int matchPlayedAway;
	private int wonAway;
	private int lostAway;
	private int tieAway;
	private int goalMakeAway;
	private int goalLoseAway;

	public Team() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getMatchPlayed() {
		return matchPlayed;
	}

	public void setMatchPlayed(int matchPlayed) {
		this.matchPlayed = matchPlayed;
	}

	public int getWin() {
		return win;
	}

	public void setWin(int win) {
		this.win = win;
	}

	public int getLost() {
		return lost;
	}

	public void setLost(int lost) {
		this.lost = lost;
	}

	public int getTie() {
		return tie;
	}

	public void setTie(int tie) {
		this.tie = tie;
	}

	public int getGoalMake() {
		return goalMake;
	}

	public void setGoalMake(int goalMake) {
		this.goalMake = goalMake;
	}

	public int getGoalLose() {
		return goalLose;
	}

	public void setGoalLose(int goalLose) {
		this.goalLose = goalLose;
	}

	public int getMatchPlayedHome() {
		return matchPlayedHome;
	}

	public void setMatchPlayedHome(int matchPlayedHome) {
		this.matchPlayedHome = matchPlayedHome;
	}

	public int getWonHome() {
		return wonHome;
	}

	public void setWonHome(int wonHome) {
		this.wonHome = wonHome;
	}

	public int getLostHome() {
		return lostHome;
	}

	public void setLostHome(int lostHome) {
		this.lostHome = lostHome;
	}

	public int getTieHome() {
		return tieHome;
	}

	public void setTieHome(int tieHome) {
		this.tieHome = tieHome;
	}

	public int getGoalMakeHome() {
		return goalMakeHome;
	}

	public void setGoalMakeHome(int goalMakeHome) {
		this.goalMakeHome = goalMakeHome;
	}

	public int getGoalLoseHome() {
		return goalLoseHome;
	}

	public void setGoalLoseHome(int goalLoseHome) {
		this.goalLoseHome = goalLoseHome;
	}

	public int getMatchPlayedAway() {
		return matchPlayedAway;
	}

	public void setMatchPlayedAway(int matchPlayedAway) {
		this.matchPlayedAway = matchPlayedAway;
	}

	public int getWonAway() {
		return wonAway;
	}

	public void setWonAway(int wonAway) {
		this.wonAway = wonAway;
	}

	public int getLostAway() {
		return lostAway;
	}

	public void setLostAway(int lostAway) {
		this.lostAway = lostAway;
	}

	public int getTieAway() {
		return tieAway;
	}

	public void setTieAway(int tieAway) {
		this.tieAway = tieAway;
	}

	public int getGoalMakeAway() {
		return goalMakeAway;
	}

	public void setGoalMakeAway(int goalMakeAway) {
		this.goalMakeAway = goalMakeAway;
	}

	public int getGoalLoseAway() {
		return goalLoseAway;
	}

	public void setGoalLoseAway(int goalLoseAway) {
		this.goalLoseAway = goalLoseAway;
	}

}
