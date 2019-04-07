package com.dtb.jdbc.model;
// Generated Apr 6, 2019 9:59:01 PM by Hibernate Tools 3.4.0.CR1

import java.io.File;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.query.Query;

/**
 * Home object for domain model class Cliente.
 * @see com.dtb.jdbc.model.Cliente
 * @author Hibernate Tools
 */
public class ClienteDao {

	private static final Log log = LogFactory.getLog(ClienteDao.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		return new Configuration()
				.configure(new File("src/META-INF/hibernate.cfg.xml"))
				.buildSessionFactory();
	}

	public void persist(Cliente transientInstance) {
		log.debug("persisting Cliente instance");
		try {
			sessionFactory.getCurrentSession().beginTransaction();
			sessionFactory.getCurrentSession().persist(transientInstance);
			sessionFactory.getCurrentSession().getTransaction().commit();
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void delete(Cliente persistentInstance) {
		log.debug("deleting Cliente instance");
		try {
			sessionFactory.getCurrentSession().beginTransaction();
			sessionFactory.getCurrentSession().delete(persistentInstance);
			sessionFactory.getCurrentSession().getTransaction().commit();
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Cliente merge(Cliente detachedInstance) {
		log.debug("merging Cliente instance");
		try {
			sessionFactory.getCurrentSession().beginTransaction();
			Cliente result = (Cliente) sessionFactory.getCurrentSession().merge(detachedInstance);
			sessionFactory.getCurrentSession().getTransaction().commit();
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Cliente findById(long id) {
		log.debug("getting Cliente instance with id: " + id);
		try {
			sessionFactory.getCurrentSession().beginTransaction();
			Cliente instance = (Cliente) sessionFactory.getCurrentSession().get("com.dtb.jdbc.model.Cliente", id);
			sessionFactory.getCurrentSession().getTransaction().commit();
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	public Cliente findByCpf(String cpf) {
		log.debug("getting Cliente instance with id: " + cpf);
		try {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			Query<Cliente> query = session.createQuery("from Cliente client where lower(client.cpf) = '"+cpf+"'");
			Cliente instance = query.getSingleResult();
			session.getTransaction().commit();
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
