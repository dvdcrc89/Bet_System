package object;

import java.io.Serializable;
import java.util.HashMap;

public class Forecast implements Serializable {

	private static final long serialVersionUID = 6468806561414435487L;
	private String nationName;
	private String year;
	private String leagueName;
	private String matchDay;
	private HashMap<String, Match> matches;

	public Forecast() {
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

	public String getMatchDay() {
		return matchDay;
	}

	public void setMatchDay(String matchDay) {
		this.matchDay = matchDay;
	}

	public HashMap<String, Match> getMatches() {
		return matches;
	}

	public void setMatches(HashMap<String, Match> matches) {
		this.matches = matches;
	}

}
