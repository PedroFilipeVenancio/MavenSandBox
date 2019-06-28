package Entity;

import java.util.Date;

//@Entity
//@Table(name="prestacaoServico")
public class PrestacaoServico {
	
//	@Id
//	@Column(name="id")
	private Integer codigo;
		
//	@Column(name="data")
	private Date data;
	
//	@Column(name="prestador")
	private PrestadorServico prestador;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public PrestadorServico getPrestador() {
		return prestador;
	}

	public void setPrestador(PrestadorServico prestador) {
		this.prestador = prestador;
	}
	
	
}