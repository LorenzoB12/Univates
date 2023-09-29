package servlet;

import apoio.ConexaoBD;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logar")
public class LogarController extends HttpServlet{
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("login");
        String senha = request.getParameter("senha");
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        
        Connection conn = new ConexaoBD().getConnection();
        try {
            String sql = "SELECT NOME, SENHA FROM USUARIOS WHERE NOME = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, nome);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                String senhaBd = resultSet.getString("senha");
                if(senhaBd.equals(senha)){
                    HttpSession sessao = request.getSession();
                    sessao.setAttribute("usuarioLogado", nome);
                    request.setAttribute("erro", false);
                    rd.forward(request, response);
                    return;
                }
            }
            
            request.setAttribute("erro", true);
            rd = request.getRequestDispatcher("formLogin.jsp");
            rd.forward(request, response);
            
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
