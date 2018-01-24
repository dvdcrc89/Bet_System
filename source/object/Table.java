package object;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

import com.sun.istack.internal.NotNull;

public class Table implements Serializable {

	private static final long serialVersionUID = 7296291866672094507L;
	private String nationName;
	private String year;
	private String leagueName;
	private ArrayList<Team> teams;

	public Table() {
		super();
	}

	public String getNationName() {
		return nationName;
	}

	public void setNationName(String nationName) {
		this.nationName = nationName;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getLeagueName() {
		return leagueName;
	}

	public void setLeagueName(String leagueName) {
		this.leagueName = leagueName;
	}

	public ArrayList<Team> getTeams() {
		return teams;
	}

	public void setTeams(ArrayList<Team> teams) {
		this.teams = teams;
	}

}
