package Model;

import Enum.*;

public class Funcionario extends Pessoa {

	private int id;

	private double salario;

	private TipoFuncionario tipoFuncionario;
	
	

	public TipoFuncionario getTipoFuncionario() {
		return tipoFuncionario;
	}

	public void setTipoFuncionario(TipoFuncionario tipoFuncionario) {
		this.tipoFuncionario = tipoFuncionario;
	}

	public double getSalario() {
		return this.salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;		
	}

}
