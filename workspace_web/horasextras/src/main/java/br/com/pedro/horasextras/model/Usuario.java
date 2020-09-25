package br.com.pedro.horasextras.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity 							// é uma entidade armazenavel em banco, ou seja ele vai criar automaticamente.
@Table(name = "itmn232_usuario") 		/// aqui eu escifico o nome da tabela
public class Usuario { 					// As anotações da classe correspondem a tabela

											/// as notações dos atributos correspondem as colunas
	@Id 												// Atributo é primary key
	@Column(name = "id_usuario") 							// defino o nome da coluna
	@GeneratedValue(strategy = GenerationType.IDENTITY) // especifico genericamente um auto
	private int id;

	@Column(name = "nome_usuario", length = 100)
	private String nome;
	@Column(name = "email_usuario", length = 100, unique = true)
	private String email;
	@Column(name = "racf", length = 7, unique = true)
	private String racf;
	@Column(name = "senha", length = 50)
	private String senha;
	@Column(name = "link_foto", length = 255)
	private String linkfoto;
	@Column(name = "gestor_usuario")
	private int gestor;
	
	@OneToMany(mappedBy="colaborador", cascade=CascadeType.ALL)
	@JsonIgnoreProperties("colaborador")
	private List<Ocorrencia> listaOcorencias;
	

	public List<Ocorrencia> getListaOcorencias() {
		return listaOcorencias;
	}

	public void setListaOcorencias(List<Ocorrencia> listaOcorencias) {
		this.listaOcorencias = listaOcorencias;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRacf() {
		return racf;
	}

	public void setRacf(String racf) {
		this.racf = racf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getLinkfoto() {
		return linkfoto;
	}

	public void setLinkfoto(String linkfoto) {
		this.linkfoto = linkfoto;
	}

	public int getGestor() {
		return gestor;
	}

	public void setGestor(int gestor) {
		this.gestor = gestor;
	}
	
	

}
