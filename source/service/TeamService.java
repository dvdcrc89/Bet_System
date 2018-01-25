package service;

import java.util.HashMap;

import object.League;
import object.Match;
import object.Team;

public class TeamService {

	static public HashMap<String, Team> calucateTeamsTable(League league) {
		HashMap<String, Team> teams = new HashMap<String, Team>();
		return teams;
	}

	static public HashMap<String, Match> calucateMatchForecast(League league) {
		HashMap<String, Match> matches = new HashMap<String, Match>();
		// HashMap<String, Team> teams = TeamService.calucateTeamsTable(league);
		return matches;
	}
}
