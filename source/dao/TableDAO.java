package dao;

import org.springframework.stereotype.Repository;

import base.AbstractHibernateDAO;
import object.Table;

@Repository
public class TableDAO extends AbstractHibernateDAO<Table, String> {

}