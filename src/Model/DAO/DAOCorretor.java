package Model.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Enum.TipoPessoa;
import Model.Corretor;
import Model.Pessoa;

public class DAOCorretor {

    
	public static Corretor consultarCorretor(String creci) throws Exception {
        Conexao conn = new Conexao();
        Corretor corretor = new Corretor();
        Pessoa imobiliaria = new Pessoa();
        try {            
            Connection cnx = conn.getConexaoMySQL();
            Statement stt = cnx.createStatement();
            ResultSet rst = stt.executeQuery(String.format("SELECT * FROM CORRETOR WHERE CRECI = '%s'", creci));
            while(rst.first()){              
              corretor.setCreci(rst.getString("CRECI"));              
              corretor.setFkImobiliaria(imobiliaria);
              corretor.setId(rst.getInt("PESSOA"));
            }            
            rst = stt.executeQuery(String.format("SELECT * FROM PESSOA WHERE ID = %d",corretor.getId()));
            while(rst.first()){
              corretor.setNome(rst.getString("NOME"));
              corretor.setDtNascimento(rst.getDate("DTNASCIMENTO"));
              corretor.setDocumento(rst.getString("DOCUMENTO"));
              corretor.setTipoPessoa((TipoPessoa)rst.getObject("TIPOPESSOA"));
            }
            return corretor;
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
    
    public static List<Corretor> consultarCorretores() throws Exception{
      Conexao conn = new Conexao();
      List<Corretor> corretores = new ArrayList<Corretor>();
      Corretor corretor;
      Pessoa imobiliaria = new Pessoa();
      try {            
          Connection cnx = conn.getConexaoMySQL();
          Statement stt = cnx.createStatement();
          ResultSet rst = stt.executeQuery("SELECT * FROM CORRETOR");
          ResultSet rstPessoa;
          while(rst.next()){
            corretor = new Corretor();            
            corretor.setCreci(rst.getString("CRECI"));              
            corretor.setFkImobiliaria(imobiliaria);
            corretor.setId(rst.getInt("PESSOA"));
            rstPessoa = stt.executeQuery(String.format("SELECT * FROM PESSOA WHERE ID = %d",corretor.getId()));
            while(rstPessoa.first()){
              corretor.setNome(rstPessoa.getString("NOME"));
              corretor.setDtNascimento(rstPessoa.getDate("DTNASCIMENTO"));
              corretor.setDocumento(rstPessoa.getString("DOCUMENTO"));
              corretor.setTipoPessoa((TipoPessoa)rstPessoa.getObject("TIPOPESSOA"));
            }
            corretores.add(corretor);
          }                      
          return corretores;
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
    
    public static void cadastrarCorretor(Corretor corretor) throws Exception{
      Conexao conn = new Conexao();
        try {            
          Connection cnx = conn.getConexaoMySQL();
          Statement stt = cnx.createStatement();
          ResultSet rst = stt.executeQuery(String.format("INSERT INTO PESSOA(NOME,DTNASCIMENTO,DOCUMENTO, TIPOPESSOA) VALUES(%s,%t,%s,%s);SELECT ID FROM PESSOA WHERE NOME = %s",
                                            corretor.getNome(), corretor.getDtNascimento(), corretor.getDocumento(), corretor.getTipoPessoa(),corretor.getNome()));
          int id = rst.getInt("ID");
          rst = stt.executeQuery(String.format("SELECT * FROM PESSOA WHERE TIPOPESSOA = 'JURIDICA' AND ID = ",corretor.getFkImobiliaria().getId()));
          stt.execute(String.format("INSERT INTO CORRETOR(PESSOA,CRECI,FKIMOBILIARIA) VALUES(%d, %s, %d)",id,corretor.getCreci(),corretor.getFkImobiliaria().getId()));
      } catch (Exception e) {
          throw e;
      }
      finally{
        conn.fecharConexao();
      }
  } 

	public static void alterarCorretor(Corretor corretor) throws Exception{
    Conexao conn = new Conexao();
    try {            
      Connection cnx = conn.getConexaoMySQL();
      Statement stt = cnx.createStatement();
      stt.execute(String.format("UPDATE PESSOA SET NOME = %s, DTNASCIMENTO = %t, DOCUMENTO = %s, TIPOPESSOA = %s WHERE ID = %d);",corretor.getNome(),corretor.getDtNascimento(),corretor.getDocumento(),corretor.getTipoPessoa(),corretor.getId()));
      stt.execute(String.format("UPDATE CORRETOR SET CRECI = %s, IMOBILIARIA = %d where pessoa = %d", corretor.getCreci(),corretor.getFkImobiliaria().getId(), corretor.getId()));
    } catch (Exception e) {
      throw e;
    }
    finally{
      conn.fecharConexao();
    }
	}

	public static void excluirCorretor(int id) throws Exception{
    Conexao conn = new Conexao();
    try {            
      Connection cnx = conn.getConexaoMySQL();
      Statement stt = cnx.createStatement();
      stt.execute(String.format("DELETE FROM PESSOA WHERE ID = %d; DELETE FROM CORRETOR WHERE PESSOA = %d",id,id));
    } catch (Exception e) {
      throw e;
    }
    finally{
      conn.fecharConexao();
    }
	}	
}