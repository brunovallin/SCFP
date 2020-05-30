package Model;

public class Visitante extends Pessoa {
    private String rg;

    private Morador moradorAVisitar;

    public String getRg() {
        return rg;
    }

    public Morador getMoradorAVisitar() {
        return moradorAVisitar;
    }

    public void setMoradorAVisitar(Morador moradorAVisitar) {
        this.moradorAVisitar = moradorAVisitar;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }
}
