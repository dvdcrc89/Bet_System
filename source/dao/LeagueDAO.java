package dao;

import org.springframework.stereotype.Repository;

import base.AbstractHibernateDAO;
import object.League;

@Repository
public class LeagueDAO extends AbstractHibernateDAO<League, String> {

}