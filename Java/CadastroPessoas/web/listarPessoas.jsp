<%-- 
    Document   : listarPessoas
    Created on : 19/09/2023, 18:22:29
    Author     : Lorenzo.busolli
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="assets/css/estilizacao.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css">
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <script src="https://kit.fontawesome.com/027e0b0de3.js" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.7.5/dist/sweetalert2.all.min.js"></script>
        <link href="https://cdn.jsdelivr.net/npm/sweetalert2@11.7.5/dist/sweetalert2.min.css" rel="stylesheet">
        
    </head>
    <body>
        
        <div class="row mt-5">
            <div class="col-1"></div>
            <div class="col-10 text-center">
                <h1>Listagem de currículos</h1>
            </div>
            <div class="col-1"></div>
        </div>
        
        <div class="row mt-5"> 
            <div class="col-2"></div>
            <div class="col-8">
                <table class="table">
                    <thead>
                        <tr>
                            <th class="text-center">Id</th>
                            <th class="text-center">Nome</th>
                            <th class="text-center">Email</th>
                            <th class="text-center">Telefone</th>
                            <th class="text-center">Data de Nascimento</th>
                            <th class="text-center">Editar</th>
                            <th class="text-center">Excluir</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="pessoa" items="${pessoas}">
                            <tr>
                                <td class="text-center">${pessoa.codId}</td>
                                <td class="text-center">${pessoa.nome}</td>
                                <td class="text-center">${pessoa.email}</td>
                                <td class="text-center">${pessoa.telefone}</td>
                                <td class="text-center">${pessoa.dataNascimento}</td>
                                <td class="text-center"><a href="#"><i style="color:black;" class="fa-solid fa-pencil text-center"></i></a></td>
                                <td class="text-center"><a href="#"><i style="color:black;" class="fa-solid fa-trash text-center"></i></a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="col-2"></div>
        </div>
        
        <div class="row mt-5" hidden>
            <div class="col-1"></div>
            <div class="col-10 text-center">
                <button class="btn btn-sm btn-primary" id="atualizar-curriculo">Atualizar Currículo</button>
            </div>
            <div class="col-1"></div>
        </div>
        
        <div class="row mt-5">
            <div class="col-1"></div>
            <div class="col-10 text-center">
                <a href="index.jsp">Voltar</a>
            </div>
            <div class="col-1"></div>
        </div>
        
        <script language="JavaScript" src="assets/js/deletar-curriculo.js"></script>
        <script language="JavaScript" src="assets/js/alertas.js"></script>
        
    </body>
</html>
