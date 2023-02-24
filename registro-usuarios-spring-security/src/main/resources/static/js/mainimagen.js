$(document).ready(function () {

    $(' .imgca .eBtn').on('click', function (event) {
        event.preventDefault();
        var href = $(this).attr('href');
        var text = $(this).text(); //return New or Edit

        if (text === 'Editar') {
            $.get(href, function (imagen) {
                $('.myForm #id').val(imagen.id);
                $('.myForm #name').val(imagen.nombre);
         $('.myForm #imghabitacion').val(imagen.imghabitacion);
                
            });
            $('.myForm #depedit').modal();
        } 
    });

  
});


