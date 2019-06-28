package Entity;



//@Entity
//@Table(name="telefone")
public class Telefone {
	
	
	
//	@Id
//	@Column(name="id")
	private Integer codigo;
		
//	@Column(name="ddd")
	private Integer ddd;
	
//	@Column(name="numero")
	private Integer numero;
	

	public Telefone(Integer codigo, Integer ddd, Integer numero) {
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

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
	
	
	
	
	
}