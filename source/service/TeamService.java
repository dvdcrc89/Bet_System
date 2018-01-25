package service;

import java.util.HashMap;

import base.TeamUtils;
import object.League;
import object.Match;
import object.MatchDay;
import object.Team;

public class TeamService {

	static public HashMap<String, Team> calucateTeamsTable(League league) {
		HashMap<String, Team> teams = new HashMap<String, Team>();
		for (MatchDay matchDay : league.getMatchDays()) {
			for (Match match : matchDay.getMatches()) {
				if (!teams.containsKey(match.getTeamHome())) {
					Team team = new Team();
					team.setPoints(TeamUtils.getTeamHomePoints(match));

					teams.put(match.getTeamHome(), team);
				} else {
					Team team = teams.get(match.getTeamHome());
					team.setPoints(team.getPoints() + TeamUtils.getTeamHomePoints(match));

					teams.replace(match.getTeamHome(), team);
				}

				if (!teams.containsKey(match.getTeamAway())) {
					Team team = new Team();
					team.setPoints(TeamUtils.getTeamAwayPoints(match));

					teams.put(match.getTeamAway(), team);
				} else {
					Team team = teams.get(match.getTeamAway());
					team.setPoints(team.getPoints() + TeamUtils.getTeamAwayPoints(match));

					teams.replace(match.getTeamHome(), team);
				}
			}
		}
		return teams;
	}

	static public HashMap<String, Match> calucateMatchForecast(League league) {
		HashMap<String, Match> matches = new HashMap<String, Match>();
		// HashMap<String, Team> teams = TeamService.calucateTeamsTable(league);
		return matches;
	}
}
