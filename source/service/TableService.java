package service;

import org.springframework.stereotype.Service;

import base.AbstractHibernateService;
import dao.TableDAO;
import object.Table;

@Service
public class TableService extends AbstractHibernateService<Table, String, TableDAO> {

	public Table findTableByMatchDay(int year, String leagueName, int numberMatchDay) {
		return null;
	}
}