package Entity;

import Enums.Estado;
import Enums.TipoLogradouro;

public class PrestadorServico {
	
//	@Id
//	@Column(name="id")
	private Integer codigo;
		
//	@Column(name="nome")
	private String nome;
	
//	@Column(name="cidade")
	private Cidade cidade;
	
//	@Column(name="bairro")
	private String bairro;
	
//	@Column(name="cep")
	private String cep;
	
//	@Column(name="tipoLogradouro")
	private TipoLogradouro tipoLogradouro;
	
//	@Column(name="logradouro")
	private String logradouro;
	
//	@Column(name="complemento")
	private String complemento;
	
//	@Column(name="numero")
	private String numero;
	
//	@Column(name="email")
	private String email;
	
	

	public PrestadorServico(Integer codigo, String nome, Cidade cidade, String bairro, String cep,
		TipoLogradouro tipoLogradouro, String logradouro, String complemento, String numero, String email) {
	super();
	this.codigo = codigo;
	this.nome = nome;
	this.cidade = cidade;
	this.bairro = bairro;
	this.cep = cep;
	this.tipoLogradouro = tipoLogradouro;
	this.logradouro = logradouro;
	this.complemento = complemento;
	this.numero = numero;
	this.email = email;
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

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public TipoLogradouro getTipoLogradouro() {
		return tipoLogradouro;
	}

	public void setTipoLogradouro(TipoLogradouro tipoLogradouro) {
		this.tipoLogradouro = tipoLogradouro;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
