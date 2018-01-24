package object;

import java.io.Serializable;
import java.util.HashMap;

public class Table implements Serializable {

	private static final long serialVersionUID = 7296291866672094507L;
	private HashMap<String, Team> teams;

	public Table() {
		super();
	}

	public HashMap<String, Team> getTeams() {
		return teams;
	}

	public void setTeams(HashMap<String, Team> teams) {
		this.teams = teams;
	}

}
