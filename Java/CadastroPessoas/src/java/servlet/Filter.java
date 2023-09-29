package servlet;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Filter implements javax.servlet.Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        HttpSession sessao = request.getSession();
        Boolean usuarioNaoLogado = (sessao.getAttribute("usuarioLogado") == null);

        if (usuarioNaoLogado) {
            System.out.println("Necessário logar!");
            response.sendRedirect("/formLogin.jsp");
            return;
        }

        chain.doFilter(request, response);      
    }
}
