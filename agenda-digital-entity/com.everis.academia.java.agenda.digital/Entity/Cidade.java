package Entity;

import Enums.Estado;

//@Entity
//@Table(name="cidade")
public class Cidade {
	
//	@Id
//	@Column(name="id")
	private Integer codigo;
		
//	@Column(name="nome")
	private String nome;
	
//	@Column(name="estado")
	private Estado estado;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

}


