package service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import base.AbstractHibernateService;
import dao.TableDAO;
import object.League;
import object.MatchDay;
import object.Table;
import object.Team;

@Service
public class TableService extends AbstractHibernateService<Table, String, TableDAO> {

	@Autowired
	private LeagueService leagueService;
	private Table table;

	@Transactional(readOnly = true)
	public Table findTableByYear(int year, String leagueName) {

		League league = leagueService.findLeagueByYear(year, leagueName);

		HashMap<String, Team> teams = new HashMap<String, Team>();
		for (MatchDay matchDay : league.getMatchDays()) {

		}
		
		table.setNationName(league.getNation());
		table.setYear(league.getYearStart() + "/" + league.getYearEnd());
		table.setLeagueName(league.getName());
		table.setTeams(teams);
		return table;
	}

}