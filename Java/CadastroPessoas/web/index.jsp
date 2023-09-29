<%-- 
    Document   : index
    Created on : 06/03/2020, 09:58:04
    Author     : pretto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="assets/css/estilizacao.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css">
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

    </head>
    <body>

        <div class="row text-center mt-5">
            <h4>Menu</h4>
        </div>

        <div class="row ml-3">
            <div class="col-4"></div>
            <div class="col-4 text-center">
                <nav class="navbar navbar-light bg-light text-center">
                    <div class="container-fluid text-center">
                        <a href="cadPessoa.jsp">CADASTRO</a>
                    </div>
                </nav>
                <nav class="navbar navbar-light bg-light text-center">
                    <div class="container-fluid text-center">
                        <a href="listarPessoas">LISTAGEM / EDIÇÃO / EXCLUSÃO</a>
                    </div>
                </nav>
            </div>
            <div class="col-4"></div>
        </div>
        
        <div class="row mt-5">
            <div class="col-4"></div>
            <div class="col-4 text-center">
                <a href="/logout">Logout</a>
            </div>
            <div class="col-4"></div>
        </div>

    </body>
</html>
