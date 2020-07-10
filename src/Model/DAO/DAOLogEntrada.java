package Model.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import Model.LogEntrada;
import Model.Morador;
import Model.Visitante;
import java.text.SimpleDateFormat;

public class DAOLogEntrada {
    public static ArrayList<LogEntrada> consultaLogEntradaDia(Date data) throws Exception {
        Conexao conn = new Conexao();
        LogEntrada log = new LogEntrada();
        ArrayList<LogEntrada> logs = new ArrayList<LogEntrada>();
        SimpleDateFormat date,time;
        date = new SimpleDateFormat("yyyy-MM-dd");
        time = new SimpleDateFormat("HH:mm:ss");
        
        Visitante visitante;
        Morador morador;
        try {
            Connection cnx = conn.getConexaoMySQL();
            Statement stt = cnx.createStatement();
            ResultSet rst = stt.executeQuery("SELECT * FROM LOGENTRADA WHERE DATAENTRADA LIKE '%" + date.format(data) + "%'");
            while (rst.next()) {
                log = new LogEntrada();
                visitante = new Visitante();
                morador = new Morador();                
                log.setPessoa(DAOVisitante.consultarVisitante(rst.getInt("MPESSOA")));
                log.setDescricaoAcao(rst.getString("DESCRICAOACAO"));                
                log.setDataEntrada(rst.getTimestamp("DATAENTRADA"));                
                log.setaVisitar(DAOMorador.consultarMorador(rst.getInt("MAVISITAR")));                
                
                logs.add(log);
            }
            return logs;
        } catch (SQLException sqlEx) {
            throw sqlEx;
        } catch (Exception e) {
            throw e;
        } finally {
            conn.fecharConexao();
        }
    }

    public static ArrayList<LogEntrada> consultaLogsEntrada() throws Exception {
        Conexao conn = new Conexao();
        LogEntrada log = new LogEntrada();
        ArrayList<LogEntrada> logs = new ArrayList<LogEntrada>();
        try {
            Connection cnx = conn.getConexaoMySQL();
            Statement stt = cnx.createStatement();
            ResultSet rst = stt.executeQuery("SELECT * FROM LOGENTRADA");
            while (rst.next()) {
                log = new LogEntrada();
                log.setPessoa(rst.getInt("MPESSOA"));
                log.setDescricaoAcao(rst.getString("DESCRICAOACAO"));
                log.setDataEntrada(rst.getDate("DATAENTRADA"));
                log.setaVisitar(rst.getInt("MAVISITAR"));
                logs.add(log);
            }
            return logs;
        } catch (SQLException sqlEx) {
            throw sqlEx;
        } catch (Exception e) {
            throw e;
        } finally {
            conn.fecharConexao();
        }
    }

    public static void cadastrarLogEntrada(LogEntrada log) throws Exception {
        Conexao conn = new Conexao();
        Connection cnx = conn.getConexaoMySQL();
        cnx.setAutoCommit(false);
        SimpleDateFormat data = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {            
            Statement stt = cnx.createStatement();
            stt.execute(String.format(
                    "INSERT INTO LOGENTRADA(MPESSOA, DESCRICAOACAO, DATAENTRADA,MAVISITAR) VALUES(%d, '%s','%s', %d);",
                    log.getVisitante().getId(), log.getDescricaoAcao(), data.format(log.getDataEntrada()),
                    log.getaVisitar().getId()));
            cnx.commit();
        } catch (Exception e) {
            cnx.rollback();
            throw e;
        } finally {
            conn.fecharConexao();
        }
    }
}