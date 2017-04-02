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
function validaFormularioPlanos(){
	

    let descricao = $('#descricao').val();
    let numero = $('#numero').val();
    let valor = $('#valor').val();
    
    

    if(descricao == ''){
        $('#descricao').focus();
       
        alert("Informe a DESCRICAO do plano!")
        return false;
    }
    else 
        if(numero == ''){
            $('#numero').focus();
           
            alert("Informe o NUMERO DE DEPENDENTES!")
            return false;
        }
    else 
        if(valor == ''){
             $('#valor').focus();
               
             alert("Informe o VALOR do plano!")
             return false;
         }
       
}

function  validaFormularioAgendamntos(){
	
	let local = $('#local').val();
	let data = $('#datahora').val();
	
	if(local == ''){
		  $('#local').focus();
          
          alert("Informe o LOCAL!")
          return false;
	}
	if(data == ''){
		 $('#datahora').focus();
         
         alert("Informe  a DATA/HORA!")
         return false;
	}
}












