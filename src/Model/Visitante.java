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

    public void consultarMorador(String rg) throws Exception {
		try {
			Visitante morador = DAOVisitante.consultarVisitante(rg);
			this.setId(morador.getId());
			this.setNome(morador.getNome());
			this.setDtNascimento(morador.getDtNascimento());
			this.setRg(morador.getRg());
			this.setmoradorResponsavel(morador.getmoradorResponsavel());
            this.setmoradorResponsavel(morador.getmoradorResponsavel().getId());
            this.setTipoVisitante(morador.getTipoVisitante());            
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

    public static void excluitVisitante(int id) throws Exception{
        try {
            DAOVisitante.excluirVisitante(id);
        } catch (Exception e) {
            throw e;
        }
    }
}
