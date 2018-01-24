package object;

import java.io.Serializable;
import java.util.*;

public class Table implements Serializable {

	private static final long serialVersionUID = 7296291866672094507L;	
	private String nation;
	private String leagueName;
   	private String year;
    private ArrayList<Team> teams;

    public Table(String nation, String leagueName, String year, Hashtable<String, Team> hashTeam) {
        this.nation = nation;
        this.leagueName = leagueName;
        this.year = year;
        teams = new ArrayList<>();
        teams = generatePrintableTable(hashTeam);
    }


    public ArrayList<Team> generatePrintableTable(Hashtable<String, Team> hashTeam) {
        {
            ArrayList<Team> teams = new ArrayList<Team>(hashTeam.values());
            Collections.sort(teams);
            return teams;
        }
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getLeagueName() {
        return leagueName;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public ArrayList<Team> getTeams() {
        return teams;
    }

    public void setTeams(ArrayList<Team> teams) {
        this.teams = teams;
    }

    @Override
    public String toString() {
        return "{\"Table\":{"
                + "                        \"nation\":\"" + nation + "\""
                + ",                         \"leagueName\":\"" + leagueName + "\""
                + ",                         \"year\":\"" + year + "\""
                + ",                         \"teams\":" + teams
                + "}}";
    }
}

