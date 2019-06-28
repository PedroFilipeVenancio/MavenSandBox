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
}
