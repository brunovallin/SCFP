package Controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Enum.TipoVisitante;
import Model.Visitante;

public class VisitanteController {

    public static void cadastrarVisitante(String nome, String rg, String dtNasc, String tipoVisitante ) throws Exception{
        try {
            
            Visitante visitante = new Visitante();
            SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");

            visitante.setRg(rg.replace(".", "").replace("-", "").replace("/", ""));
            visitante.setNome(nome);
            
            switch (tipoVisitante.toUpperCase()){
                case "VISITANTE":
                    visitante.setTipoVisitante(TipoVisitante.VISITANTE);
                break;

                case "PRESTADOR DE SERVIÇO":
                    visitante.setTipoVisitante(TipoVisitante.PRESTADORSERVICO);
                break;

            }
            visitante.setDtNascimento((Date)data.parse(dtNasc));

            visitante.cadastrarVisitante();
        
        } catch (Exception e) {
            throw e;
        }

    }

    public static Visitante consultarVisitante(String rg) throws Exception{

        try {
            Visitante visitante = new Visitante();

            visitante.consultarVisitante(rg.replace(".", "").replace("-", "").replace("/", ""));
            
            return visitante;

        } catch (Exception e) {
           throw e;
        }

    }

    public static ArrayList<Visitante> consultaVisitantes() throws Exception{

        try {
            
            return Visitante.consultaVisitantes();

        } catch (Exception e) {
            throw e;
        }

    }

    public static void alterarVisitante(String id, String nome, String rg, String dtNasc, String tipoVisitante) throws Exception{

        try{
        Visitante visitante = new Visitante();
        SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");

        visitante.setId(Integer.parseInt(id));
        visitante.setRg(rg.replace(".", "").replace("-", "").replace("/", ""));
        visitante.setNome(nome);
        
        switch (tipoVisitante.toUpperCase()){
            case "VISITANTE":
                visitante.setTipoVisitante(TipoVisitante.VISITANTE);
            break;

            case "PRESTADORSERVICO":
                visitante.setTipoVisitante(TipoVisitante.PRESTADORSERVICO);
            break;

        }
        visitante.setDtNascimento((Date)data.parse(dtNasc));

        visitante.alterarVisitante();
    
        }catch (Exception e) { 
            throw e;
        }
    }


    public static void excluirVisitante(int id) throws Exception{

        try {
            
            Visitante.excluirVisitante(id);

        } catch (Exception e) {
            throw e;
        }


    }

}