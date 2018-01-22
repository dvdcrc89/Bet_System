package base;

import java.io.Serializable;
import java.util.Hashtable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public abstract class AbstractHibernateService<T, ID extends Serializable, DAO extends AbstractHibernateDAO<T, ID>> {

	protected Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
	protected DAO dao;
	
	@Transactional(readOnly = false)
	public List<T> findByCriteria(List<Criterion> criterions, List<Order> orders, boolean exclusiveLock, String... fetchProperties) {
		return dao.findByCriteria(criterions, orders, exclusiveLock, fetchProperties);
	}
	
	@Transactional(readOnly = false)
	public List<T> findByCriteria(List<Criterion> criterions, List<Order> orders, boolean exclusiveLock, Integer maxResults, String... fetchProperties) {
		return dao.findByCriteria(criterions, orders, exclusiveLock, maxResults, null, fetchProperties);
	}
	
	@Transactional(readOnly = true)
	public List<T> findByCriteria(List<Criterion> criterions, List<Order> orders, String... fetchProperties) {
		return dao.findByCriteria(criterions, orders, fetchProperties);
	}
	
	@Transactional(readOnly = true)
	public List<T> findByCriteria(List<Criterion> criterions, List<Order> orders, Integer maxResults, String... fetchProperties) {
		return dao.findByCriteria(criterions, orders, maxResults, fetchProperties);
	}
	
	@Transactional(readOnly = true)
	public List<T> findByCriteria(List<Criterion> criterions, String... fetchProperties) {
		return dao.findByCriteria(criterions, fetchProperties);
	}
	
	@Transactional(readOnly = true)
	public List<T> findByCriteria(List<Criterion> criterions, Hashtable<String, String> aliases, String... fetchProperties) {
		return dao.findByCriteria(criterions, aliases, fetchProperties);
	}
	
	@Transactional(readOnly = true)
	public List<T> findByCriteria(List<Criterion> criterions, Integer maxResults, String... fetchProperties) {
		return dao.findByCriteria(criterions, maxResults, fetchProperties);
	}
	
	@Transactional(readOnly = true)
	public List<T> findAll() {
		return dao.findAll();
	}

	@Transactional(readOnly = true)
	public List<T> findAll(Integer maxResults) {
		return dao.findAll(maxResults);
	}

	@Transactional(readOnly = false)
	public T findById(ID id, boolean exclusiveLock, String... fetchProperties) {
		return dao.findById(id, exclusiveLock, fetchProperties);
	}
	
	@Transactional(readOnly = true)
	public T findById(ID id, String... fetchProperties) {
		return dao.findById(id, fetchProperties);
	}

	@Transactional(readOnly = true)
	public List<T> findByName(String name, String... fetchProperties) {
		return dao.findByName(name, fetchProperties);
	}

	@Transactional(readOnly = true)
	public List<T> findByName(String name, Integer maxResults, String... fetchProperties) {
		return dao.findByName(name, maxResults, fetchProperties);
	}

	@Transactional(readOnly = true)
	public List<T> findByName(String name, MatchMode matchMode, String... fetchProperties) {
		return dao.findByName(name, matchMode, fetchProperties);
	}

	@Transactional(readOnly = true)
	public List<T> findByName(String name, MatchMode matchMode, Integer maxResults, String... fetchProperties) {
		return dao.findByName(name, matchMode, maxResults, fetchProperties);
	}

	@Transactional(readOnly = false)
	public ID create(T entity) {
		return dao.create(entity);
	}

	@Transactional(readOnly = false)
	public T update(T entity) {
		return dao.update(entity);
	}

	@Transactional(readOnly = false)
	public void delete(T entity) {
		dao.delete(entity);
	}

	@Transactional(readOnly = false)
	public void deleteById(ID id) {
		dao.deleteById(id);
	}

}
