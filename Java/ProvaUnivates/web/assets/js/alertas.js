function avisoNegacao(mensagem) {
    Swal.fire({
        text: mensagem,
        icon: "warning",
        showCancelButton: false,
        confirmButtonColor: "#ff0000",
        confirmButtonText: "Ok"
    });
}

function alertSucesso(mensagem) {
    Swal.fire({
        text: mensagem,
        icon: "success",
        showCancelButton: false,
        confirmButtonColor: "#00B2B3",
        confirmButtonText: "Ok"
    });
}

