package Entity;

//@Entity
//@Table(name="tipoServico")
public class TipoServico {
	
//	@Id
//	@Column(name="id")
	private Integer codigo;
		
//	@Column(name="descricao")
	private String descricao;
	
	

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
	
	
}