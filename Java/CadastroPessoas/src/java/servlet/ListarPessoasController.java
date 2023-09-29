package servlet;

import dao.CurriculoDAO;
import entidade.Curriculo;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/listarPessoas")
public class ListarPessoasController extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CurriculoDAO dao = new CurriculoDAO();
        List<Curriculo> lista = dao.buscarCurriculos();
        request.setAttribute("pessoas", lista);
        RequestDispatcher rd = request.getRequestDispatcher("listarPessoas.jsp");
        rd.forward(request, response);
    }
    
}
