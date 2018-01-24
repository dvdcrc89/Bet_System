package base;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractHibernateDAO<T, ID extends Serializable> {

	protected Logger logger = Logger.getLogger(this.getClass());

	private Class<T> clazz;

	@Autowired
	SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	protected AbstractHibernateDAO() {
		this.clazz = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	@SuppressWarnings("unchecked")
	public List<T> findByCriteria(List<Criterion> criterions, List<Order> orders, boolean exclusiveLock,
			Integer maxResults, Hashtable<String, String> aliases, String... fetchProperties) {
		Criteria criteria = createCriteria(criterions, orders, maxResults, aliases);
		if (exclusiveLock) {
			criteria.setLockMode(LockMode.PESSIMISTIC_WRITE);
		}
		for (String property : fetchProperties) {
			criteria.setFetchMode(property, FetchMode.JOIN);
		}
		return (List<T>) criteria.list();
	}

	public List<T> findByCriteria(List<Criterion> criterions, List<Order> orders, boolean exclusiveLock,
			String... fetchProperties) {
		return findByCriteria(criterions, orders, false, null, null, fetchProperties);
	}

	public List<T> findByCriteria(List<Criterion> criterions, List<Order> orders, String... fetchProperties) {
		return findByCriteria(criterions, orders, false, null, null, fetchProperties);
	}

	public List<T> findByCriteria(List<Criterion> criterions, List<Order> orders, Integer maxResults,
			String... fetchProperties) {
		return findByCriteria(criterions, orders, false, maxResults, null, fetchProperties);
	}

	public List<T> findByCriteria(List<Criterion> criterions, String... fetchProperties) {
		return findByCriteria(criterions, null, false, null, null, fetchProperties);
	}

	public List<T> findByCriteria(List<Criterion> criterions, Hashtable<String, String> aliases,
			String... fetchProperties) {
		return findByCriteria(criterions, null, false, null, aliases, fetchProperties);
	}

	public List<T> findByCriteria(List<Criterion> criterions, Integer maxResults, String... fetchProperties) {
		return findByCriteria(criterions, null, false, maxResults, null, fetchProperties);
	}

	public List<T> findAll() {
		return findByCriteria(null, new String[0]);
	}

	public List<T> findAll(Integer maxResults) {
		return findByCriteria(null, maxResults);
	}

	@SuppressWarnings("unchecked")
	public T findById(ID id, boolean exclusiveLock, String... fetchProperties) {
		if (exclusiveLock || fetchProperties.length > 0) {
			List<T> result = findByCriteria(newCriterionList(Restrictions.eq("id", id)), null, exclusiveLock,
					fetchProperties);
			return result.size() > 0 ? result.get(0) : null;
		} else {
			return (T) getCurrentSession().get(clazz, id);
		}
	}

	public T findById(ID id, String... fetchProperties) {
		return findById(id, false, fetchProperties);
	}

	public List<T> findByName(String name, MatchMode matchMode, String... fetchProperties) {
		return findByCriteria(newCriterionList(Restrictions.ilike("name", name, matchMode)),
				newOrderList(Order.asc("name")), false, fetchProperties);
	}

	public List<T> findByName(String name, MatchMode matchMode, Integer maxResults, String... fetchProperties) {
		return findByCriteria(newCriterionList(Restrictions.ilike("name", name, matchMode)),
				newOrderList(Order.asc("name")), false, maxResults, null, fetchProperties);
	}

	public List<T> findByName(String name, String... fetchProperties) {
		return findByName(name, MatchMode.START, fetchProperties);
	}

	public List<T> findByName(String name, Integer maxResults, String... fetchProperties) {
		return findByName(name, MatchMode.START, maxResults, fetchProperties);
	}

	@SuppressWarnings("unchecked")
	public ID create(T entity) {
		return (ID) getCurrentSession().save(entity);
	}

	@SuppressWarnings("unchecked")
	public T update(T entity) {
		return (T) getCurrentSession().merge(entity);
	}

	public void delete(T entity) {
		getCurrentSession().delete(entity);
	}

	public void deleteById(ID id) {
		T entity = findById(id);
		delete(entity);
	}

	private List<Criterion> newCriterionList(Criterion... criterions) {
		List<Criterion> result = new ArrayList<Criterion>();

		for (Criterion criterion : criterions) {
			result.add(criterion);
		}

		return result;
	}

	private Criteria createCriteria(List<Criterion> criterions, List<Order> orders, Integer maxResults,
			Hashtable<String, String> aliases) {
		Criteria criteria = getCurrentSession().createCriteria(this.clazz);

		if (criterions != null) {
			for (Criterion criterion : criterions) {
				criteria.add(criterion);
			}
		}

		if (orders != null) {
			for (Order order : orders) {
				criteria.addOrder(order);
			}
		}

		if (maxResults != null && maxResults.intValue() > 0) {
			criteria.setMaxResults(maxResults.intValue());
		}

		if (aliases != null) {
			Enumeration<String> keys = aliases.keys();
			while (keys.hasMoreElements()) {
				String key = keys.nextElement();
				String value = aliases.get(key);
				criteria.createAlias(key, value);
			}
		}

		return criteria;
	}

	private List<Order> newOrderList(Order... orders) {
		List<Order> result = new ArrayList<Order>();

		for (Order order : orders) {
			result.add(order);
		}

		return result;
	}

	/**
	 * Funzione di utilità per le sottoclassi
	 */
	protected final Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

}