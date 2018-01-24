package dao;

import org.springframework.stereotype.Repository;

import base.AbstractHibernateDAO;
import object.Team;

@Repository
public class TeamDAO extends AbstractHibernateDAO<Team, String> {

}