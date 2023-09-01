$(function(){
    submeterFormulario()
})

const submeterFormulario = () => {
    $("#botao").click(function(){
        let selectList = $("#select-comentar-sobre").val();
        let textarea = $("#textarea-comentario").val();
        let nota = $("#nota-curriculo").val();

        if(selectList == "<-------Escolha uma opção------->" || textarea.length < 100 
        || textarea.length > 200 || nota == "" || nota == undefined || nota > 10 || nota < 0){
            alerta();
        } else{
            sucesso();
        }
    })
} 

const alerta = () => {
    Swal.fire({
        icon: 'error',
        text: 'Preencha todos os campos adequadamente!',
    })
}

const sucesso = () => {
    Swal.fire({
        text: "Você está certo da nota e dos comentários?",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Sim, confirmo'
      }).then((result) => {
        if (result.isConfirmed) {
            redirecionarParaPaginaSucesso()
        }
      })
}

const redirecionarParaPaginaSucesso = () => {
    window.location.href = "/sucesso.html";
} 