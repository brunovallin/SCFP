package Model;

public class PrestadorServico extends Pessoa {

    private Pessoa fkEmpresa;

    private String descricaoServico;

    private Morador moradorRequisitante;

    public Pessoa getFkEmpresa() {
        return fkEmpresa;
    }

    public Morador getMoradorRequisitante() {
        return moradorRequisitante;
    }

    public void setMoradorRequisitante(Morador moradorRequisitante) {
        this.moradorRequisitante = moradorRequisitante;
    }

    public String getDescricaoServico() {
        return descricaoServico;
    }

    public void setDescricaoServico(String descricaoServico) {
        this.descricaoServico = descricaoServico;
    }

    public void setFkEmpresa(Pessoa fkEmpresa) {
        this.fkEmpresa = fkEmpresa;
    }
}