package Model.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Enum.TipoVisitante;
import Model.Visitante;
import java.text.SimpleDateFormat;

public class DAOVisitante {
  public static Visitante consultarVisitante(String rg) throws Exception {
    Conexao conn = new Conexao();
    Visitante visitante = new Visitante();
    try {
      Connection cnx = conn.getConexaoMySQL();
      Statement stt = cnx.createStatement();
      ResultSet rst = stt.executeQuery(String.format("SELECT * FROM PESSOA WHERE RG = '%s'", rg));
      while (rst.first()) {
        visitante.setId(rst.getInt("ID"));
        visitante.setNome(rst.getString("NOME"));
        visitante.setDtNascimento(rst.getDate("DTNASCIMENTO"));        
        visitante.setRg(rst.getString("RG"));
      }
      rst = stt.executeQuery(String.format("SELECT * FROM VISITANTE WHERE MPESSOA = %d", visitante.getId()));
      while (rst.first()) {
        visitante.setTipoVisitante((TipoVisitante) rst.getObject("TIPOVISITANTE"));        
      }
      return visitante;
    } catch (SQLException sqlEx) {
      throw sqlEx;
    } catch (Exception e) {
      throw e;
    } finally {
      conn.fecharConexao();
    }
  }

  public static ArrayList<Visitante> consultarVisitantes() throws Exception {
    Conexao conn = new Conexao();
    ArrayList<Visitante> moradores = new ArrayList<Visitante>();
    Visitante visitante;
    try {
      Connection cnx = conn.getConexaoMySQL();
      Statement stt = cnx.createStatement();
      ResultSet rst = stt.executeQuery("SELECT * FROM PESSOA");
      ResultSet rstPessoa;
      while (rst.next()) {
        visitante = new Visitante();
        visitante.setId(rst.getInt("ID"));
        visitante.setNome(rst.getString("NOME"));
        visitante.setDtNascimento(rst.getDate("DTNASCIMENTO"));        
        visitante.setRg(rst.getString("RG"));
        rstPessoa = stt.executeQuery(String.format("SELECT * FROM VISITANTE WHERE MPESSOA = %d", visitante.getId()));
        while (rstPessoa.first()) {
          visitante.setTipoVisitante((TipoVisitante) rst.getObject("TIPOVISITANTE"));          
        }
        moradores.add(visitante);
      }
      return moradores;
    } catch (SQLException sqlEx) {
      throw sqlEx;
    } catch (Exception e) {
      throw e;
    } finally {
      conn.fecharConexao();
    }
  }

  public static void cadastrarVisitante(Visitante visitante) throws Exception {
    Conexao conn = new Conexao();
    Connection cnx = conn.getConexaoMySQL();    
    cnx.setAutoCommit(false);
    SimpleDateFormat data = new SimpleDateFormat("yyyy-MM-dd");
    int id = 0;
    try {      
        Statement stt = cnx.createStatement();
        stt.execute(String.format("INSERT INTO PESSOA(NOME,DTNASCIMENTO, RG) VALUES('%s','%s','%s');",visitante.getNome(), data.format(visitante.getDtNascimento()), visitante.getRg(), visitante.getNome()));
        ResultSet rst = stt.executeQuery(String.format("SELECT ID FROM PESSOA WHERE NOME = '%s'",visitante.getNome()));
        
        if(rst != null && rst.next())
            id = rst.getInt("ID");      
        stt.execute(String.format("INSERT INTO VISITANTE(MPESSOA, TIPOVISITANTE) VALUES(%d, '%s')", id, visitante.getTipoVisitante().toString()));                
        cnx.commit();
    } catch (Exception e) {
        cnx.rollback();
        throw e;
    } finally {
        conn.fecharConexao();
    }
  }

  public static void alterarVisitante(Visitante visitante) throws Exception {
    Conexao conn = new Conexao();
    Connection cnx = conn.getConexaoMySQL();
    try {
      Statement stt = cnx.createStatement();
      stt.execute(String.format(
          "UPDATE PESSOA SET NOME = '%s', DTNASCIMENTO = %t, RG = '%s' WHERE ID = %d);",
          visitante.getNome(), visitante.getDtNascimento(), visitante.getRg(), visitante.getId()));
      stt.execute(
          String.format("UPDATE VISITANTE SET MMORADORRESPONSAVEL = %d, TIPOVISITANTE = '%s' WHERE MPESSOA = %d", visitante.getTipoVisitante().toString(), visitante.getId()));      
    } catch (Exception e) {      
      throw e;
    } finally {
      conn.fecharConexao();
    }
  }

  public static void excluirVisitante(int id) throws Exception {
    Conexao conn = new Conexao();
    Connection cnx = conn.getConexaoMySQL();
    try {
      Statement stt = cnx.createStatement();
      stt.execute(String.format("DELETE FROM VISITANTE WHERE MPESSOA = %d; DELETE FROM PESSOA WHERE ID = %d", id, id));      
    } catch (Exception e) {     
      throw e;
    } finally {
      conn.fecharConexao();
    }
  }
}