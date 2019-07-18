package com.everis.academia.java.agenda.digital.dao.PrestadorServicos;

import java.util.Collection;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.everis.academia.java.agendadigital.entity.PrestadorServico;
import com.everis.academia.java.agendadigital.entity.Telefone;
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
		Criteria criteria = session.createCriteria(PrestadorServico.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return criteria.list();
	}
	

	@Override
	public Boolean jaExiste(PrestadorServico var) {
		Session session = sessionFactory.getCurrentSession();

		Criteria criteria = session.createCriteria(PrestadorServico.class);
//		Restrictions é o mesmo que WHERE em SQL
		criteria.add(Restrictions.and(
						Restrictions.or(
						Restrictions.eq("nome", var.getNome()).ignoreCase(),
						Restrictions.eq("email", var.getEmail())),
						Restrictions.or(
								Restrictions.isNotNull("codigo"), 
								Restrictions.ne("codigo", var.getCodigo()))));
//						Restrictions.neOrIsNotNull("codigo", var.getCodigo());	
		
		criteria.setProjection(Projections.count("codigo"));
		return (Long) criteria.uniqueResult() > 0;
	}
	
	@Override
	public Boolean jaExisteTelefone(Telefone var) {
		Session session = sessionFactory.getCurrentSession();

		Criteria criteria = session.createCriteria(Telefone.class);		
		
			criteria.add(Restrictions.and(
					Restrictions.or(
								Restrictions.eq("numero", var.getNumero()),
								Restrictions.eq("ddd", var.getDdd())),
					Restrictions.neOrIsNotNull("codigo", var.getCodigo())));
		
		criteria.setProjection(Projections.count("codigo"));

		return (Long) criteria.uniqueResult() > 0;
	}

}
