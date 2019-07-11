package com.everis.academia.java.agenda.digital.dao.Cidade;

import java.util.Collection;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.everis.academia.java.agendadigital.entity.Cidade;
@Repository
public class CidadeHibernateDAO implements ICidadeDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void delete(Cidade var) {
		Session session = sessionFactory.getCurrentSession();
		Cidade cidade = session.get(Cidade.class, var.getCodigo());
		session.delete(cidade);
	}

	@Override
	public void update(Cidade var) {
		Session session = sessionFactory.getCurrentSession();
		session.update(var);
		session.flush();
	}

	@Override
	public void create(Cidade var) {
		Session session = sessionFactory.getCurrentSession();
		session.save(var);
		session.flush();

	}

	@Override
	public Collection<Cidade> read() {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Cidade.class);
		return criteria.list();
	}

	@Override
	public Boolean jaExiste(Cidade cidade) {
		Session session = sessionFactory.getCurrentSession();

		Criteria criteria = session.createCriteria(Cidade.class);
//		Restrictions é o mesmo que WHERE em SQL
		criteria.add(Restrictions.and(
						Restrictions.eq("nome", cidade.getNome()).ignoreCase(),
//						Restrictions.eq("estado", cidade.getEstado(),
						Restrictions.or(
								Restrictions.isNotNull("codigo"), 
								Restrictions.ne("codigo", cidade.getCodigo()))));

		criteria.setProjection(Projections.count("codigo"));

		return (Long) criteria.uniqueResult() > 0;
	}

}
