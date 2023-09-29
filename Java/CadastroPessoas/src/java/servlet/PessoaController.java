/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.CurriculoDAO;
import entidade.Curriculo;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/pessoa")
public class PessoaController extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        rd.forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        InputStream requestBody = request.getInputStream();
        Curriculo curriculo = mapper.readValue(requestBody, Curriculo.class);
        new CurriculoDAO().cadastrarCurriculo(curriculo);
    }

    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        InputStream requestBody = request.getInputStream();
        Curriculo curriculo = mapper.readValue(requestBody, Curriculo.class);
        System.out.println(curriculo.getCodId());
        System.out.println(curriculo.getNome());
        System.out.println(curriculo.getEmail());
        System.out.println(curriculo.getTelefone());
        System.out.println(curriculo.getDataNascimento());
        new CurriculoDAO().editarCurriculo(curriculo);
    }
    
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        InputStream requestBody = request.getInputStream();
        Curriculo curriculo = mapper.readValue(requestBody, Curriculo.class);
        new CurriculoDAO().excluirCurriculo(curriculo.getCodId());
    }
}
