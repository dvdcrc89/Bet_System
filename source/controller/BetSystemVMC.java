package controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;

import object.Table;
import object.Team;
import service.TableService;
import service.TeamService;

@Controller
@RequestMapping(value = "", method = RequestMethod.POST)
public class BetSystemVMC {

	private ObjectMapper mapper;
	private Table table;
	private HashMap<String, Team> teams;

	@Autowired
	TableService tableService;

	@Autowired
	TeamService teamService;

	@RequestMapping(value = "/table/{year}/{league}", method = RequestMethod.POST)
	@ResponseBody
	public String tableByYear(@PathVariable(value = "year") final int year,
			@PathVariable(value = "league") final String leagueName) throws Exception {
		table = tableService.findTableByYear(year, leagueName);
		return mapper.writeValueAsString(table);
	}

	@RequestMapping(value = "/table/{year}/{league}/{matchday}", method = RequestMethod.POST)
	@ResponseBody
	public HashMap<String, Team> teamsByYear(@PathVariable(value = "year") final int year,
			@PathVariable(value = "league") final String leagueName,@PathVariable(value = "matchday") final String numberMatchday) throws Exception {
		teams = teamService.findTeamByMatchDay(year, leagueName, numberMatchday);
		return teams;
	}
}