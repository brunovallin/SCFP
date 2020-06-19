package Model;

import java.util.ArrayList;

import Enum.TipoVisitante;
import Model.DAO.DAOVisitante;

public class Visitante extends Pessoa {
    

    private TipoVisitante tipoVisitante;    

    public TipoVisitante getTipoVisitante() {
        return tipoVisitante;
    }

    public void setTipoVisitante(TipoVisitante tipoVisitante) {
        this.tipoVisitante = tipoVisitante;
    }

    public void consultarVisitante(String rg) throws Exception {
		try {
			Visitante visitante = DAOVisitante.consultarVisitante(rg);
			this.setId(visitante.getId());
                        if(this.getId() == 0){
                            throw new Exception("Visitante não encontrado!");
                        }
			this.setNome(visitante.getNome());
			this.setDtNascimento(visitante.getDtNascimento());
			this.setRg(visitante.getRg());			
            this.setTipoVisitante(visitante.getTipoVisitante());            
		} catch (Exception e) {
			throw e;
		}
    }
    
    public static ArrayList<Visitante> consultaVisitantes() throws Exception {
        try {
            ArrayList<Visitante> visitantes = DAOVisitante.consultarVisitantes();            
            return visitantes;
        } catch (Exception e) {
            throw e;
        }
    }

    public void cadastrarVisitante() throws Exception {
        try {
            DAOVisitante.cadastrarVisitante(this);
        } catch (Exception e) {
            throw e;
        }
    }

    public void alterarVisitante() throws Exception{
        try {
            DAOVisitante.alterarVisitante(this);
        } catch (Exception e) {
            throw e;
        }
    }

    public static void excluirVisitante(int id) throws Exception{
        try {
            DAOVisitante.excluirVisitante(id);
        } catch (Exception e) {
            throw e;
        }
    }
}
