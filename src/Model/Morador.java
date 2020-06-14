package Model;

import java.util.Date;

public class Morador extends Pessoa {

	private int idMorador;

	private String rg;

	private int nContrato;

	private String bloco;

	private int nApt;

	private int complemento;

	private int codEstacionamento;

	public Morador(String nome, String cpf, String rg, Date dtNasc, int nContrato, int nApt, int codEstacionamento,
			String bloco) throws Exception {				
		try {
			this.setNome(nome);
			this.setCpf(cpf);		
			this.setDtNascimento(dtNasc);
			this.setRg(rg);
			this.setnContrato(nContrato);
			this.setBloco(bloco);
			this.setnApt(nApt);
			this.setCodEstacionamento(codEstacionamento);	
		} catch (Exception e) {
			throw e;
		}		
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public int getCodEstacionamento() {
		return codEstacionamento;
	}

	public void setCodEstacionamento(int codEstacionamento) {
		this.codEstacionamento = codEstacionamento;
	}

	public int getComplemento() {
		return complemento;
	}

	public void setComplemento(int complemento) {
		this.complemento = complemento;
	}

	public int getnApt() {
		return nApt;
	}

	public void setnApt(int nApt) {
		this.nApt = nApt;
	}

	public String getBloco() {
		return bloco.concat(bloco).concat(" ");
	}

	public void setBloco(String bloco) {
		this.bloco = bloco;
	}

	public int getIdMorador() {
		return idMorador;
	}

	public void setIdMorador(int idMorador) {
		this.idMorador = idMorador;
	}

	public int getnContrato() {
		return nContrato;
	}

	public void setnContrato(int nContrato) {
		this.nContrato = nContrato;		
	}

}