package object;

import java.io.Serializable;

public class Match implements Serializable {

	private static final long serialVersionUID = -8980161868900583360L;
	private String idMatch;
	private String idMatchDay;
	private String date;
	private String time;
	private String home;
	private String away;
	private Team teamHome;
	private Team teamAway;
	private int goalHome;
	private int goalAway;

    public Match(String home, String away, int goalHome, int goalAway) {
        this.home = home;
        this.away = away;
        this.goalHome = goalHome;
        this.goalAway = goalAway;
        teamAway =new Team(away);
        teamHome = new Team(home);
    }

    public Match(Team teamHome, Team teamAway, int goalHome, int goalAway) {
        this.teamHome = teamHome;
        this.teamAway = teamAway;
        this.goalHome = goalHome;
        this.goalAway = goalAway;
    }



    public void updateTable(){
        if (getResult()>0){
            teamHome.hasWon(true);
            teamAway.lost(false);

        } else if (getResult()==-1){
            teamAway.hasWon(false);
            teamHome.lost(true);
        } else if(getResult()==0){
            teamAway.tie(false);
            teamHome.tie(true);


        }

        teamHome.setGoal(goalHome,goalAway,true);
        teamAway.setGoal(goalAway,goalHome,false);

    }

    public int getResult(){
        if (getGoalHome()>getGoalAway()) return 1;
        if (getGoalHome()<getGoalAway()) return -1;
        if (getGoalHome()==getGoalAway()) return 0;
        return -5;
    }


    public Team getTeamHome() {
        return teamHome;
    }

    public void setTeamHome(Team teamHome) {
        this.teamHome = teamHome;
    }

    public Team getTeamAway() {
        return teamAway;
    }

    public void setTeamAway(Team teamAway) {
        this.teamAway = teamAway;
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

    public String gethome() {
        return home;
    }

    public void sethome(String home) {
        this.home = home;
    }

    public String getaway() {
        return away;
    }

    public void setaway(String away) {
        this.away = away;
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

