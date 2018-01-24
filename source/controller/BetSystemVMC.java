package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;

import object.Table;
import service.TableService;

@Controller
@RequestMapping(value = "", method = RequestMethod.POST)
public class BetSystemVMC {

	private ObjectMapper mapper;
	private Table table;

	@Autowired
	TableService tableService;

	@RequestMapping(value = "/table/{league}/{year}/{matchday}", method = RequestMethod.POST)
	@ResponseBody
	public String table(HttpServletRequest request) throws Exception {
		return mapper.writeValueAsString(table);
	}
}