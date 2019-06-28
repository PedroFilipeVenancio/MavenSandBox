package Entity;

//@Entity
//@Table(name="servicoPrestado")
public class ServicoPrestado {
	
//	@Id
//	@Column(name="prestacaoServico")
	private PrestacaoServico prestacaoServico;
		
//	@Column(name="tipoServico")
	private TipoServico tipoServico;
	
//	@Column(name="valor")
	private Double valor;
	
	

	public ServicoPrestado(PrestacaoServico prestacaoServico, TipoServico tipoServico, Double valor) {
	super();
	this.prestacaoServico = prestacaoServico;
	this.tipoServico = tipoServico;
	this.valor = valor;
}

	public PrestacaoServico getPrestacaoServico() {
		return prestacaoServico;
	}

	public void setPrestacaoServico(PrestacaoServico prestacaoServico) {
		this.prestacaoServico = prestacaoServico;
	}

	public TipoServico getTipoServico() {
		return tipoServico;
	}

	public void setTipoServico(TipoServico tipoServico) {
		this.tipoServico = tipoServico;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
	
}