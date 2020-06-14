package Controller;

import java.util.ArrayList;
import java.util.Date;

import Enum.TipoFuncionario;
import Model.Funcionario;

public class FuncionarioController {


    public Funcionario consultaFuncionario(String documento) throws Exception{

        try {
            final Funcionario funcionario = new Funcionario();

            funcionario.consultaFuncionario(documento.replace(".", "").replace("-", "").replace("/", ""));

            return funcionario;

        } catch (final Exception e) {

            throw e;
        }
    }

    public ArrayList<Funcionario> consultaTodosFuncionarios() throws Exception{
        
        try {
            final ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();

            funcionarios.add(new Funcionario());
            funcionarios.addAll(new ArrayList<Funcionario>());

            return funcionarios;

        } catch (final Exception e) {
            
            throw e;
        }
    }

    public void cadastrarFuncionario(String nome, String dtNasc, String documento, String tipoFuncionario ) throws Exception{
        try {
            Funcionario funcionario = new Funcionario();

            funcionario.setNome(nome);
            funcionario.setDtNascimento(dtNasc);
            funcionario.setDocumento(documento.replace(".", "").replace("-", "").replace("/", ""));

            switch (tipoFuncionario) {
                case "SINDICO":
                    funcionario.setTipoFuncionario(TipoFuncionario.SINDICO);
                    break;
                
                case "PORTEIRO":
                    funcionario.setTipoFuncionario(TipoFuncionario.PORTEIRO);
                    break;
            
                case "ZELADOR":
                    funcionario.setTipoFuncionario(TipoFuncionario.ZELADOR);
                    break;

                case "SEGURANCA":
                    funcionario.setTipoFuncionario(TipoFuncionario.SEGURANCA);
                    break;
                default:
                    break;
            }


            funcionario.cadastrarFuncionario();

        } catch (Exception e) {
           throw e;
        }

    }

    public void alterarFuncionario(String nome, String dtNasc, String documento, String tipoFuncionario){

        try {
            Funcionario funcionario = new Funcionario();

            funcionario.setNome(nome);
            funcionario.setDtNascimento(dtNasc);
            funcionario.setDocumento(documento.replace(".", "").replace("-", "").replace("/", ""));

            switch (tipoFuncionario) {
                case "SINDICO":
                    funcionario.setTipoFuncionario(TipoFuncionario.SINDICO);
                    break;
                
                case "PORTEIRO":
                    funcionario.setTipoFuncionario(TipoFuncionario.PORTEIRO);
                    break;
            
                case "ZELADOR":
                    funcionario.setTipoFuncionario(TipoFuncionario.ZELADOR);
                    break;

                case "SEGURANCA":
                    funcionario.setTipoFuncionario(TipoFuncionario.SEGURANCA);
                    break;
                default:
                    break;
            }


            funcionario.alterarFuncionario();

        } catch (Exception e) {
           throw e;
        }
    }

    public void excluirFuncionario(String documento) throws Exception{
        try {
            Funcionario funcionario = new Funcionario();

            funcionario.excluirFuncionario(documento.replace(".", "").replace("-", "").replace("/", ""));

        } catch (Exception e) {

            throw e;

        }
        
        
    }
    

}