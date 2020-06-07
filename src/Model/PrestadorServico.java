package Model;

public class PrestadorServico extends Pessoa {

    private Pessoa fkEmpresa;

    private String descricaoServico;

    private Morador moradorRequisitante;

    public Pessoa getFkEmpresa() {
        return this.fkEmpresa;
    }

    public Morador getMoradorRequisitante() {
        return this.moradorRequisitante;
    }

    public void setMoradorRequisitante(Morador moradorRequisitante) {
        this.moradorRequisitante = moradorRequisitante;
    }

    public String getDescricaoServico() {
        return this.descricaoServico;
    }

    public void setDescricaoServico(String descricaoServico) {
        this.descricaoServico = descricaoServico;
    }

    public void setFkEmpresa(Pessoa fkEmpresa) {
        this.fkEmpresa = fkEmpresa;
    }
}