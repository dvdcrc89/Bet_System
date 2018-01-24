package service;

import org.springframework.stereotype.Service;

import base.AbstractHibernateService;
import dao.MatchDAO;
import object.Match;

@Service
public class MatchService extends AbstractHibernateService<Match, String, MatchDAO> {

}