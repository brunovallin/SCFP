package Model;

public class Visitante extends Pessoa {
    private String rg;

    private Morador moradorAVisitar;

    public String getRg() {
        return this.rg;
    }

    public Morador getMoradorAVisitar() {
        return this.moradorAVisitar;
    }

    public void setMoradorAVisitar(Morador moradorAVisitar) {
        this.moradorAVisitar = moradorAVisitar;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }
}
