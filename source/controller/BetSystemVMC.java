package controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import object.Forecast;
import object.Table;
import object.Team;
import service.ForecastService;
import service.TableService;
import service.TeamService;

@Controller
@RequestMapping(value = "/", method = RequestMethod.POST)
public class BetSystemVMC {

	private ObjectMapper mapper = new ObjectMapper();

	@Autowired
	private TableService tableService;

	@Autowired
	private TeamService teamService;

	@Autowired
	private ForecastService forecastService;

	@RequestMapping(value = "/table/{year}/{league}/", method = RequestMethod.POST)
	public String tableByYear(@PathVariable(value = "year") int year, @PathVariable(value = "league") String league) {

		Table table = tableService.findTableByYear(year, league);
		try {
			return mapper.writeValueAsString(table);
		} catch (JsonProcessingException ex) {
			return null;
		}
	}

	@RequestMapping(value = "/table/{year}/{league}/{matchday}", method = RequestMethod.POST)
	public String tableByMatchDay(@PathVariable(value = "year") int year, @PathVariable(value = "league") String league,
			@PathVariable(value = "matchday") int matchday) {

		Table table = tableService.findTableByMatchDay(year, league, matchday);
		try {
			return mapper.writeValueAsString(table);
		} catch (JsonProcessingException ex) {
			return null;
		}
	}

	@RequestMapping(value = "/forecast/{year}/{league}/", method = RequestMethod.POST)
	public String forecastByLeague(@PathVariable(value = "year") int year,
			@PathVariable(value = "league") String league) {

		Forecast forecast = forecastService.findForecastByLeague(year, league);
		try {
			return mapper.writeValueAsString(forecast);
		} catch (JsonProcessingException ex) {
			return null;
		}
	}

	@RequestMapping(value = "/teams/{year}/{league}/", method = RequestMethod.POST)
	public String teamsByYear(@PathVariable(value = "year") int year, @PathVariable(value = "league") String league) {

		HashMap<String, Team> teams = teamService.findTeamsByYear(year, league);
		try {
			return mapper.writeValueAsString(teams);
		} catch (JsonProcessingException ex) {
			return null;
		}
	}

	@RequestMapping(value = "/teams/{year}/{league}/{matchday}", method = RequestMethod.POST)
	public String teamsByMatchDay(@PathVariable(value = "year") int year, @PathVariable(value = "league") String league,
			@PathVariable(value = "matchday") int matchday) {

		HashMap<String, Team> teams = teamService.findTeamsByMatchDay(year, league, matchday);
		try {
			return mapper.writeValueAsString(teams);
		} catch (JsonProcessingException ex) {
			return null;
		}
	}

}