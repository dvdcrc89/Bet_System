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
			return match.getResult() == 1 ? 3 : match.getResult() == 0 ? 1 : 0;
		}
		if (where.equals("away")) {
			return match.getResult() == 2 ? 3 : match.getResult() == 0 ? 1 : 0;
		}
		return 0;
	}
}
