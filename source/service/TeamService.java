package service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import base.AbstractHibernateService;
import dao.TeamDAO;
import object.League;
import object.MatchDay;
import object.Team;

@Service
public class TeamService extends AbstractHibernateService<Team, String, TeamDAO> {

	@Autowired
	private LeagueService leagueService;
	private HashMap<String, Team> teams;

	@Transactional(readOnly = true)
	public HashMap<String, Team> findTeamByMatchDay(int year, String leagueName, int numberMatchday) {
		
		League league = leagueService.findLeagueByYear(year, leagueName);
		return this.calucateTeamsByLeague(league);
	}
	
	private HashMap<String, Team> calucateTeamsByLeague(League league) {
		teams = new HashMap<String, Team>();
		for (MatchDay matchDay : league.getMatchDays()) {

		}
		return teams;
	}
}