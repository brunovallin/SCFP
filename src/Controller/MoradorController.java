package Controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Model.Morador;
import Model.DAO.DAOBloco;
import Model.DAO.DAOMorador;

public class MoradorController {

    public static Morador consultarMorador(String rg) throws Exception {
        try {
            if (rg == null || rg.equals("")) {
                throw new Exception("RG não foi digitado");
            }

            Morador morador = new Morador();
            morador.consultarMorador(rg.replace(".", "").replace("-", "").replace("/", ""));

            return morador;
        } catch (Exception e) {
            throw e;
        }
    }

    public static ArrayList<Morador> consultarTodosMoradores() throws Exception {
        try {
            return Morador.consultarMoradores();
        } catch (final Exception e) {

            throw e;
        }
    }

    public static void cadastrarMorador(String nome, String dtNasc, String rg, String bloco, String nApt, String codEstacionamento) throws Exception {
        try {
            Morador morador = new Morador();
            SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
            
            morador.setNome(nome.toUpperCase());
            if(dtNasc.equals("  /  /    ")){
                throw new Exception("Digite a data de nascimento!");
            }            
            morador.setDtNascimento((Date) data.parse(dtNasc));
                        
            morador.setRg(rg.replace(".", "").replace("-", "").replace("/", "").toUpperCase());
            
            morador.setBloco(bloco);
            
            morador.setnApt(Integer.parseInt(nApt));
            if(!codEstacionamento.isEmpty())
                morador.setCodEstacionamento(Integer.parseInt(codEstacionamento));

            morador.cadastrarMorador();

        } catch (Exception e) {
            throw e;
        }
    }

    public static void alterarMorador(String id, String nome, String dtNasc, String rg, String bloco, String nApt, String codEstacionamento) throws Exception {

        try {
            Morador morador = new Morador();
            SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");

            morador.setId(Integer.parseInt(id));
            morador.setNome(nome.toUpperCase());
            morador.setDtNascimento((Date) data.parse(dtNasc));
            morador.setRg(rg.replace(".", "").replace("-", "").replace("/", "").toUpperCase());
            morador.setBloco(bloco.toUpperCase());
            morador.setnApt(Integer.parseInt(nApt));
            morador.setCodEstacionamento(Integer.parseInt(codEstacionamento));

            morador.alterarMorador();

        } catch (Exception e) {
            throw e;
        }
    }

    public static void excluirMorador(String id) throws Exception {
        try {
            Morador.excluirMorador(Integer.parseInt(id));
        } catch (Exception e) {
            throw e;
        }
    }

    public static Morador buscaMorador(String nome, String bloco, String nApt) throws Exception {        
        if (!nome.equals("") && !bloco.equals("") && nApt.equals("")) {
            return DAOMorador.consultarMorador(nome.toUpperCase(), bloco.toUpperCase(), Integer.parseInt(nApt));
        } else {
            throw new Exception("Faltam dados para buscar o Morador");
        }
    }
    

    public static ArrayList<String> buscaBloco() throws Exception {
        try {
            return DAOBloco.buscaBlocos();
        } catch (Exception e) {
            throw e;
        }
    }
}
