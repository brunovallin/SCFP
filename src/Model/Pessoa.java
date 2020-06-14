package Model;

import java.util.Date;

public class Pessoa {

	private int id;

	private String nome;

	private Date dtNascimento;

	private String rg;

	public Pessoa() {
	}	

	public int getId() {
		return this.id;
	}	

	public void setId(int id) {
		this.id = id;
	}

	public Date getDtNascimento() {
		return this.dtNascimento;
	}

	public void setDtNascimento(Date dtNascimento) throws Exception {		
		if(dtNascimento.getYear() > 1900)
			throw new Exception("Data de nascimento Inválida");
		this.dtNascimento = dtNascimento;			
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) throws Exception{	
		if(nome.isEmpty())
			throw new Exception("Nome não preenchido!");				
		this.nome = nome;					
	}

	public String getRg() {
		return this.rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}
}