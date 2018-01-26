package service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import base.AbstractHibernateService;
import base.TeamUtils;
import dao.TeamDAO;
import object.League;
import object.Match;
import object.MatchDay;
import object.Team;

public class TeamService extends AbstractHibernateService<Team, String, TeamDAO> {

	@Autowired
	private LeagueService leagueService;
	private static Team team;

	@Transactional(readOnly = true)
	public HashMap<String, Team> findTeamsByLeague(int year, String leagueName) {
		League league = leagueService.findLeagueByYear(year, leagueName);
		return calucateTeams(league);
	}

	@Transactional(readOnly = true)
	public HashMap<String, Team> findTeamsByLeague(int year, String leagueName, int numberMatchDay) {
		League league = leagueService.findLeagueByMatchDay(year, leagueName, numberMatchDay);
		return calucateTeams(league);
	}

	static public ArrayList<Team> calucateTable(League league) {
		ArrayList<Team> teams = new ArrayList<Team>(calucateTeams(league).values());
		Collections.sort(teams);
		return teams;
	}

	static public ArrayList<Match> calucateForecast(League league) {
		ArrayList<Match> matches = new ArrayList<Match>(); // Partite da Pronosticare. Immagina di avere il calendario
															// nel database
		for (Team team : calucateTeams(league).values()) {

		}
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

				team = TeamUtils.updateTeam(teams.get(match.getTeamHome()), match);
				teams.replace(match.getTeamHome(), team);

				team = TeamUtils.updateTeam(teams.get(match.getTeamAway()), match);
				teams.replace(match.getTeamAway(), team);

			}
		}

		return teams;
	}
}
