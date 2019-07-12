package com.everis.academia.java.agenda.digital.dao.ServicoPrestado;

import java.util.Collection;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.everis.academia.java.agendadigital.entity.ServicoPrestado;
@Repository
public class ServicoPrestadoHibernateDAO implements IServicoPrestadoDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void delete(ServicoPrestado var) {
		Session session = sessionFactory.getCurrentSession();
		ServicoPrestado servicoPrestado = session.get(ServicoPrestado.class, var.getCodigo());
		session.delete(servicoPrestado);
	}

	@Override
	public void update(ServicoPrestado var) {
		Session session = sessionFactory.getCurrentSession();
		session.update(var);
		session.flush();
	}

	@Override
	public void create(ServicoPrestado var) {
		Session session = sessionFactory.getCurrentSession();
		session.save(var);
		session.flush();

	}

	@Override
	public Collection<ServicoPrestado> read() {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(ServicoPrestado.class);
		return criteria.list();
	}

	@Override
	public Boolean jaExiste(ServicoPrestado var) {
		Session session = sessionFactory.getCurrentSession();

		Criteria criteria = session.createCriteria(ServicoPrestado.class);
//		Restrictions é o mesmo que WHERE em SQL
		criteria.add(Restrictions.and(
						Restrictions.eq("nome", var.getCodigo()).ignoreCase(),
						Restrictions.or(
								Restrictions.isNotNull("codigo"), 
								Restrictions.ne("codigo", var.getCodigo()))));

		criteria.setProjection(Projections.count("codigo"));

		return (Long) criteria.uniqueResult() > 0;
	}

}
