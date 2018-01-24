package service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import base.AbstractHibernateService;
import dao.LeagueDAO;
import object.League;

@Service
public class LeagueService extends AbstractHibernateService<League, String, LeagueDAO> {

	@Transactional(readOnly = true)
	public League findLeagueByYear(int year, String leagueName) {
		return dao.findLeagueByYear(year, leagueName);
	}

	@Transactional(readOnly = true)
	public League findLeagueByMatchDay(int year, String leagueName, int numberMatchDay) {
		return dao.findLeagueByMatchDay(year, leagueName, numberMatchDay);
	}
}