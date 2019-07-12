package com.everis.academia.java.agenda.digital.dao.PrestacaoServico;

import java.util.Collection;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.everis.academia.java.agendadigital.entity.PrestacaoServico;
@Repository
public class PrestacaoServicoHibernateDAO implements IPrestacaoServicoDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void delete(PrestacaoServico var) {
		Session session = sessionFactory.getCurrentSession();
		PrestacaoServico prestacaoServico = session.get(PrestacaoServico.class, var.getCodigo());
		session.delete(prestacaoServico);
	}

	@Override
	public void update(PrestacaoServico var) {
		Session session = sessionFactory.getCurrentSession();
		session.update(var);
		session.flush();
	}

	@Override
	public void create(PrestacaoServico var) {
		Session session = sessionFactory.getCurrentSession();
		session.save(var);
		session.flush();

	}

	@Override
	public Collection<PrestacaoServico> read() {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(PrestacaoServico.class);
		return criteria.list();
	}

	@Override
	public Boolean jaExiste(PrestacaoServico var) {
		Session session = sessionFactory.getCurrentSession();

		Criteria criteria = session.createCriteria(PrestacaoServico.class);
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
