package Entity;

import Entity.PrestadorServico;

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
	
	
	
	
	
}