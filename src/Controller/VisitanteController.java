package Controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Enum.TipoVisitante;
import Model.Visitante;
import Model.Morador;

public class VisitanteController {

    public void cadastrarVisitante(String nome, String rg, String dtNasc, String idMorador, String tipoVisitante ) throws Exception{
        try {
            
            Visitante visitante = new Visitante();
            SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
            Morador morador = new Morador();

            visitante.setRg(rg.replace(".", "").replace("-", "").replace("/", ""));
            visitante.setNome(nome);
            
            switch (tipoVisitante){
                case "VISITANTE":
                    visitante.setTipoVisitante(TipoVisitante.VISITANTE);
                break;

                case "PRESTADORSERVICO":
                    visitante.setTipoVisitante(TipoVisitante.PRESTADORSERVICO);
                break;

            }
            visitante.setDtNascimento((Date)data.parse(dtNasc));

            morador.setId(Integer.parseInt(idMorador));
            
            if(morador.getId() <= 0){
               throw new Exception("Morador não encontrado");
            }
            visitante.setmoradorResponsavel(morador);

            visitante.cadastrarVisitante();
        
        } catch (Exception e) {
            throw e;
        }

    }

    public Visitante consultarVisitante(String rg) throws Exception{

        try {
            Visitante visitante = new Visitante();

            visitante.consultarVisitante(rg.replace(".", "").replace("-", "").replace("/", ""));

            return visitante;

        } catch (Exception e) {
           throw e;
        }

    }

    public ArrayList<Visitante> consultaVisitantes() throws Exception{

        try {
            
            return Visitante.consultaVisitantes();

        } catch (Exception e) {
            throw e;
        }

    }

    public void alterarVisitante(String nome, String rg, String dtNasc, String idMorador, String tipoVisitante) throws Exception{

        try{
        Visitante visitante = new Visitante();
        SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
        Morador morador = new Morador();

        visitante.setRg(rg.replace(".", "").replace("-", "").replace("/", ""));
        visitante.setNome(nome);
        
        switch (tipoVisitante){
            case "VISITANTE":
                visitante.setTipoVisitante(TipoVisitante.VISITANTE);
            break;

            case "PRESTADORSERVICO":
                visitante.setTipoVisitante(TipoVisitante.PRESTADORSERVICO);
            break;

        }
        visitante.setDtNascimento((Date)data.parse(dtNasc));

        morador.setId(Integer.parseInt(idMorador));
        
        if(morador.getId() <= 0){
           throw new Exception("Morador não encontrado");
        }
        visitante.setmoradorResponsavel(morador);

        visitante.alterarVisitante();
    
         }catch (Exception e) {
        throw e;
        }
    }


    public void excluirVisitante(int id) throws Exception{

        try {
            
            Visitante.excluirVisitante(id);

        } catch (Exception e) {
            throw e;
        }


    }

}