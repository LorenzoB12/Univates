/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.CurriculoDAO;
import dao.PessoasDAO;
import dao.TituloFinanceiroDAO;
import entidade.Curriculo;
import entidade.Pessoas;
import entidade.TituloFinanceiro;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author loren
 */


@WebServlet("/titulo-financeiro")
public class TituloFinanceiroController extends HttpServlet {
    
    private PessoasDAO dao = new PessoasDAO();
    private TituloFinanceiroDAO titulosDao = new TituloFinanceiroDAO();
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<TituloFinanceiro> lista = titulosDao.buscarTitulos();
        request.setAttribute("titulos", lista);
        ObjectMapper objectMapper = new ObjectMapper();
        String pessoasJSON = objectMapper.writeValueAsString(lista);
        PrintWriter out = response.getWriter();
        out.print(pessoasJSON);
        
        System.out.println(lista.get(0).getValorDevido());
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        InputStream requestBody = request.getInputStream();
        TituloFinanceiro titulo = mapper.readValue(requestBody, TituloFinanceiro.class);
        new TituloFinanceiroDAO().cadastrarTitulo(titulo);
    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        InputStream requestBody = request.getInputStream();
        TituloFinanceiro titulo = mapper.readValue(requestBody, TituloFinanceiro.class);
        new TituloFinanceiroDAO().editarTitulo(titulo);
    }
    
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*ObjectMapper mapper = new ObjectMapper();
        InputStream requestBody = request.getInputStream();
        TituloFinanceiro titulo = mapper.readValue(requestBody, TituloFinanceiro.class);*/
        String id = request.getParameter("id");
        Long idLong = Long.parseLong(id);
        
        new TituloFinanceiroDAO().excluirTitulo(idLong); 
    }
}
