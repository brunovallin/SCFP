package Model;

import java.util.ArrayList;

import Enum.TipoVisitante;
import Model.DAO.DAOVisitante;

public class Visitante extends Pessoa {

    private Morador moradorResponsavel;

    private TipoVisitante tipoVisitante;    

    public TipoVisitante getTipoVisitante() {
        return tipoVisitante;
    }

    public void setTipoVisitante(TipoVisitante tipoVisitante) {
        this.tipoVisitante = tipoVisitante;
    }

    public Morador getmoradorResponsavel() {
        return this.moradorResponsavel;
    }

    public void setmoradorResponsavel(Morador moradorResponsavel) {
        this.moradorResponsavel = moradorResponsavel;
    }

    public void setmoradorResponsavel(int id){
        Morador morador = new Morador();
        morador.setId(id);
        this.moradorResponsavel = morador;
    }

    public void consultarVisitante(String rg) throws Exception {
		try {
			Visitante visitante = DAOVisitante.consultarVisitante(rg);
			this.setId(visitante.getId());
			this.setNome(visitante.getNome());
			this.setDtNascimento(visitante.getDtNascimento());
			this.setRg(visitante.getRg());
			this.setmoradorResponsavel(visitante.getmoradorResponsavel());
            this.setmoradorResponsavel(visitante.getmoradorResponsavel().getId());
            this.setTipoVisitante(visitante.getTipoVisitante());            
		} catch (Exception e) {
			throw e;
		}
    }
    
    public static ArrayList<Visitante> consultaVisitantes() throws Exception {
        try {
            ArrayList<Visitante> visitantes = DAOVisitante.consultarVisitantes();
            for(Visitante visitante : visitantes){
                visitante.setmoradorResponsavel(visitante.getmoradorResponsavel().getId());
            }
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
