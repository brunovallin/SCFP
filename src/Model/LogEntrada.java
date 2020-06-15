package Model;

import java.util.ArrayList;
import java.util.Date;

import Model.DAO.DAOLogEntrada;

public class LogEntrada {

    private Pessoa visitante;

    private String descricaoAcao;

    private Date dataEntrada;

    private Morador aVisitar;

    public Pessoa getVisitante() {
        return this.visitante;
    }

    public Morador getaVisitar() {
        return aVisitar;
    }

    public void setaVisitar(Morador aVisitar) {
        this.aVisitar = aVisitar;
    }

    public void setaVisitar(int id) {
        Morador morador = new Morador();
        morador.setId(id);
        this.aVisitar = morador;
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

    public void setPessoa(Pessoa pessoa) {
        this.visitante = pessoa;
    }
    public void setPessoa(int id){
        Pessoa pessoa = new Pessoa();
        pessoa.setId(id);
        this.visitante = pessoa;
    }

    public static ArrayList<LogEntrada> consultaEntradaDia(Date data) throws Exception {
        try {
            return DAOLogEntrada.consultaLogEntradaDia(data);
        } catch (Exception e) {
            throw e;
        }
    }
    public void cadastrarLogEntrada() throws Exception {
        try {
            DAOLogEntrada.cadastrarLogEntrada(this);
        } catch (Exception e) {
            throw e;
        }
    }
}