package Model.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Enum.TipoVisitante;
import Model.Visitante;

public class DAOVisitante {
    public static Visitante consultarVisitante(String cpf) throws Exception {
        Conexao conn = new Conexao();
        Visitante visitante = new Visitante();
        try {            
            Connection cnx = conn.getConexaoMySQL();
            Statement stt = cnx.createStatement();
            ResultSet rst = stt.executeQuery(String.format("SELECT * FROM PESSOA WHERE CPF = '%s'", cpf));
            while(rst.first()){              
              visitante.setId(rst.getInt("ID"));
              visitante.setNome(rst.getString("NOME"));
              visitante.setDtNascimento(rst.getDate("DTNASCIMENTO"));
              visitante.setCpf(rst.getString("CPF"));                            
              visitante.setRg(rst.getString("RG"));                            
            }            
            rst = stt.executeQuery(String.format("SELECT * FROM VISITANTE WHERE MPESSOA = %d", visitante.getId()));
            while(rst.first()){
              visitante.setTipoVisitante((TipoVisitante)rst.getObject("TIPOVISITANTE"));              
              visitante.setmoradorResponsavel(rst.getInt("MMORADOR"));
            }            
            return visitante;
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
    
    public static ArrayList<Visitante> consultarVisitantes() throws Exception{
      Conexao conn = new Conexao();
      ArrayList<Visitante> moradores = new ArrayList<Visitante>();            
      Visitante visitante;
      try {            
          Connection cnx = conn.getConexaoMySQL();
          Statement stt = cnx.createStatement();
          ResultSet rst = stt.executeQuery("SELECT * FROM PESSOA");
          ResultSet rstPessoa;
          while(rst.next()){
            visitante = new Visitante();
            visitante.setId(rst.getInt("ID"));
            visitante.setNome(rst.getString("NOME"));
            visitante.setDtNascimento(rst.getDate("DTNASCIMENTO"));
            visitante.setCpf(rst.getString("CPF"));                            
            visitante.setRg(rst.getString("RG"));
            rstPessoa = stt.executeQuery(String.format("SELECT * FROM VISITANTE WHERE MPESSOA = %d", visitante.getId()));
            while(rst.first()){
              visitante.setTipoVisitante((TipoVisitante)rst.getObject("TIPOVISITANTE"));              
              visitante.setmoradorResponsavel(rst.getInt("MMORADOR"));
            }        
            moradores.add(visitante);
          }                      
          return moradores;
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
    
    public static void cadastrarVisitante(Visitante visitante) throws Exception{
      Conexao conn = new Conexao();
      Connection cnx = conn.getConexaoMySQL();
      try {                              
        Statement stt = cnx.createStatement();
        ResultSet rst = stt.executeQuery(String.format("INSERT INTO PESSOA(NOME,DTNASCIMENTO,CPF, RG) VALUES('%s',%t,'%s','%s'); SELECT ID FROM PESSOA WHERE NOME = '%s'",
                                          visitante.getNome(), visitante.getDtNascimento(), visitante.getCpf(), visitante.getRg(), visitante.getNome()));
        int id = rst.getInt("ID");          
        stt.execute(String.format("INSERT INTO VISITANTE(MPESSOA, MMORADORRESPONSAVEL, TIPOVISITANTE) VALUES(%d, %d, '%s')", id, visitante.getId(),visitante.getmoradorResponsavel().getId(),visitante.getTipoVisitante().toString()));
        cnx.commit();
      } catch (Exception e) {       
        cnx.rollback();   
        throw e;
      }
      finally{
        conn.fecharConexao();
      }
  } 

	public static void alterarVisitante(Visitante visitante) throws Exception{
    Conexao conn = new Conexao();
    Connection cnx = conn.getConexaoMySQL();
    try {                  
      Statement stt = cnx.createStatement();
      stt.execute(String.format("UPDATE PESSOA SET NOME = '%s', DTNASCIMENTO = %t, CPF = '%s', CPF = '%s', RG = '%s' WHERE ID = %d);",visitante.getNome(), visitante.getDtNascimento(), visitante.getCpf(), visitante.getRg(), visitante.getId()));
      stt.execute(String.format("UPDATE VISITANTE SET MMORADORRESPONSAVEL = %d, TIPOVISITANTE = '%s' WHERE MPESSOA = %d", visitante.getmoradorResponsavel(), visitante.getTipoVisitante().toString()));
      cnx.commit();
    } catch (Exception e) {
      cnx.rollback();
      throw e;
    } finally {
      conn.fecharConexao();
    }
	}

	public static void excluirVisitante(int id) throws Exception{
    Conexao conn = new Conexao();
    Connection cnx = conn.getConexaoMySQL();
    try {                  
      Statement stt = cnx.createStatement();
      stt.execute(String.format("DELETE FROM VISITANTE WHERE MPESSOA = %d; DELETE FROM PESSOA WHERE ID = %d",id,id));
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