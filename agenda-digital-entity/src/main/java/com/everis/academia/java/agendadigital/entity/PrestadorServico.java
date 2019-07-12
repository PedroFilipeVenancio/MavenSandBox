package com.everis.academia.java.agendadigital.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import Enums.TipoLogradouro;
//@Entity
//@Table(name = "TB_PRESTADOR_SERVICO")
//@SequenceGenerator(name = "SQ_PRESTADOR_SERVICO", sequenceName = "SQ_PRESTADOR_SERVICO", initialValue = 1, allocationSize = 1)
public class PrestadorServico {

//	@Id()
//	@Column(name = "COD_PRESTADOR_SERVICO")
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PRESTADOR_SERVICO")
	private Integer codigo;

//	@Column(name = "NOM_PRESTADOR_SERVICO", length = 100, nullable = false)
	private String nome;

//	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Cidade.class)
//	@JoinColumn(name = "COD_CIDADE", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "FK_TB_PRESTADOR_SERV_TB_CIDADE"))
	private Cidade cidade;

//	@Column(name = "NOM_BAIRRO", length = 50, nullable = false)
	private String bairro;

//	@Column(name = "NUM_CEP", length = 10, nullable = true)
	private String cep;

//	@Column(name = "TIP_LOGRADOURO", length = 10, nullable = false)
//	@Enumerated(EnumType.STRING)
	private TipoLogradouro tipoLogradouro;

//	@Column(name = "DES_LOGRADROURO", length = 100, nullable = false)
	private String logradouro;

//	@Column(name = "DES_COMPLEMENTO", length = 200, nullable = true)
	private String complemento;

//	@Column(name = "NUMERO", nullable = false)
	private String numero;

//	@Column(name = "DES_EMAIL", length = 80, nullable = true)
	private String email;

//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "prestadorServico", orphanRemoval = true, targetEntity = Telefone.class)
	private Set<Telefone> telefones;

//	@ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER, targetEntity = TipoServico.class)
//	@JoinTable(name = "RL_SERVICO_CREDENCIADO", joinColumns = {
//			@JoinColumn(name = "COD_PRESTADOR_SERVICO") }, inverseJoinColumns = {
//					@JoinColumn(name = "COD_TIPO_SERVICO") })
	private Set<TipoServico> tiposServicos;
	
//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "prestadorServico", orphanRemoval = true, targetEntity = PrestacaoServico.class)
	private Set<PrestacaoServico> prestacoesServicos;

	public PrestadorServico(Integer codigo) {
		super();
		this.codigo = codigo;
	}
	
	

	public PrestadorServico() {
		super();
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
