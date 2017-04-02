function AlteraEtapa(etapa){
    $('#tabEtapas a[href="#etapa'+etapa+'"]').tab('show')

}
function exibePopover(dica){
    $('#'+dica).popover('show')
}
function excondePopover(dica){
    $('#'+dica).popover('hide')
}
function validaFormulario(){

    let nome = $('#nome').val();
    let cpf = $('#cpf').val();
    let cep = $('#cep').val();
    let rua = $('#rua').val();
    let comlemento = $('#complemento').val();
    let dataNascimento = $('#dataNascimento').val();
    let cidade = $('#cidade').val();
    let estado = $('#estado').val();
    let email = $('#email').val();
    let telefone = $('#telefone').val();
    let ano = dataNascimento.substr(6,4);

    if(nome == ''){
        $('#nome').focus();
       
        alert("Informe o nome do cliente!")
        return false;
    }
    else if(email == "" || email.indexOf('@')==-1){
    	$('#email').focus();
    	alert("Informe um email válido!")
        return false;
    }
     else if(cpf == ''){
        $('#cpf').focus();
        alert("Informe o CPF do cliente!")
        return false;
    }
     else if(cep == ''){
         $('#cep').focus();
         alert("Informe o CEP do cliente!")
         return false;
     }
    else if(cidade == ''){
        $('#cidade').focus();
        $('#cpf').focus();
        alert("Informe a CIDADE do cliente!")
        return false;
    }
    else if(estado == ''){
        $('#estado').focus();
        $('#cpf').focus();
        alert("Informe o ESTADO do cliente!")
        return false;
    }
    else if(dataNascimento == ''){
        $('#dataNascimento').focus();
        alert("Informe a DATA DE NASCIMENTO do cliente!")
        return false;
    }
    
}