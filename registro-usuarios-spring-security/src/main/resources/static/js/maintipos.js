$(document).ready(function () {

    $(' .carro .eBtn').on('click', function (event) {
        event.preventDefault();
        var href = $(this).attr('href');
        var text = $(this).text(); //return New or Edit

        if (text === 'Edit') {
            $.get(href, function (tipo) {
                $('.myForm #idti').val(tipo.id_tipo);
                $('.myForm #name').val(tipo.nombre);
                 $('.myForm #descripcion').val(tipo.descripcion);
            });
            $('.myForm #depedit').modal();
        } 
    });

  
});


