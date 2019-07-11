package com.everis.academia.java.agenda.digital.dao.TipoServico;

import java.util.Collection;
import java.util.HashSet;

import com.everis.academia.java.agenda.digital.dao.IGeralDAO;
import com.everis.academia.java.agendadigital.entity.TipoServico;

public class TipoServicoDAO implements ITipoServicoDAO {
	
//	public static List<TipoServico> TipoServicos = new ArrayList<TipoServico>();
	public static Collection<TipoServico> tipoServicosColl = new HashSet<TipoServico>();

	private static int id = 0;

	@Override
	public void delete(TipoServico tipoServicoVar) {
		tipoServicosColl.remove(tipoServicoVar);
	}

	@Override
	public void update(TipoServico tipoServicoVar) {
		tipoServicosColl.remove(tipoServicoVar);
		tipoServicosColl.add(tipoServicoVar);
	}

	@Override
	public void create(TipoServico tipoServicoVar) {
		id++;
		tipoServicoVar.setCodigo(id);
		tipoServicosColl.add(tipoServicoVar);	
	}


	@Override
	public Boolean jaExiste(TipoServico tipoServicoVar) {
		
		for (TipoServico tipoServico : tipoServicosColl) {
			if (tipoServico.getCodigo().equals(tipoServicoVar.getCodigo())) {
				return Boolean.TRUE;
			}
		}
		return Boolean.FALSE;
	}

	@Override
	public Collection<TipoServico> read() {
		return tipoServicosColl;
	}

}


