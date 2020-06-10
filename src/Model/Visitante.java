package Model;

import Enum.TipoVisitante;

public class Visitante extends Pessoa {

    private Morador moradorAVisitar;

    private TipoVisitante tipoVisitante;    

    public TipoVisitante getTipoVisitante() {
        return tipoVisitante;
    }

    public void setTipoVisitante(TipoVisitante tipoVisitante) {
        this.tipoVisitante = tipoVisitante;
    }

    public Morador getMoradorAVisitar() {
        return this.moradorAVisitar;
    }

    public void setMoradorAVisitar(Morador moradorAVisitar) {
        this.moradorAVisitar = moradorAVisitar;
    }
}
