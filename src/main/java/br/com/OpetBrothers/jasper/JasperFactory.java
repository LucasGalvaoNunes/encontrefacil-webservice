package br.com.OpetBrothers.jasper;

import java.io.IOException;
import java.io.InputStream;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;

public class JasperFactory {
	    
	private static JasperReport pRelatorioJasper;

    public static JasperReport getRelacaoAlunos() throws JRException
    {
        if (pRelatorioJasper == null)
        {
            try
            {
                // Abrindo o arquivo JRXML
                InputStream tArqEntrada = JasperFactory.class.getResourceAsStream("Produtos.jrxml");

                // Compilando o arquivo JRXML
                pRelatorioJasper = JasperCompileManager.compileReport(tArqEntrada);

                // Fechando o arquivo JRXML
                tArqEntrada.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }

        // Retornando o relatório compilado
        return pRelatorioJasper;
    }
}
