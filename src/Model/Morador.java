package Model;

import java.util.Date;

public class Morador extends Pessoa {

	private String bloco;

	private int nApt;

	private int codEstacionamento;

	public Morador(String nome, String cpf, String rg, Date dtNasc, int nApt, int codEstacionamento,
			String bloco) throws Exception {				
		try {
			this.setNome(nome);
			this.setCpf(cpf);		
			this.setDtNascimento(dtNasc);
			this.setRg(rg);
			this.setBloco(bloco);
			this.setnApt(nApt);
			this.setCodEstacionamento(codEstacionamento);	
		} catch (Exception e) {
			throw e;
		}		
	}

	public int getCodEstacionamento() {
		return this.codEstacionamento;
	}

	public void setCodEstacionamento(int codEstacionamento) {
		this.codEstacionamento = codEstacionamento;
	}

	public int getnApt() {
		return this.nApt;
	}

	public void setnApt(int nApt) {
		this.nApt = nApt;
	}

	public String getBloco() {
		return this.bloco.concat(bloco).concat(" ");
	}

	public void setBloco(String bloco) {
		this.bloco = bloco;
	}
}
