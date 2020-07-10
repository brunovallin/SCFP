package Model.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Morador;
import java.text.SimpleDateFormat;

public class DAOMorador {

    public static Morador consultarMorador(String rg) throws Exception {
        Conexao conn = new Conexao();
        Connection cnx = conn.getConexaoMySQL();
        Morador morador = new Morador();
        cnx.setAutoCommit(false);
        try {
            Statement stt = cnx.createStatement();
            ResultSet rst = stt.executeQuery(String.format("SELECT * FROM PESSOA WHERE RG = '%s'", rg));
            while (rst.next()) {
                morador.setId(rst.getInt("ID"));
                morador.setNome(rst.getString("NOME"));
                morador.setDtNascimento(rst.getDate("DTNASCIMENTO"));
                morador.setRg(rst.getString("RG"));
            }
            rst = stt.executeQuery(String.format("SELECT * FROM MORADOR WHERE MPESSOA = %d", morador.getId()));
            while (rst.next()) {
                if (rst.getInt("MPESSOA") == 0) {
                    throw new Exception("Morador não encontrado!");
                }

                morador.setBloco(rst.getString("BLOCO"));
                morador.setnApt(rst.getInt("NAPT"));
                morador.setCodEstacionamento(rst.getInt("CODESTACIONAMENTO"));
                 
            }            
            return morador;
        } catch (SQLException sqlEx) {
            cnx.rollback();
            throw sqlEx;
        } catch (Exception e) {
            cnx.rollback();
            throw e;
        } finally {
            conn.fecharConexao();
        }
    }

    public static Morador consultarMorador(Integer id) throws Exception {
        Conexao conn = new Conexao();
        Connection cnx = conn.getConexaoMySQL();
        Morador morador = new Morador();
        cnx.setAutoCommit(false);
        try {
            Statement stt = cnx.createStatement();
            ResultSet rst = stt.executeQuery(String.format("SELECT * FROM PESSOA WHERE ID = %d", id));
            while (rst.next()) {
                morador.setId(rst.getInt("ID"));
                morador.setNome(rst.getString("NOME"));
                morador.setDtNascimento(rst.getDate("DTNASCIMENTO"));
                morador.setRg(rst.getString("RG"));
            }
            rst = stt.executeQuery(String.format("SELECT * FROM MORADOR WHERE MPESSOA = %d", morador.getId()));
            while (rst.next()) {
                if (rst.getInt("MPESSOA") == 0) {
                    throw new Exception("Morador não encontrado!");
                }

                morador.setBloco(rst.getString("BLOCO"));
                morador.setnApt(rst.getInt("NAPT"));
                morador.setCodEstacionamento(rst.getInt("CODESTACIONAMENTO"));
                 
            }            
            return morador;
        } catch (SQLException sqlEx) {
            cnx.rollback();
            throw sqlEx;
        } catch (Exception e) {
            cnx.rollback();
            throw e;
        } finally {
            conn.fecharConexao();
        }
    }
    
    public static Morador consultarMorador(String nome, String bloco, int napt) throws Exception {
        Conexao conn = new Conexao();
        Morador morador = new Morador();
        try {
            Connection cnx = conn.getConexaoMySQL();
            Statement stt = cnx.createStatement();
            ResultSet rst = stt.executeQuery("SELECT * FROM PESSOA WHERE NOME like '%" + nome.toUpperCase()+"%'");
            while (rst.next()) {
                morador.setId(rst.getInt("ID"));
                morador.setNome(rst.getString("NOME"));
                morador.setDtNascimento(rst.getDate("DTNASCIMENTO"));
                morador.setRg(rst.getString("RG"));
            }
            rst = stt.executeQuery(String.format("SELECT * FROM MORADOR WHERE MPESSOA = %d AND BLOCO = '%s' AND NAPT = %d", morador.getId(), bloco, napt));
            while (rst.next()) {
                if (rst.getInt("MPESSOA") == 0) {
                    throw new Exception("Morador não encontrado!");
                }
                morador.setBloco(rst.getString("BLOCO"));
                morador.setnApt(rst.getInt("NAPT"));
                morador.setCodEstacionamento(rst.getInt("CODESTACIONAMENTO"));
            }
            return morador;
        } catch (SQLException sqlEx) {
            throw sqlEx;
        } catch (Exception e) {
            throw e;
        } finally {
            conn.fecharConexao();
        }
    }

    public static ArrayList<Morador> consultarMoradores() throws Exception {
        Conexao conn = new Conexao();
        ArrayList<Morador> moradores = new ArrayList<Morador>();
        Morador morador;
        try {
            Connection cnx = conn.getConexaoMySQL();
            Statement stt = cnx.createStatement();
            ResultSet rst = stt.executeQuery("SELECT * FROM PESSOA");
            ResultSet rstPessoa;
            while (rst.next()) {
                morador = new Morador();
                morador.setId(rst.getInt("ID"));
                morador.setNome(rst.getString("NOME"));
                morador.setDtNascimento(rst.getDate("DTNASCIMENTO"));
                morador.setRg(rst.getString("RG"));
                rstPessoa = stt.executeQuery(String.format("SELECT * FROM MORADOR WHERE MPESSOA = %d", morador.getId()));
                while (rstPessoa.next()) {
                    morador.setBloco(rst.getString("BLOCO"));
                    morador.setnApt(rst.getInt("NAPT"));
                    morador.setCodEstacionamento(rst.getInt("CODESTACIONAMENTO"));
                }
                moradores.add(morador);
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

    public static void cadastrarMorador(Morador morador) throws Exception {
        Conexao conn = new Conexao();
        Connection cnx = conn.getConexaoMySQL();
        cnx.setAutoCommit(false);
        SimpleDateFormat data = new SimpleDateFormat("yyyy-MM-dd");
        int id = 0;
        try {
            Statement stt = cnx.createStatement();
            stt.execute(String.format("INSERT INTO PESSOA(NOME,DTNASCIMENTO, RG) VALUES('%s', '%s', '%s');", morador.getNome(), data.format(morador.getDtNascimento()), morador.getRg()));
            ResultSet rst = stt.executeQuery(String.format("SELECT ID FROM PESSOA WHERE NOME = '%s';", morador.getNome()));
            if (rst.next()) {
                id = rst.getInt("ID");
            } else {
                throw new Exception("Erro ao inserir Morador");
            }
            stt.execute(String.format("INSERT INTO MORADOR(MPESSOA, BLOCO, NAPT, CODESTACIONAMENTO) VALUES(%d, '%s', %d, %d)", id, morador.getBloco(), morador.getnApt(), morador.getCodEstacionamento()));            
            cnx.commit();
        } catch (SQLException sqlEx) {
            cnx.rollback();
            throw sqlEx;
        } catch (Exception e) {
            cnx.rollback();
            throw e;
        } finally {
            conn.fecharConexao();
        }
    }

    public static void alterarMorador(Morador morador) throws Exception {
        Conexao conn = new Conexao();
        Connection cnx = conn.getConexaoMySQL();
        cnx.setAutoCommit(false);
        SimpleDateFormat data = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Statement stt = cnx.createStatement();
            stt.execute(String.format("UPDATE PESSOA SET NOME = '%s', DTNASCIMENTO = '%s', RG = '%s' WHERE ID = %d);", morador.getNome(), data.format(morador.getDtNascimento()), morador.getRg(), morador.getId()));
            stt.execute(String.format("UPDATE MORADOR SET BLOCO = '%s', NAPT = %d, CODESTACIONAMENTO = %d WHERE MPESSOA = %d", morador.getBloco(), morador.getnApt(), morador.getCodEstacionamento(), morador.getId()));
            cnx.commit();
        } catch (SQLException sqlEx) {
            cnx.rollback();
            throw sqlEx;
        } catch (Exception e) {
            cnx.rollback();
            throw e;
        } finally {
            conn.fecharConexao();
        }
    }

    public static void excluirMorador(int id) throws Exception {
        Conexao conn = new Conexao();
        Connection cnx = conn.getConexaoMySQL();
        cnx.setAutoCommit(false);
        try {
            Statement stt = cnx.createStatement();
            stt.execute(String.format("DELETE FROM MORADOR WHERE MPESSOA = %d;", id));
            stt.execute(String.format("DELETE FROM PESSOA WHERE ID = %d", id));
            cnx.commit();
        } catch (SQLException sqlEx) {
            cnx.rollback();
            throw sqlEx;
        } catch (Exception e) {
            cnx.rollback();
            throw e;
        } finally {
            conn.fecharConexao();
        }
    }
}
