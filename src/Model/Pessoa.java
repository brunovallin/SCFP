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
		return this.id;
	}	

	public void setId(final int id) {
		this.id = id;
	}

	public String getDocumento() {		
		return this.documento;
	}

	public void setDocumento(String documento) throws Exception{
		if(documento.length() != 11 || documento.length() != 14){
			throw new Exception("Documento Inválido!");
		}

		if(documento.length() == 11){
			this.setTipoPessoa(TipoPessoa.FISICA);
		}			
		else if(documento.length() == 14)
			this.setTipoPessoa(TipoPessoa.JURIDICA);
		this.documento = documento;
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

	public void setNome(final String nome) throws Exception{	
		if(nome.isEmpty())
			throw new Exception("Nome não preenchido!");				
		this.nome = nome;					
	}

	public TipoPessoa getTipoPessoa() {
		return this.tipoPessoa;
	}

	public void setTipoPessoa(final TipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}
}