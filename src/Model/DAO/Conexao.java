package Model.DAO;

import java.sql.*;

public class Conexao {
    private Connection conexao = null;
	private boolean status;
	
	public boolean getStatus() {
		return this.status;
	}
	
	public Conexao() {
	}
	
	public Connection getConexaoMySQL() throws ClassNotFoundException {	 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetopoo?useTimezone=true&serverTimezone=UTC", "root", "Mayfire.861");
			status = true;
		} catch (final SQLException e) {
			status = false;
			return null;
		}		
		return this.conexao;
	}
	
	public boolean fecharConexao() {
		try {
			if(this.conexao != null) {
				this.conexao.close();
				return true;	
			}
			else
				return false;
		} catch (final SQLException e) { 
			return false;
		}
	}
	
	public boolean statusConexao() {
		return this.status;
	}
}