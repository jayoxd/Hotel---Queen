$(document).ready(function () {

    $(' .carroxdx .eBtn').on('click', function (event) {
        event.preventDefault();
        var href = $(this).attr('href');
        var text = $(this).text(); //return New or Edit

        if (text === 'Edit') {
            $.get(href, function (rol) {
                $('.myForm #id_rol').val(rol.id_rol);
                $('.myForm #nombre').val(rol.nombre);
               $('.myForm #descripcion').val(rol.descripcion);

                
            });
            $('.myForm #depedit').modal();
        } 
    });

  
});


