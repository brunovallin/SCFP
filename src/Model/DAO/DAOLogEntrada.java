package Model.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import Model.LogEntrada;

public class DAOLogEntrada {
    public static ArrayList<LogEntrada> consultaLogEntradaDia(Date data) throws Exception {
        Conexao conn = new Conexao();
        LogEntrada log = new LogEntrada();
        ArrayList<LogEntrada> logs = new ArrayList<LogEntrada>();
        try {
            Connection cnx = conn.getConexaoMySQL();
            Statement stt = cnx.createStatement();
            ResultSet rst = stt.executeQuery(String.format("SELECT * FROM LOGENTRADA WHERE DATAENTRADA = %t", data));
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
        try {
            Statement stt = cnx.createStatement();
            stt.execute(String.format(
                    "INSERT INTO LOGENTRADA(MPESSOA, DESCRICAOACAO, DATAENTRADA,MAVISITAR) VALUES(%d, '%s',%t, %d);",
                    log.getVisitante().getId(), log.getDescricaoAcao(), log.getDataEntrada(),
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