package base;
import object.*;
import object.League;
import object.Table;

import java.util.Hashtable;


public class MatchFactory {
	static public Table calucateTable(League league) {
		String year = league.getYearStart()+"-"+league.getYearEnd();
        generateHashtable gh = new generateHashtable();
        Table table = new Table(league.getNation(),league.getName(),year,gh.generateHash(league.getMatches()));
		return table;
	}
}
