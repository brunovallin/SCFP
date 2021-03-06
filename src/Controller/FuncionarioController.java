package Controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Enum.TipoFuncionario;
import Model.Funcionario;
import Model.DAO.DAOFuncionario;

public class FuncionarioController {


    public static Funcionario consultaFuncionario(String rg) throws Exception{

        try {
            Funcionario funcionario = new Funcionario();

            funcionario.consultarFuncionario(rg.replace(".", "").replace("-", "").replace("/", ""));

            return funcionario;

        } catch (final Exception e) {

            throw e;
        }
    }

    public static ArrayList<Funcionario> consultaTodosFuncionarios() throws Exception{
        
        try{

            return DAOFuncionario.consultarTodosFuncionarios();

        } catch (final Exception e) {
            
            throw e;
        }
    }

    public static void cadastrarFuncionario(String nome, String dtNasc, String rg, String tipoFuncionario ) throws Exception{
        try {
            Funcionario funcionario = new Funcionario();
            SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");


            funcionario.setNome(nome);
            funcionario.setDtNascimento((Date)data.parse(dtNasc));
            funcionario.setRg(rg.replace(".", "").replace("-", "").replace("/", ""));

            switch (tipoFuncionario.toUpperCase()) {
                case "FAXINEIRA":
                    funcionario.setTipoFuncionario(TipoFuncionario.FAXINEIRA);
                    break;
                
                case "PORTEIRO":
                    funcionario.setTipoFuncionario(TipoFuncionario.PORTEIRO);
                    break;
            
                case "ZELADOR":
                    funcionario.setTipoFuncionario(TipoFuncionario.ZELADOR);
                    break;

                case "SEGURANÇA":
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

    public static void alterarFuncionario(String nome, String dtNasc, String rg, String tipoFuncionario) throws Exception {

        try {
            Funcionario funcionario = new Funcionario();
            SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");

            funcionario.setNome(nome);
            funcionario.setDtNascimento((Date)data.parse(dtNasc));
            funcionario.setRg(rg.replace(".", "").replace("-", "").replace("/", ""));
            

            switch (tipoFuncionario) {
                case "FAXINEIRA":
                    funcionario.setTipoFuncionario(TipoFuncionario.FAXINEIRA);
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

    public static void excluirFuncionario(int id) throws Exception{
        try {
            Funcionario.excluirFuncionario(id);            
        } catch (Exception e) {

            throw e;

        }
        
        
    }
    

}