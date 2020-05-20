package Model;

import java.util.Date;

import Enum.TipoPessoa;

public class Pessoa {

	private int id;

	private String nome;

	private Date dtNascimento;

	private String documento;

	private String rg;

	private TipoPessoa tipoPessoa;

	public Pessoa() {
		
	}	

	public int getId() {
		return id;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return documento;
	}

	public void setCpf(String cpf) {
		this.documento = cpf;
	}

	public Date getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setId(int id) {
		this.id = id;
	}

	public TipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(TipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}
}
