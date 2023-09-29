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
        <script src="https://kit.fontawesome.com/027e0b0de3.js" crossorigin="anonymous"></script>
        
        <title>Título Financeiro</title>
    </head>
    <body>
        <div class="row mt-5">
            <div class="col-3"></div>
            <div class="col-6 text-center">
                <h1>Título Financeiro</h1>
            </div>
            <div class="col-3"></div>
        </div>

        <div class="row mt-3">
            <div class="col-3"></div>
            <div class="col-6">
                <div class="card">
                    <div class="card-head">Cadastro de Título</div>
                    <div class="card-body">
                        <div class="row">
                            <div class="col-12">
                                <input type="hidden" id="id" name="id">
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-12">
                                <label class="form-label" for="name">Pessoa: </label>
                                <select class="form-select" type="text" id="pessoa" name="pessoa">
                                    <option val="0">Selecione uma opção</option>
                                </select>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-12 mt-3">
                                <label class="form-label" for="mail">Data Vencimento: </label>
                                <input class="form-control" type="date" id="data-vencimento" name="data-vencimento" />
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-12 mt-3">
                                <label class="form-label" for="telefone">Valor Devido: </label>
                                <input class="form-control" type="number" id="valor-devido" name="valor-devido" />
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-12 mt-3">
                                <label class="form-label" for="mail">Data Pagamento: </label>
                                <input class="form-control" type="date" id="data-pagamento" name="data-pagamento" />
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-12 mt-3">
                                <label class="form-label" for="telefone">Valor Pago: </label>
                                <input class="form-control" type="number" id="valor-pago" name="valor-pago" />
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
        
        <div class="row mt-5"> 
            <div class="col-2"></div>
            <div class="col-8">
                <table class="table" id="tabela">
                    <thead>
                        <tr>
                            <th class="text-center">Id</th>
                            <th class="text-center">Cod Pessoa</th>
                            <th class="text-center">Data de Vencimento</th>
                            <th class="text-center">Valor Devido</th>
                            <th class="text-center">Data de Pagamento</th>
                            <th class="text-center">Valor Pago</th>
                            <th class="text-center">Editar</th>
                            <th class="text-center">Excluir</th>
                        </tr>
                    </thead>
                    <tbody>
                    </tbody>
                </table>
            </div>
            <div class="col-2"></div>
        </div>
        
        <!-- JS DA PÁGINA -->
        <script language="JavaScript" src="assets/js/financeiro.js"></script>
        <script language="JavaScript" src="assets/js/alertas.js"></script>
        
    </body>
</html>
