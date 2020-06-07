package Model;

import java.util.List;
import Model.DAO.DAOCorretor;

public class Corretor extends Pessoa {    

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

    public void setFkImobiliaria(int id) {
        Pessoa imobiliaria = new Pessoa();
        imobiliaria.setId(id);
        this.fkImobiliaria = imobiliaria;
	}

    public void setCreci(String creci) {
        this.creci = creci;
    }

    public static Corretor consultaCorretor(String creci) throws Exception{
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

    public void alterarCorretor()throws Exception{
        try {
            DAOCorretor.alterarCorretor(this);
        } catch (Exception e) {
            throw e;
        }
        
    }

    public void excluirCorretor(int id) throws Exception{
        try {
            DAOCorretor.excluirCorretor(id);    
        } catch (Exception e) {
            throw e;
        }        
    }

    public void cadastraCorretor() throws Exception{
        try {            
            DAOCorretor.cadastrarCorretor(this);    
        } catch (Exception e) {
            throw e;
        }        
    }	
}