package Entity;

import java.util.Set;

import Enums.Estado;
import Enums.TipoLogradouro;
import Entity.Telefone;
import Entity.TipoServico;

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

	private Set<Telefone> telefones;

	private Set<TipoServico> tiposServicos;

	private Set<PrestacaoServico> prestacoesServicos;

	public PrestadorServico(Integer codigo) {
		super();
		this.codigo = codigo;
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

	public Set<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(Set<Telefone> telefones) {
		this.telefones = telefones;
	}

	public Set<TipoServico> getTiposServicos() {
		return tiposServicos;
	}

	public void setTiposServicos(Set<TipoServico> tiposServicos) {
		this.tiposServicos = tiposServicos;
	}

	public Set<PrestacaoServico> getPrestacoesServicos() {
		return prestacoesServicos;
	}

	public void setPrestacoesServicos(Set<PrestacaoServico> prestacoesServicos) {
		this.prestacoesServicos = prestacoesServicos;
	}

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
		PrestadorServico other = (PrestadorServico) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	

}
