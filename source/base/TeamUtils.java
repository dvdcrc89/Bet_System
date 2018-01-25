package base;

import object.Match;

public class TeamUtils {
	public static int getTeamPoints(Match match, String where) {
		if (where.equals("home")) {
			return new TeamUtils().getTeamHomePoints(match);
		}
		if (where.equals("away")) {
			return new TeamUtils().getTeamAwayPoints(match);
		}
		return 0;
	}

	private int getTeamHomePoints(Match match) {
		return 0;
	}

	private int getTeamAwayPoints(Match match) {
		return 0;
	}
}
