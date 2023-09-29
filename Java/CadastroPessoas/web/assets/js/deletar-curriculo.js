$(function () {
    detectaClickDeletarCurriculo();
    detectaClickAtualizarCurriculo();
    detectaClickBtnAtualizarCurriculo();
})

function detectaClickDeletarCurriculo() {
    $(".fa-trash").click(function () {
        let linha = $(this).parent().parent().parent();
        deletarCurriculo(linha);
    })
}

function deletarCurriculo(linha) {
    let codId = linha.find("td:first-child").text();
    let nome = linha.find("td:nth-child(2)").text();
    let email = linha.find("td:nth-child(3)").text();
    let telefone = linha.find("td:nth-child(4)").text();
    let dataNascimento = linha.find("td:nth-child(5)").text();

    objCurriculo = {
        codId,
        nome,
        email,
        telefone,
        dataNascimento
    }

    $.ajax({
        type: "DELETE",
        url: "/pessoa",
        contentType: 'application/json',
        dataType: "json",
        data: JSON.stringify(objCurriculo),
        statusCode: {
            200: function (response) {
                location.reload();
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

function detectaClickAtualizarCurriculo() {
    $(".fa-pencil").click(function () {
        let edicao = $(this).parent().parent().parent().parent().find("tr.editavel").length == 0 ? true : false;
        if (edicao) {
            let linha = $(this).parent().parent().parent();
            let outrasLinhas = $(this).parent().parent().parent().parent();
            $.each(outrasLinhas, function (chave, valor) {
                $(valor).removeClass("editavel");
            });
            linha.addClass("editavel");
            construirInputsParaAtualizarCurriculo(linha);
        } else{
            avisoNegacao("Você precisa finalizar a edição que está em andamento!")
        }
    });
}

function construirInputsParaAtualizarCurriculo(linha) {
    let tds = linha.find("td");
    console.log(tds)
    $.each(tds, function (chave, valor) {
        $("#atualizar-curriculo").parent().parent().attr("hidden", false);
        if (chave != 0 && chave != 5 && chave != 6) {
            let td = $(valor);
            let texto = td.text();
            let input = $("<input>").val(texto);
            td.text("");
            td.append(input);
        }
    });
}

function atualizarCurriculo() {
    let codId = $(".editavel").find("td:first-child").text();
    let nome = $(".editavel").find("td:nth-child(2) input").val();
    let email = $(".editavel").find("td:nth-child(3) input").val();
    let telefone = $(".editavel").find("td:nth-child(4) input").val();
    let dataNascimento = $(".editavel").find("td:nth-child(5) input").val();

    objCurriculo = {
        codId,
        nome,
        email,
        telefone,
        dataNascimento
    }

    console.log(objCurriculo);

    $.ajax({
        type: "PUT",
        url: "/pessoa",
        contentType: 'application/json',
        dataType: "json",
        data: JSON.stringify(objCurriculo),
        statusCode: {
            200: function (response) {
                location.reload();
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

function detectaClickBtnAtualizarCurriculo() {
    $("#atualizar-curriculo").click(atualizarCurriculo);
}