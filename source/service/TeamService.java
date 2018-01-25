package service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import base.TeamUtils;
import object.League;
import object.Match;
import object.MatchDay;
import object.Team;

public class TeamService {

	static public ArrayList<Team> calucateTable(League league) {
		ArrayList<Team> teams = new ArrayList<Team>(calucateTeams(league).values());
		Collections.sort(teams);
		return teams;
	}

	static public ArrayList<Match> calucateForecast(League league) {
		ArrayList<Match> matches = new ArrayList<Match>();
		return matches;
	}

	private static HashMap<String, Team> calucateTeams(League league) {
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
}
