package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import base.AbstractHibernateService;
import dao.TableDAO;
import object.League;
import object.Table;

@Service
public class TableService extends AbstractHibernateService<Table, String, TableDAO> {

	@Autowired
	private LeagueService leagueService;
	private Table table;

	@Transactional(readOnly = true)
	public Table findTableByLeague(int year, String leagueName) {
		League league = leagueService.findLeagueByYear(year, leagueName);
		table = new Table();
		table.setNationName(league.getNation());
		table.setYear(league.getYearStart() + "/" + league.getYearEnd());
		table.setLeagueName(leagueName);
		table.setTeams(TeamService.calucateTable(league));
		return table;
	}

	@Transactional(readOnly = true)
	public Table findTableByLeague(int year, String leagueName, int numberMatchDay) {
		League league = leagueService.findLeagueByMatchDay(year, leagueName, numberMatchDay);
		table = new Table();
		table.setNationName(league.getNation());
		table.setYear(league.getYearStart() + "/" + league.getYearEnd());
		table.setLeagueName(leagueName);
		table.setTeams(TeamService.calucateTable(league));
		return table;
	}

}