package Controller;

import javax.swing.JOptionPane;
import java.util.List;
import java.time.Year;
import java.util.ArrayList;
import java.util.Date;

import Model.Corretor;
import Model.Pessoa;


public class CorretorController{



    public Corretor consultarCorretor(String creci) throws Exception {
        try {
            Corretor corretor = new Corretor();

            if (creci.length() > 5){
                throw new Exception("CRECI fora de parâmetro");
            }

            corretor.consultarCorretor(creci);
            
            return corretor;
        } catch (Exception e) {

           throw e;

        }


    }

    public ArrayList<Corretor> consultaTodosCorretores() throws Exception{
        try {
            ArrayList<Corretor> corretores = new ArrayList<Corretor>();
            corretores.add(new Corretor());
            corretores.addAll(new ArrayList<Corretor>());
            
            return corretores;
            
        } catch (Exception e) {
            
            throw e;
        }
    }


    public void cadastrarCorretor(String nome, String documento, String dtNasc, String creci, int imobiliaria) throws Exception{
        try {
            Corretor corretor = new Corretor();

            corretor.setNome(nome);
            corretor.setDtNascimento(dtNasc);
            corretor.setDocumento(documento.replace(".", "").replace("-", "").replace("/", ""));
            
            
            if (creci.length() > 5){
                throw new Exception("CRECI fora de parâmetro");
            }
            corretor.setCreci(creci);
           
            Pessoa fkImobiliaria = new Pessoa();
            fkImobiliaria = DAOPessoa.buscaPessoa(imobiliaria);
            corretor.setFkImobiliaria(fkImobiliaria);

            corretor.cadastrarCorretor();

        } catch (Exception e) {
        
            throw e;
        }
    }

    public void alterarCorretor(String id, String nome, String dtNasc, String documento, String creci, int imobiliaria) throws Exception{
        try {
            Corretor corretor = new Corretor();

            corretor.setNome(nome);
            corretor.setDtNascimento(dtNasc));
            corretor.setDocumento(documento.replace(".", "").replace("-", "").replace("/", ""));
            
            
            if (creci.length() > 5){
                throw new Exception("CRECI fora de parâmetro");
            }
            corretor.setCreci(creci);
           
            Pessoa fkImobiliaria = new Pessoa();
            fkImobiliaria = DAOPessoa.buscaPessoa(imobiliaria);
            corretor.setFkImobiliaria(fkImobiliaria);

            corretor.alterarCorretor();
            
        } catch (Exception e) {
            
            throw e;

        }
       

    }


    public void excluirCorretor() throws Exception{
        try {
            Corretor corretor = new Corretor();

            corretor.excluirCorretor(id);
        } catch (Exception e) {

            throw e;

        }
        
        
    }
}