package dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import base.AbstractHibernateDAO;
import object.League;

@Repository
public class LeagueDAO extends AbstractHibernateDAO<League, String> {

	protected Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	SessionFactory sessionFactory;

	public League findLeagueByYear(int year, String leagueName) {

		List<Criterion> criterions = new ArrayList<Criterion>();
		criterions.add(Restrictions.eq("yearEnd", year));
		criterions.add(Restrictions.eq("name", leagueName));

		List<Order> orders = new ArrayList<Order>();
		orders.add(Order.asc("matchday.number"));

		return findByCriteria(criterions, orders).get(0);
	}

	public League findLeagueByMatchDay(int year, String leagueName, int numberMatchDay) {

		List<Criterion> criterions = new ArrayList<Criterion>();
		criterions.add(Restrictions.eq("yearEnd", year));
		criterions.add(Restrictions.eq("name", leagueName));
		criterions.add(Restrictions.le("matchday", numberMatchDay));

		List<Order> orders = new ArrayList<Order>();
		orders.add(Order.asc("matchday.number"));

		return findByCriteria(criterions, orders).get(0);
	}
}