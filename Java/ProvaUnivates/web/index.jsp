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
            <style>
        ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
        }

        li {
            display: inline-block;
            margin-right: 20px;
            position: relative;
        }

        a {
            text-decoration: none;
        }
        ul ul {
            display: none;
            position: absolute;
            top: 100%;
            left: 0;
            background-color: #f1f1f1;
        }

        li:hover ul {
            display: block;
        }

        ul ul li {
            display: block;
            width: 150px;
            text-align: left;
        }
    </style>
    </head>
    <body>

        <div class="row text-center mt-5">
            <h4>Menu</h4>
        </div>

        <div class="row ml-3 mt-3">
            <div class="col-4"></div>
            <div class="col-4 text-center">
                <ul class="text-center">
                    <li class="text-center">
                        <a href="#" class="text-center">PROVA</a>
                        <ul class="text-center">
                            <li class="text-center"><a href="titulo-financeiro.jsp" class="text-center">PRESENCIAL</a></li>
                        </ul>
                    </li>
                </ul>
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
