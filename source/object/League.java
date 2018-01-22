package object;

import java.io.Serializable;
import java.util.ArrayList;

public class League implements Serializable {

	private static final long serialVersionUID = -7864957605565831057L;
	private String idLeague;
	private String name;
	private String nation;
	private int yearStart;
	private int yearEnd;
	private ArrayList<MatchDay> matchDays;

	public League() {
		super();
	}

	public String getIdLeague() {
		return idLeague;
	}

	public void setIdLeague(String idLeague) {
		this.idLeague = idLeague;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public int getYearStart() {
		return yearStart;
	}

	public void setYearStart(int yearStart) {
		this.yearStart = yearStart;
	}

	public int getYearEnd() {
		return yearEnd;
	}

	public void setYearEnd(int yearEnd) {
		this.yearEnd = yearEnd;
	}

	public ArrayList<MatchDay> getMatchDays() {
		return matchDays;
	}

	public void setMatchDays(ArrayList<MatchDay> matchDays) {
		this.matchDays = matchDays;
	}

}
