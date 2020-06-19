package Model.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DAOBloco {

    public static ArrayList<String> buscaBlocos() throws Exception {
        Conexao conn = new Conexao();
        ArrayList<String> blocos = new ArrayList<String>();

        try {
            Connection cnx = conn.getConexaoMySQL();
            Statement stt = cnx.createStatement();
            ResultSet rst = stt.executeQuery("SELECT * FROM BLOCO");
            String bloco;
            while (rst.next()) {
                bloco = new String();
                bloco = rst.getString("NOME");

                blocos.add(bloco);
            }
            return blocos;
        } catch (SQLException sqlEx) {
            throw sqlEx;
        } catch (Exception e) {
            throw e;
        } finally {
            conn.fecharConexao();
        }
    }
}
