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
	public Table findTableByMatchDay(int year, String leagueName, int numberMatchDay) {

		League league = leagueService.findLeagueByMatchDay(year, leagueName, numberMatchDay);
		
		return table;
	}

}