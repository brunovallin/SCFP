package Model.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Morador;

public class DAOMorador {
  public static Morador consultarMorador(String rg) throws Exception {
    Conexao conn = new Conexao();
    Morador morador = new Morador();
    try {            
      Connection cnx = conn.getConexaoMySQL();
      Statement stt = cnx.createStatement();
      ResultSet rst = stt.executeQuery(String.format("SELECT * FROM PESSOA WHERE RG = '%s'", rg));
      while(rst.first()){              
        morador.setId(rst.getInt("ID"));
        morador.setNome(rst.getString("NOME"));
        morador.setDtNascimento(rst.getDate("DTNASCIMENTO"));                           
        morador.setRg(rst.getString("RG"));                            
      }            
      rst = stt.executeQuery(String.format("SELECT * FROM MORADOR WHERE MPESSOA = %d", morador.getId()));
      while(rst.first()){
        morador.setBloco(rst.getString("BLOCO"));
        morador.setnApt(rst.getInt("NAPT"));
        morador.setCodEstacionamento(rst.getInt("CODESTACIONAMENTO"));
      }
      return morador;
    } catch(SQLException sqlEx){
      throw sqlEx;
    } catch (Exception e) {
      throw e;
    }
    finally{
      conn.fecharConexao();
    }		
  }
    
  public static Morador consultarMorador(int id) throws Exception {
    Conexao conn = new Conexao();
    Morador morador = new Morador();
    try {            
      Connection cnx = conn.getConexaoMySQL();
      Statement stt = cnx.createStatement();
      ResultSet rst = stt.executeQuery(String.format("SELECT * FROM PESSOA WHERE ID = '%s'", id));
      while(rst.first()){              
        morador.setId(rst.getInt("ID"));
        morador.setNome(rst.getString("NOME"));
        morador.setDtNascimento(rst.getDate("DTNASCIMENTO"));                        
        morador.setRg(rst.getString("RG"));                            
      }            
      rst = stt.executeQuery(String.format("SELECT * FROM MORADOR WHERE MPESSOA = %d", morador.getId()));
      while(rst.first()){
        morador.setBloco(rst.getString("BLOCO"));
        morador.setnApt(rst.getInt("NAPT"));
        morador.setCodEstacionamento(rst.getInt("CODESTACIONAMENTO"));
      }
      return morador;
    } catch(SQLException sqlEx){
      throw sqlEx;
    } catch (Exception e) {
      throw e;
    }
    finally{
      conn.fecharConexao();
    }		
  }
  
  public static Morador consultarMorador(String nome, String bloco, int napt) throws Exception {
    Conexao conn = new Conexao();
    Morador morador = new Morador();
    try {            
      Connection cnx = conn.getConexaoMySQL();
      Statement stt = cnx.createStatement();
      ResultSet rst = stt.executeQuery(String.format("SELECT * FROM PESSOA WHERE NOME = '%s'", nome));
      while(rst.first()){              
        morador.setId(rst.getInt("ID"));
        morador.setNome(rst.getString("NOME"));
        morador.setDtNascimento(rst.getDate("DTNASCIMENTO"));                                   
        morador.setRg(rst.getString("RG"));                            
      }            
      rst = stt.executeQuery(String.format("SELECT * FROM MORADOR WHERE MPESSOA = %d AND BLOCO = '%s' AND MAPT = %d", morador.getId(), bloco, napt));
      while(rst.first()){
        morador.setBloco(rst.getString("BLOCO"));
        morador.setnApt(rst.getInt("NAPT"));
        morador.setCodEstacionamento(rst.getInt("CODESTACIONAMENTO"));
      }
      return morador;
    } catch(SQLException sqlEx){
      throw sqlEx;
    } catch (Exception e) {
      throw e;
    }
    finally{
      conn.fecharConexao();
    }		
  }

  public static ArrayList<Morador> consultarMoradores() throws Exception{
    Conexao conn = new Conexao();
    ArrayList<Morador> moradores = new ArrayList<Morador>();            
    Morador morador;
    try {            
      Connection cnx = conn.getConexaoMySQL();
      Statement stt = cnx.createStatement();
      ResultSet rst = stt.executeQuery("SELECT * FROM PESSOA");
      ResultSet rstPessoa;
      while(rst.next()){
        morador = new Morador();
        morador.setId(rst.getInt("ID"));
        morador.setNome(rst.getString("NOME"));
        morador.setDtNascimento(rst.getDate("DTNASCIMENTO"));                                 
        morador.setRg(rst.getString("RG"));
        rstPessoa = stt.executeQuery(String.format("SELECT * FROM MORADOR WHERE MPESSOA = %d",morador.getId()));
            while(rstPessoa.first()){              
              morador.setBloco(rst.getString("BLOCO"));
              morador.setnApt(rst.getInt("NAPT"));
              morador.setCodEstacionamento(rst.getInt("CODESTACIONAMENTO"));
            }
            moradores.add(morador);
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
    
    public static void cadastrarMorador(Morador morador) throws Exception{
      Conexao conn = new Conexao();
      Connection cnx = conn.getConexaoMySQL();
      try {                              
        Statement stt = cnx.createStatement();
        ResultSet rst = stt.executeQuery(String.format("INSERT INTO PESSOA(NOME,DTNASCIMENTO, RG) VALUES('%s', %t, '%s'); SELECT ID FROM PESSOA WHERE NOME = '%s'",
                                          morador.getNome(), morador.getDtNascimento(), morador.getRg(), morador.getNome()));
        int id = rst.getInt("ID");          
        stt.execute(String.format("INSERT INTO MORADOR(MPESSOA, BLOCO, NAPT, CODESTACIONAMENTO) VALUES(%d, '%s', '%s',%d, %d)", id, morador.getBloco(), morador.getnApt(), morador.getCodEstacionamento()));
        cnx.commit();
      } catch (Exception e) {
        cnx.rollback();   
        throw e;
      }
      finally{
        conn.fecharConexao();
      }
  } 

	public static void alterarMorador(Morador morador) throws Exception{
    Conexao conn = new Conexao();
    Connection cnx = conn.getConexaoMySQL();
    try {                  
      Statement stt = cnx.createStatement();
      stt.execute(String.format("UPDATE PESSOA SET NOME = '%s', DTNASCIMENTO = %t, RG = '%s' WHERE ID = %d);",morador.getNome(), morador.getDtNascimento(), morador.getRg(), morador.getId()));
      stt.execute(String.format("UPDATE MORADOR SET BLOCO = '%s', NAPT = %d, CODESTACIONAMENTO = %d WHERE MPESSOA = %d", morador.getBloco(),morador.getnApt(),morador.getCodEstacionamento(), morador.getId()));
      cnx.commit();
    } catch (Exception e) {
      cnx.rollback();
      throw e;
    }
    finally{
      conn.fecharConexao();
    }
	}

	public static void excluirMorador(int id) throws Exception{
    Conexao conn = new Conexao();
    Connection cnx = conn.getConexaoMySQL();
    try {                  
      Statement stt = cnx.createStatement();
      stt.execute(String.format("DELETE FROM MORADOR WHERE MPESSOA = %d; DELETE FROM PESSOA WHERE ID = %d",id,id));
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