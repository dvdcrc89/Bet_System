package object;

import java.io.Serializable;

public class Match implements Serializable {

	private static final long serialVersionUID = -8980161868900583360L;
	private String idMatch;
	private String idMatchDay;
	private String date;
	private String time;
	private String teamHome;
	private String teamAway;
	private int goalHome;
	private int goalAway;

	public Match() {
		super();
	}

	public String getIdMatch() {
		return idMatch;
	}

	public void setIdMatch(String idMatch) {
		this.idMatch = idMatch;
	}

	public String getIdMatchDay() {
		return idMatchDay;
	}

	public void setIdMatchDay(String idMatchDay) {
		this.idMatchDay = idMatchDay;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getTeamHome() {
		return teamHome;
	}

	public void setTeamHome(String teamHome) {
		this.teamHome = teamHome;
	}

	public String getTeamAway() {
		return teamAway;
	}

	public void setTeamAway(String teamAway) {
		this.teamAway = teamAway;
	}

	public int getGoalHome() {
		return goalHome;
	}

	public void setGoalHome(int goalHome) {
		this.goalHome = goalHome;
	}

	public int getGoalAway() {
		return goalAway;
	}

	public void setGoalAway(int goalAway) {
		this.goalAway = goalAway;
	}

}
