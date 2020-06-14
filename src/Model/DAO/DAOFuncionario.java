package Model.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Enum.TipoFuncionario;
import Model.Funcionario;

public class DAOFuncionario {
    public static Funcionario consultarFuncionario(String cpf) throws Exception {
        Conexao conn = new Conexao();
        Funcionario funcionario = new Funcionario();        
        try {            
            Connection cnx = conn.getConexaoMySQL();
            Statement stt = cnx.createStatement();
            ResultSet rst = stt.executeQuery(String.format("SELECT * FROM PESSOA WHERE CPF = '%s'", cpf));
            while(rst.first()){              
              funcionario.setId(rst.getInt("ID"));
              funcionario.setNome(rst.getString("NOME"));
              funcionario.setDtNascimento(rst.getDate("DTNASCIMENTO"));
              funcionario.setCpf(rst.getString("CPF"));                            
              funcionario.setRg(rst.getString("RG"));                            
            }            
            rst = stt.executeQuery(String.format("SELECT * FROM FUNCIONARIO WHERE MPESSOA = %d", funcionario.getId()));
            while(rst.first()){
              funcionario.setTipoFuncionario((TipoFuncionario)rst.getObject("TIPOFUNCIONARIO"));
            }
            return funcionario;
        } catch(SQLException sqlEx){
          throw sqlEx;
        }
        catch (Exception e) {
          throw e;
        }
        finally{
          conn.fecharConexao();
        }		
    }
    
    public static ArrayList<Funcionario> consultarFuncionarios() throws Exception{
      Conexao conn = new Conexao();
      ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();            
      Funcionario funcionario;
      try {            
          Connection cnx = conn.getConexaoMySQL();
          Statement stt = cnx.createStatement();
          ResultSet rst = stt.executeQuery("SELECT * FROM PESSOA");
          ResultSet rstPessoa;
          while(rst.next()){
            funcionario = new Funcionario();
            funcionario.setId(rst.getInt("ID"));
            funcionario.setNome(rst.getString("NOME"));
            funcionario.setDtNascimento(rst.getDate("DTNASCIMENTO"));
            funcionario.setCpf(rst.getString("CPF"));                            
            funcionario.setRg(rst.getString("RG"));   
            rstPessoa = stt.executeQuery(String.format("SELECT * FROM FUNCIONARIO WHERE MPESSOA = %d",funcionario.getId()));
            while(rstPessoa.first()){              
              funcionario.setTipoFuncionario((TipoFuncionario)rstPessoa.getObject("TIPOFUNCIONARIO"));
            }
            funcionarios.add(funcionario);
          }                      
          return funcionarios;
      } catch(SQLException sqlEx){
        throw sqlEx;
      }
      catch (Exception e) {
        throw e;
      }
      finally{
        conn.fecharConexao();
      }		
    }
    
    public static void cadastrarFuncionario(Funcionario funcionario) throws Exception{
      Conexao conn = new Conexao();
      Connection cnx = conn.getConexaoMySQL();
        try {            
          
          Statement stt = cnx.createStatement();
          ResultSet rst = stt.executeQuery(String.format("INSERT INTO PESSOA(NOME,DTNASCIMENTO,CPF, RG) VALUES('%s',%t,'%s','%s'); SELECT ID FROM PESSOA WHERE NOME = '%s'",
                                            funcionario.getNome(), funcionario.getDtNascimento(), funcionario.getCpf(), funcionario.getRg(), funcionario.getNome()));
          int id = rst.getInt("ID");          
          stt.execute(String.format("INSERT INTO FUNCIONARIO(MPESSOA, TIPOFUNCIONARIO) VALUES(%d, '%s')", id, funcionario.getTipoFuncionario().toString()));
          cnx.commit();
      } catch (Exception e) {
        cnx.rollback();
          throw e;
      }
      finally{
        conn.fecharConexao();
      }
  } 

	public static void alterarFuncionario(Funcionario funcionario) throws Exception{
    Conexao conn = new Conexao();
    Connection cnx = conn.getConexaoMySQL();
    try {                  
      Statement stt = cnx.createStatement();
      stt.execute(String.format("UPDATE PESSOA SET NOME = '%s', DTNASCIMENTO = %t, CPF = '%s', CPF = '%s', RG = '%s' WHERE ID = %d);",funcionario.getNome(), funcionario.getDtNascimento(), funcionario.getCpf(), funcionario.getRg(), funcionario.getId()));
      stt.execute(String.format("UPDATE FUNCIONARIO SET TIPOFUNCIONARIO = '%s' WHERE MPESSOA = %d", funcionario.getTipoFuncionario().toString(), funcionario.getId()));
      cnx.commit();
    } catch (Exception e) {
      cnx.rollback();
      throw e;
    }
    finally{
      conn.fecharConexao();
    }
	}

	public static void excluirFuncionario(int id) throws Exception{
    Conexao conn = new Conexao();
    Connection cnx = conn.getConexaoMySQL();
    try {            
      Statement stt = cnx.createStatement();
      stt.execute(String.format("DELETE FROM FUNCIONARIO WHERE MPESSOA = %d; DELETE FROM PESSOA WHERE ID = %d",id,id));
      cnx.commit();
    } catch (Exception e) {
      cnx.rollback();
      throw e;
    }
    finally{
      
      conn.fecharConexao();
    }
	}	
}