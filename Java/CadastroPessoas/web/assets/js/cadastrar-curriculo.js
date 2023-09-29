$(function () {
    $("#salvar-curriculo").click(cadastrarCurriculo);
})

function cadastrarCurriculo() {
    let nome = $("#nome").val();
    let email = $("#email").val();
    let telefone = $("#telefone").val();
    let dataNascimento = $("#data-nascimento").val();

    if (nome == "" || email == "" || telefone == "" || dataNascimento == "") {
        avisoNegacao("Ação inválida! Favor Preencher todos os dados");

    } else {
        objCurriculo = {
            nome,
            email,
            telefone,
            dataNascimento: formatarData(dataNascimento)
        }

        $.ajax({
            type: "POST",
            url: "/pessoa",
            contentType: 'application/json',
            dataType: "json",
            data: JSON.stringify(objCurriculo),
            statusCode: {
                200: function (response) {
                    $("#nome").val("");
                    $("#email").val("");
                    $("#telefone").val("");
                    $("#data-nascimento").val("");
                    alertSucesso("Currículo cadastrado com sucesso!");
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