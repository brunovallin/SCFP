package Controller;

import Model.DAO.DAOMorador;
import Model.DAO.DAOVisitante;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import Model.LogEntrada;
import Model.Morador;
import Model.Visitante;


public class LogEntradaController {
    
    public static ArrayList<LogEntrada> consultaTodosLogs() throws Exception{
        
        try {

            return LogEntrada.consultaLogsEntrada();
            
        } catch (Exception e) {
            throw e;
        }


    }

    public static ArrayList<LogEntrada> consultaLogsFiltro(String data) throws Exception{

        try {
            SimpleDateFormat dia = new SimpleDateFormat("dd/MM/yyyy");

            return LogEntrada.consultaEntradaDia((Date)dia.parse(data));
            
        } catch (Exception e) {
            throw e;
        }

    }

    public static void cadastrarLog(String rgVisitante, String descricaoAcao, Date dataEntrada, String nomeMorador, String bloco, String apt) throws Exception{

        try {            
            SimpleDateFormat data = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            LogEntrada logEntrada = new LogEntrada();


            if(rgVisitante.isEmpty()){
                throw new Exception("Rg do visitante não preenchido");
            }
            
            logEntrada.setPessoa(DAOVisitante.consultarVisitante(rgVisitante));
            
            
            if(nomeMorador.isEmpty() || bloco.isEmpty() || apt.isEmpty()){
                throw new Exception("Nome\\Apartamento\\Bloco não preenchidos!");
            }
            
            logEntrada.setaVisitar(DAOMorador.consultarMorador(nomeMorador, bloco, Integer.parseInt(apt)));
            
            if(descricaoAcao.isEmpty())
                throw new Exception("Descrição da visita não preenchida!");
            
            logEntrada.setDescricaoAcao(descricaoAcao);
            
            logEntrada.setDataEntrada(dataEntrada);

            logEntrada.cadastrarLogEntrada();
        } catch (Exception e) {
            throw e;
        }

    }



}