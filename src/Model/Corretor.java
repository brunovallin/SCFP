package Model;

import java.util.List;
import Model.DAO.DAOCorretor;

public class Corretor extends Pessoa{

    private String creci;

    private Pessoa fkImobiliaria;

    public String getCreci() {
        return this.creci;
    }

    public Pessoa getFkImobiliaria() {
        return this.fkImobiliaria;
    }

    public void setFkImobiliaria(Pessoa fkImobiliaria) {
        this.fkImobiliaria = fkImobiliaria;
    }

    public void setCreci(String creci) {
        this.creci = creci;
    }

    public static Corretor consultaCorretor(String creci){
        try {
            return DAOCorretor.consultarCorretor(creci);    
        } catch (Exception e) {
            throw e;
        }        
    }  
    
    public List<Corretor> consultaCorretores() throws Exception {
        try {
            return DAOCorretor.consultarCorretores();    
        } catch (Exception e) {
            throw e;
        }
        
    }

    public void alterarCorretor(){
        try {
            DAOCorretor.alterarCorretor(this);
        } catch (Exception e) {
            throw e;
        }
        
    }

    public void excluirCorretor(int id){
        try {
            DAOCorretor.excluirCorretor(id);    
        } catch (Exception e) {
            throw e;
        }        
    }

    public void cadastraCorretor(){
        try {            
            DAOCorretor.cadastrarCorretor(this);    
        } catch (Exception e) {
            throw e;
        }        
    }
}