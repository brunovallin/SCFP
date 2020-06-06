package Controller;

import java.util.Date;
import Model.Corretor;

public class CorretorController {
    
    public static void cadastraCorretor(String nome, Date dtNasc, String documento, String creci, int imobiliaria) throws Exception{
        try {                        
            Corretor corr = new Corretor();
            corr.setNome(nome);
            corr.setDocumento(documento.replace(".", "").replace("-","").replace("/",""));                        
            corr.setDtNascimento(dtNasc);
            corr.setCreci(creci);

            corr.cadastraCorretor();
                                    
        } catch (Exception e) {
            throw e; 
        }        
    }

    public static Corretor consultaCorretor(String creci){
        try {
        } catch (Exception e) {
            throw e;
        }

    }
}