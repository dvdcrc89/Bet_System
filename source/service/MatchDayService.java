package service;

import org.springframework.stereotype.Service;

import base.AbstractHibernateService;
import dao.MatchDayDAO;
import object.MatchDay;

@Service
public class MatchDayService extends AbstractHibernateService<MatchDay, String, MatchDayDAO> {

}