package service;

import org.springframework.stereotype.Service;

import base.AbstractHibernateService;
import dao.TeamDAO;
import object.Team;

@Service
public class TeamService extends AbstractHibernateService<Team, String, TeamDAO> {

}