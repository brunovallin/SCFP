package Model;

import java.util.Date;

import Enum.TipoPessoa;

public class Pessoa {

	private int id;

	private String nome;

	private Date dtNascimento;

	private String documento;

	private TipoPessoa tipoPessoa;

	public Pessoa() {				
	}

	public int getId() {
		return id;
	}	

	public void setId(final int id) {
		this.id = id;
	}

	public String getCpf() {		
		return documento;
	}

	public void setCpf(final String documento) {
		if(documento.length() == 11)
			this.setTipoPessoa(TipoPessoa.FISICA);
		else if(documento.length() == 14)
			this.setTipoPessoa(TipoPessoa.JURIDICA);
		this.documento = documento;
	}

	public Date getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(final Date dtNascimento) throws Exception {
		try {
			if(dtNascimento.getYear() > 1900)
				throw new Exception("Data de nascimento Inválida");
			this.dtNascimento = dtNascimento;	
		} catch (final Exception e) {
			throw e;
		}		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(final String nome) throws Exception{
		try {
			if(nome.isEmpty())
				throw new Exception("Nome não preenchido!");				
			this.nome = nome;	
		} catch (final Exception e) {
			throw e;
		}
		
	}

	public TipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}

	public void setTipoPessoa(final TipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}
}
