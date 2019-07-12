package com.everis.academia.java.agendadigital.entity;

import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_TELEFONE", schema = "public")
@SequenceGenerator(name = "SQ_TELEFONE", sequenceName = "SQ_TELEFONE", initialValue = 1, allocationSize = 1)
public class Telefone {
	
	@Id
	@Column(name = "COD_TELEFONE")
	private Integer codigo;
		
//	@Column(name = "DDD_TELEFONE", nullable = false)
//	private Integer ddd;
	
	@Column(name = "NUM_TELEFONE", nullable = false)
	private Byte numero;
	
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = PrestadorServico.class)
	@JoinColumn(name = "COD_PRESTADOR_SERVICO", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "FK_TB_TELEF_TB_PRESTADOR_SERV"))
	private PrestadorServico prestadorServico;
	
	public Telefone(Integer codigo) {
	super();
	this.codigo = codigo;
}

//	public Telefone(Integer codigo, Integer ddd, Byte numero) {
//	super();
//	this.codigo = codigo;
//	this.ddd = ddd;
//	this.numero = numero;
//}
	
	public Telefone(Integer codigo,  Byte numero) {
	super();
	this.codigo = codigo;
	this.numero = numero;
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

	public Byte getNumero() {
		return numero;
	}

	public void setNumero(Byte numero) {
		this.numero = numero;
	}
	
	public PrestadorServico getPrestadorServico() {
		return prestadorServico;
	}

	public void setPrestadorServico(PrestadorServico prestadorServico) {
		this.prestadorServico = prestadorServico;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
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
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		return true;
	}
	
	
	
	
	
}