document.addEventListener("DOMContentLoaded", function(){
    let entradas = document.getElementsByClassName("select");
    let btnFiltro = document.getElementById("filtro");
    for(let i = 0; i < entradas.length; i++){
        entradas[i].addEventListener("click", function(){
            for(let j = 0; j < entradas.length; j++){
                if(j !== i){
                    entradas[j].disabled = true;
                }
            }
        });
    }
});

/* La siguiente función se utiliza para visualizar la imagen seleccionada en la
 * página html donde se desea "cargar" utilizando un llamado "ajax"*/
function readURL(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();
        reader.onload = function (e) {
            $('#blah')
                    .attr('src', e.target.result)
                    .height(200);
        };
        reader.readAsDataURL(input.files[0]);
    }
}
