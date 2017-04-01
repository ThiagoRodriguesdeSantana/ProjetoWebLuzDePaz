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
    let cidade = $('#cidade').val();
    let estado = $('#estado').val();
    let email = $('#email').val();
    let telefone = $('#telefone').val();

    if(nome == ''){
        AlteraEtapa(1);
        $('#nome').focus();
        $('#nome').tooltip('show')
       
        setTimeout(function(){
          $('#nome').tooltip('destroy')
        },3000)
    }
     else if(cpf == ''){
        AlteraEtapa(1);
        $('#cpf').focus();
         $('#cpf').tooltip('show')
          setTimeout(function(){
          $('#cpf').tooltip('destroy')
        },3000)
    }
     else if(cep == ''){
         AlteraEtapa(1);
         $('#cep').focus();
          $('#cep').tooltip('show')
           setTimeout(function(){
           $('#cep').tooltip('destroy')
         },3000)
     }
    else if(cidade == ''){
        AlteraEtapa(2);
        $('#cidade').focus();
        $('#cidade').tooltip('show')
         setTimeout(function(){
          $('#cidade').tooltip('destroy')
        },3000)
    }
    else if(estado == ''){
        AlteraEtapa(2);
        $('#estado').focus();
        $('#estado').tooltip('show')
         setTimeout(function(){
          $('#estado').tooltip('destroy')
        },3000)
    }
    else if(facebook == ''){
        $('#facebook').focus();
        $('#facebook').tooltip('show')
         setTimeout(function(){
          $('#facebook').tooltip('destroy')
        },3000)
    }
    else if(twitter == ''){
        $('#twitter').focus();
        $('#twitter').tooltip('show')
         setTimeout(function(){
          $('#twitter').tooltip('destroy')
        },3000)
        
    }

    
    console.log(nome, email, cidade, estado, facebook, twitter);
}