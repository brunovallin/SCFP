package Model;

import java.util.Date;

public class LogEntrada {

    private Pessoa pessoa;

    private String descricaoAcao;

    private Date dataEntrada;

    private Morador aVisitar;

    public Pessoa getIdPessoa() {
        return this.pessoa;
    }

    public Morador getaVisitar() {
        return aVisitar;
    }

    public void setaVisitar(Morador aVisitar) {
        this.aVisitar = aVisitar;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public String getDescricaoAcao() {
        return descricaoAcao;
    }

    public void setDescricaoAcao(String descricaoAcao) {
        this.descricaoAcao = descricaoAcao;
    }

    public void setIdPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}