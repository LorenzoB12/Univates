<% Boolean erro = (Boolean) request.getAttribute("erro"); %>

<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
    <div class="row mt-5">
        <div class="col-4"></div>
        <div class="col-4">
            <form action="/logar" method="post">
            Login: <input type="text" name="login">
            Senha: <input type="password" name="senha">
                <input type="hidden" name="acao" value="Login">
                <input class="btn btn-success" type="submit">
            </form>
            <% if (erro != null && erro) { %>
                <p style="color: red;">Erro: Nome de usuário ou senha incorretos.</p>
            <% } %>
        </div>
        <div class="col-4"></div>
    </div>
</body>
</html>