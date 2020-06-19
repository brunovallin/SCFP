package Controller;

import java.sql.Date;
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

    public static void cadastrarLog(Visitante visitante, String descricaoAcao, String dataEntrada, Morador aVisitar) throws Exception{

        try {
            SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
            LogEntrada logEntrada = new LogEntrada();


            if(visitante == null){
                throw new Exception("Visitante não pode ser um campo vazio");
            }
            logEntrada.setPessoa(visitante);

            if(aVisitar == null){
                throw new Exception("Morador não pode ser um campo vazio");
            }
            logEntrada.setaVisitar(aVisitar);
            logEntrada.setDescricaoAcao(descricaoAcao);
            logEntrada.setDataEntrada((Date)data.parse(dataEntrada));

            logEntrada.cadastrarLogEntrada();

        } catch (Exception e) {
            throw e;
        }

    }



}