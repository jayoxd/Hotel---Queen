$(document).ready(function () {

    $(' .carroxd .eBtn').on('click', function (event) {
        event.preventDefault();
        var href = $(this).attr('href');
        var text = $(this).text(); //return New or Edit

        if (text === 'Edit') {
            $.get(href, function (rol) {
                $('.myForm #idti').val(rol.id_tipo);
                $('.myForm #name').val(rol.nombre);
            });
            $('.myForm #depedit').modal();
        } 
    });

  
});


