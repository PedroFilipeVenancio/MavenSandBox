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
//	private Estado estado;
	
	public Cidade() {
	}
	
	public Cidade(Integer codigo) {
		super();
		this.codigo = codigo;
//		this.nome = nome;
//		this.estado = estado;
	}
	
	public Cidade(String nome) {
		super();
		this.nome = nome;
//		this.nome = nome;
//		this.estado = estado;
	}

	public Cidade(Integer codigo, String nome) {
		super();
		this.codigo = codigo;
		this.nome = nome;
//		this.estado = estado;
	}

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

//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
//		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Cidade other = (Cidade) obj;
//		if (codigo == null) {
//			if (other.codigo != null)
//				return false;
//		} else if (!codigo.equals(other.codigo))
//			return false;
//		if (nome == null) {
//			if (other.nome != null)
//				return false;
//		} else if (!nome.equals(other.nome))
//			return false;
//		return true;
//	}

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
		Cidade other = (Cidade) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	

//	public Estado getEstado() {
//		return estado;
//	}
//
//	public void setEstado(Estado estado) {
//		this.estado = estado;
//	}
	
	
	
	

}


