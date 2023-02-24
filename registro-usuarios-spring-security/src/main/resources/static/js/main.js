$(document).ready(function () {

    $('.nBtn, .table .eBtn').on('click', function (event) {
        event.preventDefault();
        var href = $(this).attr('href');
        var text = $(this).text(); //return New or Edit

        if (text === 'Editar') {
            $.get(href, function (caracteristica) {
                $('.myForm #idxd').val(caracteristica.id);
                $('.myForm #name').val(caracteristica.nombre);
            });
            $('.myForm #depedit').modal();
        } 
    });

  
});


