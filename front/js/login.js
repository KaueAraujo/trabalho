function autenticar(event) {
    event.preventDefault(); //Interrompe a execução padrão de envio do formulário

    let usuario = document.getElementById("txtUsuario");
    let senha = document.getElementById("txtSenha");


    //Conteúdo do corpo da mensagem
    let loginMsg = {
        email: usuario.value,
        cpf: usuario.value,
        senha: senha.value
    }

    let cabecalho = {
        method: 'POST',
        body: JSON.stringify(loginMsg),
        headers:{
            'Content-type':'application/json'
        }
    }

    fetch('http://localhost:8080/usuario/login',cabecalho)
    .then(res => tratarResposta(res))

}


function tratarResposta (res){
    if(res.status == 200){
        res.json().then(res => fazerLogin(res));
    }else{
        document.getElementById("msgErro").innerHTML = "Usuário/Senha inválido"
    }
}

function fazerLogin(res){
    //Armazenar no localstorage os dados do usuario que fez login
    localStorage.setItem("userLogged",JSON.stringify(res));
    window.location="relatorio.html";
}