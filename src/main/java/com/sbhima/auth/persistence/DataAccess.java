package com.sbhima.auth.persistence;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class DataAccess {

	private static final Logger logger = Logger.getLogger(DataAccess.class);
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("rawtypes")
	public List executeNativeSQL(StringBuilder query) throws Exception {
		List list = new ArrayList();
		try {
			Session session = sessionFactory.getCurrentSession();
			Query q = session.createSQLQuery(query.toString());
			list = q.list();
		} catch (Exception e) {
			logger.error("Error while executing query:" + query + ",", e);
			throw e;
		}
		return list;
	}

	public <T> T save(T t) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.save(t);
		} catch (Exception e) {
			logger.error("Error while saving object:", e);
			throw e;
		}
		return t;
	}

	public <T> T saveOrUpdate(T t) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.saveOrUpdate(t);
		} catch (Exception e) {
			logger.error("Error while saving object:", e);
			throw e;
		}
		return t;
	}

	@SuppressWarnings("rawtypes")
	public Object loadById(Class t, Serializable id) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		Object obj = null;
		try {
			obj = session.get(t, id);
		} catch (Exception e) {
			logger.error("Error while saving object:", e);
			throw e;
		}
		return obj;
	}

	@SuppressWarnings("rawtypes")
	public List queryWithParams(StringBuffer query,
			Map<String, Object> parameters) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		List list = null;
		try {
			Query queryObj = session.createQuery(query.toString());

			if (parameters != null) {
				for (String param : parameters.keySet()) {
					if (parameters.get(param) instanceof Collection) {
						queryObj.setParameterList(param,
								(Collection) parameters.get(param));
					} else {
						queryObj.setParameter(param, parameters.get(param));
					}
				}
			}

			list = queryObj.list();
		} catch (Exception e) {
			logger.error("Error while loading object:", e);
			throw e;
		}
		return list;
	}
}
