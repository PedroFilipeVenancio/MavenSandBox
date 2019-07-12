package com.everis.academia.java.agenda.digital.dao.PrestadorServicos;

import java.util.Collection;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.everis.academia.java.agendadigital.entity.PrestadorServico;
@Repository
public class PrestadorServicoHibernateDAO implements IPrestadorServicoDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void delete(PrestadorServico var) {
		Session session = sessionFactory.getCurrentSession();
		PrestadorServico prestadorServico = session.get(PrestadorServico.class, var.getCodigo());
		session.delete(prestadorServico);
	}

	@Override
	public void update(PrestadorServico var) {
		Session session = sessionFactory.getCurrentSession();
		session.update(var);
		session.flush();
	}

	@Override
	public void create(PrestadorServico var) {
		Session session = sessionFactory.getCurrentSession();
		session.save(var);
		session.flush();

	}

	@Override
	public Collection<PrestadorServico> read() {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(PrestadorServico.class);
		return criteria.list();
	}

	@Override
	public Boolean jaExiste(PrestadorServico var) {
		Session session = sessionFactory.getCurrentSession();

		Criteria criteria = session.createCriteria(PrestadorServico.class);
//		Restrictions é o mesmo que WHERE em SQL
		criteria.add(Restrictions.and(
						Restrictions.eq("nome", var.getNome()).ignoreCase(),
						Restrictions.or(
								Restrictions.isNotNull("codigo"), 
								Restrictions.ne("codigo", var.getCodigo()))));

		criteria.setProjection(Projections.count("codigo"));

		return (Long) criteria.uniqueResult() > 0;
	}

}
