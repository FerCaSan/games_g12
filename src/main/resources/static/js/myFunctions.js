function GetDataCategory(){
    $.ajax({
        url: "http://localhost:8080/api/Category/all",
        type: "GET",
        dataType: "json",
        success: function (respuesta){
            pintarDatos(respuesta);
            console.log(respuesta);
        },
        error: function (respuesta, xhr){
            alert("Error in request!");
        }
    })
    
}

function pintarDatos(datos){
    let html="";
    html +="<tr>";

    Object.keys(datos[0]).forEach(elemento =>{
        html+="<th>"+elemento+"</th>";

    });
    html +="</tr>";

    for(let i = 0; i<datos.length; i++){
        html +="<tr>";

        Object.values(datos[i]).forEach(elemento =>{
            if(typeof(elemento) == "object") {
                html += "<td>" + elemento[0].name + "</td>";
            }
            else{
                html += "<td>" + elemento + "</td>";
            }
        });
    }
    $("#tablaCategory").empty();
    $("#tablaCategory").append(html);
}