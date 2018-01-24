package service;

import org.springframework.stereotype.Service;

import base.AbstractHibernateService;
import dao.LeagueDAO;
import object.League;

@Service
public class LeagueService extends AbstractHibernateService<League, String, LeagueDAO> {

}