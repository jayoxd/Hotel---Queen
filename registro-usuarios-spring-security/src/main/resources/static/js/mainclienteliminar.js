$(document).ready(function () {

    $(' .tablacliente .eBtn').on('click', function (event) {
        event.preventDefault();
        var href = $(this).attr('href');
        var text = $(this).text(); //return New or Edit

        if (text === 'Edit') {
            $.get(href, function (cliente) {
                $('.myForm #id_cli').val(cliente.id_cliente);
              
                 
            });
            $('.myForm #deleteproject').modal();
        } 
    });

  
});