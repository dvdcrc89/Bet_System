package base;

import object.Match;

public class TeamUtils {

	public static int getTeamHomePoints(Match match) {
		return new TeamUtils().getTeamPoints(match, "home");
	}

	public static int getTeamAwayPoints(Match match) {
		return new TeamUtils().getTeamPoints(match, "away");
	}

	private int getTeamPoints(Match match, String where) {
		if (where.equals("home")) {
			return 0;
		}
		if (where.equals("away")) {
			return 0;
		}
		return 0;
	}
}
