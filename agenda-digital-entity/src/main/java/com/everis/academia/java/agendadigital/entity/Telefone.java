package com.everis.academia.java.agendadigital.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "TB_TELEFONE", schema = "public")
//@Table(name = "TB_TELEFONE",schema = "public", uniqueConstraints = { @UniqueConstraint(name = "UNQ_TELEFONE", columnNames = {
//		"COD_PRESTADOR_SERVICO", "DDD_TELEFONE", "NUM_TELEFONE" }) })
@SequenceGenerator(name = "SQ_TELEFONE", sequenceName = "SQ_TELEFONE", initialValue = 1, allocationSize = 1)
//@JsonIgnoreProperties(value = { "prestadorServico" })
public class Telefone {

	@Id
	@Column(name = "COD_TELEFONE")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_TELEFONE")
	private Integer codigo;

	@Column(name = "DDD_TELEFONE", nullable = true)
	private Integer ddd;

	@Column(name = "NUM_TELEFONE", nullable = false)
	private Integer numero;

	@ManyToOne(fetch = FetchType.LAZY, targetEntity = PrestadorServico.class)
	@JoinColumn(name = "COD_PRESTADOR_SERVICO", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "FK_TB_TELEF_TB_PRESTADOR_SERV"))
	private PrestadorServico prestadorServico;


	public Telefone(Integer codigo) {
		super();
		this.codigo = codigo;
	}

	public Telefone(Integer codigo, Integer ddd, Integer numero) {
		super();
		this.codigo = codigo;
		this.ddd = ddd;
		this.numero = numero;
	}

	public Telefone(Integer ddd, Integer numero) {
		super();
		this.ddd = ddd;
		this.numero = numero;
	}

	public Integer getDdd() {
		return ddd;
	}

	public void setDdd(Integer ddd) {
		this.ddd = ddd;
	}

	public Telefone() {
		super();
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}
//	@JsonIgnore
	public PrestadorServico getPrestadorServico() {
		return prestadorServico;
	}
//	@JsonIgnore
	public void setPrestadorServico(PrestadorServico prestadorServico) {
		this.prestadorServico = prestadorServico;
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
		Telefone other = (Telefone) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}


}