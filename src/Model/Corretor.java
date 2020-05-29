package Model;

public class Corretor extends Pessoa {
    private String creci;

    private Pessoa fkImobiliaria;

    public String getCreci() {
        return creci;
    }

    public Pessoa getFkImobiliaria() {
        return fkImobiliaria;
    }

    public void setFkImobiliaria(Pessoa fkImobiliaria) {
        this.fkImobiliaria = fkImobiliaria;
    }

    public void setCreci(String creci) {
        this.creci = creci;
    }

    
}