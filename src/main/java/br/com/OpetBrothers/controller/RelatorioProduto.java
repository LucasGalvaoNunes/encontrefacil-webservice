package br.com.OpetBrothers.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import br.com.OpetBrothers.dto.ProdutoEntityDTO;
import br.com.OpetBrothers.jasper.JasperFactory;
import br.com.OpetBrothers.repository.ProdutoRepository;
import br.com.OpetBrothers.repository.entity.ProdutoEntity;

@WebServlet("/RelatorioProdutos/*")
public class RelatorioProduto extends HttpServlet{
	private ProdutoRepository repository;
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RelatorioProduto()
    {
        super();
    }
    
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    	String pathInfo = request.getPathInfo();
    	String[] pathParts = pathInfo.split("/");
    	int id = Integer.parseInt(pathParts[1]);
    	repository = new ProdutoRepository();
        try
        {
            JasperReport jasperReport = JasperFactory.getRelacaoAlunos();
    
            response.setHeader("Content-Disposition", "inline; filename=\"application.pdf\"");
            response.setContentType("application/pdf");
            
    
            // Obtendo a lista de alunos
            ProdutoEntityDTO tDto = repository.RelatorioLoja(id);
            if (tDto.isOk())
            {
                List<ProdutoEntity> tLista = tDto.getLista();
    
                JRDataSource dataSource = new JRBeanCollectionDataSource(tLista);
    
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,
                                null, dataSource);                     
                OutputStream outStream = response.getOutputStream();
                JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
            }
        }
        catch (JRException tExcept)
        {
            throw new ServletException("Problemas na geração do relatórios geral dos alunos", tExcept);
        }
        //response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        doGet(request, response);
    }
}
