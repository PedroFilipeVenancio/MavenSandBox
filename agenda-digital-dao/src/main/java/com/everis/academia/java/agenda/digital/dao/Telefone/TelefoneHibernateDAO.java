package com.everis.academia.java.agenda.digital.dao.Telefone;

import java.util.Collection;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.everis.academia.java.agendadigital.entity.Telefone;
@Repository
public class TelefoneHibernateDAO implements ITelefoneDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void delete(Telefone var) {
		Session session = sessionFactory.getCurrentSession();
		Telefone telefone = session.get(Telefone.class, var.getCodigo());
		session.delete(telefone);
	}

	@Override
	public void update(Telefone var) {
		Session session = sessionFactory.getCurrentSession();
		session.update(var);
		session.flush();
	}

	@Override
	public void create(Telefone var) {
		Session session = sessionFactory.getCurrentSession();
		session.save(var);
		session.flush();

	}

	@Override
	public Collection<Telefone> read() {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Telefone.class);
		return criteria.list();
	}

	@Override
	public Boolean jaExiste(Telefone var) {
		Session session = sessionFactory.getCurrentSession();

		Criteria criteria = session.createCriteria(Telefone.class);
//		Restrictions é o mesmo que WHERE em SQL
		criteria.add(Restrictions.and(
						Restrictions.eq("codigo", var.getCodigo()),
						Restrictions.or(
								Restrictions.isNotNull("codigo"), 
								Restrictions.ne("codigo", var.getCodigo()))));

		criteria.setProjection(Projections.count("codigo"));

		return (Long) criteria.uniqueResult() > 0;
	}

}
