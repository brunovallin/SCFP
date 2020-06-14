package Model;

import java.util.ArrayList;
import java.util.Date;

import Model.DAO.DAOMorador;

public class Morador extends Pessoa {

	private String bloco;

	private int nApt;

	private int codEstacionamento;

	public Morador(){

	}

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

	public void consultarMorador(String cpf) throws Exception {
		try {
			Morador morador = DAOMorador.consultarMorador(cpf);
			this.setId(morador.getId());
			this.setNome(morador.getNome());
			this.setDtNascimento(morador.getDtNascimento());
			this.setCpf(morador.getCpf());
			this.setRg(morador.getRg());			
			this.setBloco(morador.getBloco());	
			this.setnApt(morador.getnApt());
			this.setCodEstacionamento(morador.getCodEstacionamento());
		} catch (Exception e) {
			throw e;
		}					
	}


	public static ArrayList<Morador> consultarMoradores() throws Exception{
		try {
			return DAOMorador.consultarMoradores();
		} catch (Exception e) {
			throw e;
		}
	}
	
	public void cadastrarMorador() throws Exception{
		try {
			DAOMorador.cadastrarMorador(this);
		} catch (Exception e) {
			throw e;
		}
	}

	public void alterarMorador() throws Exception{
		try {
			DAOMorador.alterarMorador(this);
		} catch (Exception e) {
			throw e;
		}
	}

	public void excluirMorador() throws Exception{
		try {
			DAOMorador.excluirMorador(this.getId());
		} catch (Exception e) {
			throw e;
		}
	}
	
}
