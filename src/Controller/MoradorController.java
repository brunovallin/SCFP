package Controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Enum.*;
import Model.Morador;
import Model.DAO.DAOMorador;


public class MoradorController{

    public Morador consultarMorador(String rg) throws Exception{

        try {
            Morador morador = new Morador();
            
            morador.consultarMorador(rg.replace(".", "").replace("-", "").replace("/", ""));

            return morador;
        } catch (Exception e) {
            throw e;
        }        
    }

    public ArrayList<Morador> consultarTodosMoradores(String nome, String dtNasc, String rg, String bloco, String nApt, String codEstacionamento ) throws Exception{

        try {
        
            return Morador.consultarMoradores();

        } catch (final Exception e) {
            
            throw e;
        }
    }

    public void cadastrarMorador(String nome, String dtNasc, String rg, String bloco, String nApt,  String codEstacionamento) throws Exception{

        try {
            
            Morador morador = new Morador();
            SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");

            morador.setNome(nome);
            morador.setDtNascimento((Date)data.parse(dtNasc));
            morador.setRg(rg.replace(".", "").replace("-", "").replace("/", ""));
            ArrayList<String> blocos;
            blocos = DAOBloco.obterBloco();

            if (!blocos.contains(bloco)){
                throw new Exception("Bloco não encontrado.");
            }
            morador.setBloco(bloco);
            morador.setnApt(Integer.parseInt(nApt));
            morador.setCodEstacionamento(Integer.parseInt(codEstacionamento));

            morador.cadastrarMorador();

        } catch (Exception e) {
            throw e;
        }
    }

    public void alterarMorador(String nome, String dtNasc, String rg, String bloco, String nApt,  String codEstacionamento) throws Exception{

        try {
            Morador morador = new Morador();
            SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");

            morador.setNome(nome);
            morador.setDtNascimento((Date)data.parse(dtNasc));
            morador.setRg(rg.replace(".", "").replace("-", "").replace("/", ""));
            ArrayList<String> blocos;
            blocos = DAOBloco.obterBloco();

            if (!blocos.contains(bloco)){
                throw new Exception("Bloco não encontrado.");
            }
            morador.setBloco(bloco);
            morador.setnApt(Integer.parseInt(nApt));
            morador.setCodEstacionamento(Integer.parseInt(codEstacionamento));

            morador.alterarMorador();

        } catch (Exception e) {
            throw e;
        }
    }

    public void excluirMorador(int id) throws Exception{
        try {            
            Morador.excluirMorador(id);
        } catch (Exception e) {
            throw e;
        }
    }

    public ArrayList<Morador> buscaMorador(String nome, String bloco, String nApt){
        

       if(nome != ""){
            if (nApt != ""){
               return DAOMorador.consultarMoradorFiltro(nome, Integer.parseInt(nApt));
            }else{
               return DAOMorador.consultarMoradorFiltro(nome);
            }
       }else{
           if(bloco != "" && nApt != ""){
               return DAOMorador.consultarMoradorFiltro(bloco, Integer.parseInt(nApt));
           }else{
               throw new Exception("Filtro inválido!\nFiltros válidos:\nNome\nBloco + Num. Apartamento\n Nome + Num. Apartamento");
           }
       }



    }

}