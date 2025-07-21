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

