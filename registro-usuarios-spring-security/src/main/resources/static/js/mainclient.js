$(document).ready(function () {

    $(' .tablacliente .eBtn').on('click', function (event) {
        event.preventDefault();
        var href = $(this).attr('href');
        var text = $(this).text(); //return New or Edit

        if (text === 'Edit') {
            $.get(href, function (cliente) {
                $('.myForm #id_cliente').val(cliente.id_cliente);
                $('.myForm #nombre').val(cliente.nombre);
                 $('.myForm #apellido').val(cliente.apellido);
                  $('.myForm #telefono').val(cliente.telefono);
                   $('.myForm #fechaNacimiento').val(cliente.fechaNacimiento);
                  $('.myForm #imghabitacion').val(cliente.imghabitacion);
                   $('.myForm #email').val(cliente.email);
                 
            });
            $('.myForm #editproject').modal();
        } 
    });

  
});