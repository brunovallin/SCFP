package Model;

import Enum.*;

public class Funcionario extends Pessoa {

	private TipoFuncionario tipoFuncionario;	

	public TipoFuncionario getTipoFuncionario() {
		return tipoFuncionario;
	}

	public void setTipoFuncionario(TipoFuncionario tipoFuncionario) {
		this.tipoFuncionario = tipoFuncionario;
	}	
}
