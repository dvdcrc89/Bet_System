package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import base.AbstractHibernateService;
import dao.TableDAO;
import object.Forecast;
import object.League;
import object.Table;

@Service
public class ForecastService extends AbstractHibernateService<Table, String, TableDAO> {

	@Autowired
	private LeagueService leagueService;
	private Forecast forecast;

	@Transactional(readOnly = true)
	public Forecast findTableByYear(int year, String leagueName) {
		League league = leagueService.findLeagueByYear(year, leagueName);
		forecast = new Forecast();
		forecast.setNationName(league.getNation());
		forecast.setYear(league.getYearStart() + "/" + league.getYearEnd());
		forecast.setLeagueName(league.getName());
		forecast.setMatchDay("Giornata ");
		forecast.setMatches(TeamService.calucateMatchForecast(league));
		return forecast;
	}

	@Transactional(readOnly = true)
	public Forecast findTableByMatchDay(int year, String leagueName, int numberMatchDay) {
		League league = leagueService.findLeagueByMatchDay(year, leagueName, numberMatchDay);
		forecast = new Forecast();
		forecast.setNationName(league.getNation());
		forecast.setYear(league.getYearStart() + "/" + league.getYearEnd());
		forecast.setLeagueName(league.getName());
		forecast.setMatchDay("Giornata ");
		forecast.setMatches(TeamService.calucateMatchForecast(league));
		return forecast;
	}

}