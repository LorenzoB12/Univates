$(function () {
    $("#salvar-curriculo").click(cadastrarCurriculo)
    buscarPessoas();
    buscarTitulos();
    deletar();
    editar();
})

function cadastrarCurriculo() {
    let codPessoa = $("#pessoa option:selected").val();
    let dtaVencimento = $("#data-vencimento").val();
    let valorDevido = $("#valor-devido").val();
    let dtaPagamento = $("#data-pagamento").val();
    let valorPago = $("#valor-pago").val();
    let id = $("#id").val();
    
    console.log(codPessoa);
    console.log(dtaVencimento);
    console.log(valorDevido);
    console.log(dtaPagamento);
    console.log(valorPago);

    let btn = $("#salvar-curriculo");

    if (codPessoa == 0 || dtaVencimento == "" || valorDevido == "" || dtaPagamento == "" || valorPago == "") {
        avisoNegacao("Ação inválida! Favor Preencher todos os dados");
    }

    else if(btn.attr("class").includes("editar")){
        objFinanceiro = {
            codPessoa,
            dtaVencimento: formatarData(dtaVencimento),
            valorDevido,
            dtaPagamento: formatarData(dtaPagamento),
            valorPago,
            id
        }
        
        $.ajax({
            type: "PUT",
            url: "/titulo-financeiro",
            contentType: 'application/json',
            dataType: "json",
            data: JSON.stringify(objFinanceiro),
            statusCode: {
                200: function (response) {
                    alertSucesso("Título editado com sucesso!");
                    $("#salvar-curriculo").removeClass("editar");
                    buscarTitulos();
                },
                400: function (response) {
                    avisoNegacao("Ação inválida!");
                },
                404: function (response) {
                    alert('Página não encontrada');
                },
                405: function (response) {
                    avisoNegacao("Ação inválida!");
                },
                500: function (response) {
                    avisoNegacao('Erro no servidor - Favor contatar o setor de TI');
                }
            }
        });
    } else {
        objFinanceiro = {
            codPessoa,
            dtaVencimento: formatarData(dtaVencimento),
            valorDevido,
            dtaPagamento: formatarData(dtaPagamento),
            valorPago
        }

        $.ajax({
            type: "POST",
            url: "/titulo-financeiro",
            contentType: 'application/json',
            dataType: "json",
            data: JSON.stringify(objFinanceiro),
            statusCode: {
                200: function (response) {
                    alertSucesso("Título cadastrado com sucesso!");
                    $("#salvar-curriculo").removeClass("editar");
                    buscarTitulos();
                },
                400: function (response) {
                    avisoNegacao("Ação inválida!");
                },
                404: function (response) {
                    alert('Página não encontrada');
                },
                405: function (response) {
                    avisoNegacao("Ação inválida!");
                },
                500: function (response) {
                    avisoNegacao('Erro no servidor - Favor contatar o setor de TI');
                }
            }
        });
    }
}

function formatarData(data) {
    if (!data.match(/^\d{4}-\d{2}-\d{2}$/)) {
        return "";
    }

    const partes = data.split("-");
    return partes[2] + "/" + partes[1] + "/" + partes[0];
}

function formatarDataBrasileiraParaISO(dataBrasileira) {
    var partes = dataBrasileira.split('/');
    if (partes.length !== 3) {
        return ""
    }
    var dia = partes[0];
    var mes = partes[1];
    var ano = partes[2];
    var dataISO = ano + '-' + mes + '-' + dia;
    return dataISO;
}


function buscarPessoas() {
    $.ajax({
        type: "GET",
        url: "/pessoa",
        statusCode: {
            200: function (response) {
                console.log(response);
                construirSelectList(response)
            },
            400: function (response) {
                avisoNegacao("Ação inválida!");
            },
            404: function (response) {
                alert('Página não encontrada');
            },
            405: function (response) {
                avisoNegacao("Ação inválida!");
            },
            500: function (response) {
                avisoNegacao('Erro no servidor - Favor contatar o setor de TI');
            }
        }
    });
}

function construirSelectList(dados) {
    let select = $("#pessoa");
    var pessoasArray = JSON.parse(dados);
    $.each(pessoasArray, function (chave, valor) {
        let option = $("<option>").text(valor.nome + " - " + valor.email + " - " + valor.telefone).val(valor.codId);
        select.append(option)
    })
}

function buscarTitulos() {
    $.ajax({
        type: "GET",
        url: "/titulo-financeiro",
        statusCode: {
            200: function (response) {
                console.log(response);
                construirTabela(response);
            },
            400: function (response) {
                avisoNegacao("Ação inválida!");
            },
            404: function (response) {
                alert('Página não encontrada');
            },
            405: function (response) {
                avisoNegacao("Ação inválida!");
            },
            500: function (response) {
                avisoNegacao('Erro no servidor - Favor contatar o setor de TI');
            }
        }
    });
}


function construirTabela(dados) {
    let tabela = $("#tabela");
    let tbody = $("#tabela tbody").empty();
    var titulosArray = JSON.parse(dados);
    console.log(titulosArray);
    $.each(titulosArray, function (chave, valor) {
        let td = $("<td>").text(valor.id);
        let td2 = $("<td>").text(valor.codPessoa);
        let td3 = $("<td>").text(valor.dtaVencimento);
        let td4 = $("<td>").text(valor.valorDevido);
        let td5 = $("<td>").text(valor.dtaPagamento);
        let td6 = $("<td>").text(valor.valorPago);
        let td7 = $("<td>").addClass("editar");
        let edicao = $("<i>").addClass("fa-solid fa-pencil editar");
        td7.append(edicao);
        let td8 = $("<td>").addClass("deletar");
        let lixeira = $("<i>").addClass("fa-solid fa-trash deletar");
        td8.append(lixeira)
        let tr = $("<tr>").append(td);
        tr.append(td2);
        tr.append(td3);
        tr.append(td4);
        tr.append(td5);
        tr.append(td6);
        tr.append(td7);
        tr.append(td8);
        tabela.append(tr);
    })
}

function deletar() {
    $("#tabela").on("click", ".deletar", function () {
        console.log("deletado")
        console.log(this)
        let linhaDeletar = $(this).parent();
        let codId = linhaDeletar.find("td:first-child").text();

        $.ajax({
            type: "DELETE",
            url: "/titulo-financeiro?id=" + codId,
            statusCode: {
                200: function (response) {
                    alertSucesso("Titulo deletado com sucesso!");
                    buscarTitulos();
                },
                400: function (response) {
                    avisoNegacao("Ação inválida!");
                },
                404: function (response) {
                    alert('Página não encontrada');
                },
                405: function (response) {
                    avisoNegacao("Ação inválida!");
                },
                500: function (response) {
                    avisoNegacao('Erro no servidor - Favor contatar o setor de TI');
                }
            }
        })
    })
}

function editar(){
    $("#tabela").on("click", ".editar", function(){
        console.log("oi")
        let editar = $(this).parent();
        let id = editar.find("td:first-child").text();
        let codPessoa = editar.find("td:nth-child(2)").text();
        let dtaVencimento = editar.find("td:nth-child(3)").text();
        let valorDevido = editar.find("td:nth-child(4)").text();
        let dtaPagamento = editar.find("td:nth-child(5)").text();
        let valorPago = editar.find("td:nth-child(6").text();
        
        console.log(id);
        console.log(codPessoa);
        console.log(dtaVencimento);
        console.log(valorDevido);
        console.log(dtaPagamento);
        console.log(valorPago);
        
        let dtaVencimentoForm = formatarDataBrasileiraParaISO(dtaVencimento);
        let dtaPagamentoForm = formatarDataBrasileiraParaISO(dtaPagamento)
        
        console.log(formatarDataBrasileiraParaISO(dtaPagamento))
        
        $("#id").val(id);
        $("#pessoa").val(codPessoa);
        $("#data-vencimento").val(dtaVencimentoForm);
        $("#valor-devido").val(valorDevido);
        $("#data-pagamento").val(dtaPagamentoForm);
        $("#valor-pago").val(valorPago);
        
        $("#salvar-curriculo").addClass("editar");
    })
}