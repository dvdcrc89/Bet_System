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
					team.setName(match.getTeamHome());
					teams.put(match.getTeamHome(), team);
				}

				if (!teams.containsKey(match.getTeamAway())) {
					Team team = new Team();
					team.setName(match.getTeamAway());
					teams.put(match.getTeamAway(), team);
				}

				if (teams.containsKey(match.getTeamHome())) {
					Team team = TeamUtils.updateTeam(teams.get(match.getTeamHome()), match);
					teams.replace(match.getTeamHome(), team);
				}

				if (teams.containsKey(match.getTeamAway())) {
					Team team = TeamUtils.updateTeam(teams.get(match.getTeamAway()), match);
					teams.replace(match.getTeamAway(), team);
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
