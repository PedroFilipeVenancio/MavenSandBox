package com.everis.academia.java.agendadigital.entity;

//@Entity
//@Table(name="telefone")
public class Telefone {
	
	
	
//	@Id
//	@Column(name="id")
	private Integer codigo;
		
//	@Column(name="ddd")
	private Integer ddd;
	
//	@Column(name="numero")
	private Byte numero;
	
	private PrestadorServico prestadorServico;
	
	public Telefone(Integer codigo) {
	super();
	this.codigo = codigo;
}

	public Telefone(Integer codigo, Integer ddd, Byte numero) {
	super();
	this.codigo = codigo;
	this.ddd = ddd;
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

	public Integer getDdd() {
		return ddd;
	}

	public void setDdd(Integer ddd) {
		this.ddd = ddd;
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