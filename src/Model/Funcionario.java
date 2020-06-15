package Model;

import java.util.ArrayList;
import Enum.TipoFuncionario;
import Model.DAO.DAOFuncionario;

public class Funcionario extends Pessoa {

	private TipoFuncionario tipoFuncionario;	

	public TipoFuncionario getTipoFuncionario() {
		return tipoFuncionario;
	}

	public void setTipoFuncionario(TipoFuncionario tipoFuncionario) {
		this.tipoFuncionario = tipoFuncionario;
	}	

	public void consultarFuncionario(String cpf) throws Exception {
		try {
			Funcionario fun = DAOFuncionario.consultarFuncionario(cpf);
			this.setId(fun.getId());
			this.setNome(fun.getNome());
			this.setDtNascimento(fun.getDtNascimento());
			this.setRg(fun.getRg());
			this.setTipoFuncionario(fun.getTipoFuncionario());	
		} catch (Exception e) {
			throw e;
		}					
	}

	public static ArrayList<Funcionario> consultarFuncionarios() throws Exception{
		try {
			return DAOFuncionario.consultarFuncionarios();
		} catch (Exception e) {
			throw e;
		}
	}
	
	public void cadastrarFuncionario() throws Exception{
		try {
			DAOFuncionario.cadastrarFuncionario(this);
		} catch (Exception e) {
			throw e;
		}
	}

	public void alterarFuncionario() throws Exception{
		try {
			DAOFuncionario.alterarFuncionario(this);
		} catch (Exception e) {
			throw e;
		}
	}

	public static void excluirFuncionario(int id) throws Exception{
		try {
			DAOFuncionario.excluirFuncionario(id);
		} catch (Exception e) {
			throw e;
		}
	}
}
