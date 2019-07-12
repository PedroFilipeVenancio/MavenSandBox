package com.everis.academia.java.agenda.digital.dao.TipoServico;

import java.util.Collection;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.everis.academia.java.agendadigital.entity.TipoServico;
@Repository
public class TipoServicoHibernateDAO implements ITipoServicoDAO {

	@Autowired
	private SessionFactory sessionFactory;
	

	@Override
	public void delete(TipoServico var) {
		Session session = sessionFactory.getCurrentSession();
		TipoServico tipoServico = session.get(TipoServico.class, var.getCodigo());
		session.delete(tipoServico);
	}

	@Override
	public void update(TipoServico var) {
		Session session = sessionFactory.getCurrentSession();
		session.update(var);
		session.flush();
	}

	@Override
	public void create(TipoServico var) {
		System.out.println("estou no dao" + var.getCodigo());
		Session session = sessionFactory.getCurrentSession();
		session.save(var);
		session.flush();

	}

	@Override
	public Collection<TipoServico> read() {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(TipoServico.class);
		return criteria.list();
	}

	@Override
	public Boolean jaExiste(TipoServico var) {
		Session session = sessionFactory.getCurrentSession();

		Criteria criteria = session.createCriteria(TipoServico.class);
//		Restrictions é o mesmo que WHERE em SQL
		criteria.add(Restrictions.and(
						Restrictions.eq("codigo", var.getCodigo()),
						Restrictions.or(
								Restrictions.isNotNull("codigo"), 
								Restrictions.ne("codigo", var.getCodigo()))));

		criteria.setProjection(Projections.count("codigo"));
		System.out.println("contagem:" + criteria.uniqueResult());
		return (Long) criteria.uniqueResult() > 0;
	}

}
