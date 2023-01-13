$(document).ready(function () {

    $(' .tablahabitacixon .eBtn').on('click', function (event) {
        event.preventDefault();
        var href = $(this).attr('href');
        var text = $(this).text(); //return New or Edit

        if (text === 'Edit') {
            $.get(href, function (habitacion) {
                $('.myForm #id_habitacion').val(habitacion.id);
                $('.myForm #nombre').val(habitacion.nombre);
                 $('.myForm #invitados').val(habitacion.invitados);
                  $('.myForm #precio').val(habitacion.precio);
                   $('.myForm #descripcion').val(habitacion.descripcion);
                  $('.myForm #estado').val(habitacion.estado);
                   $('.myForm #idTipo').val(habitacion.idTipo);
                   $('.myForm #imagenes').let(habitacion.imagenes);
                  $('.myForm #caracteristica').let(habitacion.caracteristica);
                   
                 
            });
            $('.myForm #editproject').modal();
        } 
    });

  
});