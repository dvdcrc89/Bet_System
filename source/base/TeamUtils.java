package base;

import object.Match;
import object.Team;

public class TeamUtils {

	public static Team updateTeam(Team team, Match match) {
		team.setMatchPlayed(team.getMatchPlayed() + 1);
		if (team.getName().equals(match.getTeamHome())) {

			team.setMatchPlayedHome(team.getMatchPlayedHome() + 1);
			team.setGoalMake(team.getGoalMake() + match.getGoalHome());
			team.setGoalMakeHome(team.getGoalMakeHome() + match.getGoalHome());
			team.setGoalLose(team.getGoalLose() + match.getGoalAway());
			team.setGoalLoseHome(team.getGoalLoseHome() + match.getGoalAway());

			if (match.getResult() == 1) {
				team.setPoints(team.getPoints() + 3);
				team.setWin(team.getWin() + 1);
				team.setWonHome(team.getWonHome() + 1);
			} else if (match.getResult() == 0) {
				team.setPoints(team.getPoints() + 1);
				team.setTie(team.getTie() + 1);
				team.setTieHome(team.getTieHome() + 1);
			} else if (match.getResult() == 2) {
				team.setLost(team.getLost() + 1);
				team.setLostHome(team.getLostHome() + 1);
			}

		}
		if (team.getName().equals(match.getTeamAway())) {

			team.setMatchPlayedAway(team.getMatchPlayedAway() + 1);
			team.setGoalMake(team.getGoalMake() + match.getGoalAway());
			team.setGoalMakeAway(team.getGoalMakeAway() + match.getGoalAway());
			team.setGoalLose(team.getGoalLose() + match.getGoalHome());
			team.setGoalLoseAway(team.getGoalMakeAway() + match.getGoalHome());

			if (match.getResult() == 2) {
				team.setPoints(team.getPoints() + 3);
				team.setWin(team.getWin() + 1);
				team.setWonAway(team.getWonAway() + 1);
			} else if (match.getResult() == 0) {
				team.setPoints(team.getPoints() + 1);
				team.setTie(team.getTie() + 1);
				team.setTieAway(team.getTieAway() + 1);
			} else if (match.getResult() == 1) {
				team.setLost(team.getLost() + 1);
				team.setLostAway(team.getLostAway() + 1);
			}

		}
		return team;
	}
}
