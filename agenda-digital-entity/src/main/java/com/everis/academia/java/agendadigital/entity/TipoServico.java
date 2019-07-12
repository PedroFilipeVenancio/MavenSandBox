package com.everis.academia.java.agendadigital.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


//@Table(name = "TB_TIPO_SERVICO", uniqueConstraints = {
//		@UniqueConstraint(name = "UNQ_TIPO_SERVICO", columnNames = { "NOM_TIPO_SERVICO" }) })
@Entity
@Table(name="TB_TIPO_SERVICO", schema = "public")
@SequenceGenerator(name = "SQ_TIPO_SERVICO", sequenceName = "SQ_TIPO_SERVICO",schema = "public", initialValue = 1, allocationSize = 1)
public class TipoServico implements Serializable{

	@Id
	@GeneratedValue(generator = "SQ_TIPO_SERVICO", strategy = GenerationType.SEQUENCE )
	@Column(name = "COD_TIPO_SERVICO")
	private Integer codigo;

	@Column(name = "DISC_TIPO_SERVICO", length = 100, nullable = false)
	private String descricao;

//	private PrestadorServico prestadorServico;
	
	public TipoServico() {
		super();
	}

	public TipoServico(Integer codigo) {
		super();
		this.codigo = codigo;
	}

	public TipoServico(Integer codigo, String descricao) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipoServico other = (TipoServico) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "TipoServico [codigo=" + codigo + ", descricao=" + descricao + "]";
	}
	
	

}