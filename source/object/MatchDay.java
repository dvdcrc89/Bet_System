package object;

import java.io.Serializable;
import java.util.ArrayList;

public class MatchDay implements Serializable {

	private static final long serialVersionUID = 7651386059452553444L;
	private String idMatchDay;
	private String idLeague;
	private int number;
	private ArrayList<Match> matches;

	public MatchDay() {
		super();
	}

	public String getIdMatchDay() {
		return idMatchDay;
	}

	public void setIdMatchDay(String idMatchDay) {
		this.idMatchDay = idMatchDay;
	}

	public String getIdLeague() {
		return idLeague;
	}

	public void setIdLeague(String idLeague) {
		this.idLeague = idLeague;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public ArrayList<Match> getMatches() {
		return matches;
	}

	public void setMatches(ArrayList<Match> matches) {
		this.matches = matches;
	}

}
