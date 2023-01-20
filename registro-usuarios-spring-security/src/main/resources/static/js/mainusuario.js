$(document).ready(function () {

    $(' .tablausuario .eBtn').on('click', function (event) {
        event.preventDefault();
        var href = $(this).attr('href');
        var text = $(this).text(); //return New or Edit

        if (text === 'Edit') {
            $.get(href, function (usuario) {
                $('.myForm #id').val(usuario.id);
                $('.myForm #nombre').val(usuario.nombre);
                 $('.myForm #apellido').val(usuario.apellido);
                  $('.myForm #telefono').val(usuario.telefono);
                   $('.myForm #fechaNacimiento').val(usuario.fechaNacimiento);
                  $('.myForm #imghabitacion').val(usuario.imghabitacion);
                   $('.myForm #email').val(usuario.email);
                   $('.myForm #password').val(usuario.password);
                  $('.myForm #idRol').let(usuario.idRol);
                 
            });
            $('.myForm #editproject').modal();
        } 
    });

    $('.tablausuario .delBtn').on('click', function (event) {
        event.preventDefault();
        var href = $(this).attr('href');
        $('#myModal #delRef').attr('href', href);
        $('#myModal').modal();
    });
});