<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="assets/css/estilizacao.css">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css">
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.7.5/dist/sweetalert2.all.min.js"></script>
        <link href="https://cdn.jsdelivr.net/npm/sweetalert2@11.7.5/dist/sweetalert2.min.css" rel="stylesheet">
        
        <title>JSP Page</title>
    </head>
    <body>
        <div class="row mt-5">
            <div class="col-3"></div>
            <div class="col-6 text-center">
                <h1>Currículo</h1>
            </div>
            <div class="col-3"></div>
        </div>

        <div class="row mt-3">
            <div class="col-3"></div>
            <div class="col-6">
                <div class="card">
                    <div class="card-head">Cadastro de Currículo</div>
                    <div class="card-body">
                        <div class="row">
                            <div class="col-12">
                                <label class="form-label" for="name">Nome:</label>
                                <input class="form-control" type="text" id="nome" name="nome_pessoa" />
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-12 mt-3">
                                <label class="form-label" for="mail">E-mail:</label>
                                <input class="form-control" type="email" id="email" name="email" />
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-12 mt-3">
                                <label class="form-label" for="telefone">Telefone:</label>
                                <input class="form-control" type="text" id="telefone" name="telefone" />
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-12 mt-3">
                                <label class="form-label" for="data-nascimento">Data de Nascimento:</label>
                                <input class="form-control" type="date" id="data-nascimento" name="data-nascimento" />
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-12 mt-3 justify-content-between" style="display: flex;">
                                <button class="btn btn-secondary" onclick="location.href='index.jsp'">Voltar</button>
                                <button id="salvar-curriculo" class="btn btn-success">Salvar</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-3"></div>
        </div>
        
        <!-- JS DA PÁGINA -->
        <script language="JavaScript" src="assets/js/cadastrar-curriculo.js"></script>
        <script language="JavaScript" src="assets/js/alertas.js"></script>
        
    </body>
</html>
