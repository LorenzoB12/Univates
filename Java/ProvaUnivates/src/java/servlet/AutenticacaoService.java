package servlet;

import java.util.Arrays;
import java.util.Optional;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AutenticacaoService {

    public static void setCookie(HttpServletResponse response, String desUsuario) {
        desUsuario = desUsuario.replace(" ", "_");
        Integer tempoExpiracaoCookie = (60 * 60 * 12); //12 horas
        Cookie cookie = new Cookie("usuario", desUsuario);
        cookie.setMaxAge(tempoExpiracaoCookie);
        response.addCookie(cookie);
    }

    public static String getCookie(HttpServletRequest request) {
        String usuario = "usuario";
        return Optional.ofNullable(request.getCookies())
                .flatMap(cookies -> Arrays.stream(cookies)
                .filter(cookie -> usuario.equals(cookie.getName()))
                .findAny())
                .map(e -> e.getValue())
                .orElse(null);
    }
    
    
}
