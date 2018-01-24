package dao;

import org.springframework.stereotype.Repository;

import base.AbstractHibernateDAO;
import object.Match;

@Repository
public class MatchDAO extends AbstractHibernateDAO<Match, String> {

}