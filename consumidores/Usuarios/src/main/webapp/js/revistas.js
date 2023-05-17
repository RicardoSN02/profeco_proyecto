/* 
 * revistas.js
 * 
 * Contiene las funciones que implementan las operaciones
 * con los generos
 */

var tipoMedio;
var Isbn;
let peticion_http;

/**
 * Esta funcion despliega un formulario para capturar un comentario
 * 
 */
function capturaComentario() {

    // Limpia la seccion main
    borraHijos("mainId");

    // Obten el elemento dentro del que se desplegara la tabla.
    let padre = document.getElementById("mainId");

    // Crea un titulo
    let titulo = document.createElement("h1");
    // Le agrega el texto al titulo
    titulo.innerHTML = "Captura comentario";
    // Agrega el titulo a su elemento padre
    padre.appendChild(titulo);

    // Crea un formulario
    let formulario = document.createElement("form");
    // Agrega el formulario a su elemento padre
    padre.appendChild(formulario);


    let contenedorFormulario = document.createElement("div");

    contenedorFormulario.setAttribute("class", "contenedorFormulario");
    // Agrega la tabla al formulario
    formulario.appendChild(contenedorFormulario);

    // Crea celda para la etiqueta del isbn
    let celdaIsbn = document.createElement("div");
    // Establece el atributo class de la celda
    celdaIsbn.setAttribute("class", "derecha");
    // Agrega la celda a la fila 
    contenedorFormulario.appendChild(celdaIsbn);

    // Crea una etiqueta del isbn
    let etiqIsbn = document.createElement("label");
    // Establece el atributo for de la etiqueta
    etiqIsbn.setAttribute("for", "campoId");
    // Le agrega el texto a la etiqueta
    etiqIsbn.innerHTML = "Id producto*";
    // Agrega la etiqueta a la celda 
    celdaIsbn.appendChild(etiqIsbn);

    // Crea celda para campo de texto para capturar el isbn de la revista
    let celdaCveGenero = document.createElement("div");
    // Establece el atributo id de la celda
    celdaCveGenero.setAttribute("id", "celdaIdentiId");
    // Agrega la celda a la fila 
    contenedorFormulario.appendChild(celdaCveGenero);

    // Crea un campo de entrada de texto para capturar 
    // el isbn de la revista
    let campoId = document.createElement("input");
    // Establece el atributo type del campo de entrada
    campoId.setAttribute("type", "text");
    // Establece el atributo id del campo de entrada
    campoId.setAttribute("id", "campoId");
    // Establece el atributo size del campo de entrada
    campoId.setAttribute("size", "13");
    campoId.setAttribute("title", "Solo números");
    // Agrega la celda a la fila 
    celdaCveGenero.appendChild(campoId);

//------------------------------------------------------------------------------------------------------------
    //Crea celda para la etiqueta de la editorial
    let celdaEtiqEditorial = document.createElement("div");
    // Establece el atributo class de la celda
    celdaEtiqEditorial.setAttribute("class", "derecha");
    // Agrega la celda a la fila 
    contenedorFormulario.appendChild(celdaEtiqEditorial);

    // Crea una etiqueta de la editorial
    let etiqEditorial = document.createElement("label");
    // Establece el atributo for de la etiqueta
    etiqEditorial.setAttribute("for", "campoNombreId");
    // Le agrega el texto a la etiqueta
    etiqEditorial.innerHTML = "Comentario *";
    // Agrega la etiqueta a la celda 
    celdaEtiqEditorial.appendChild(etiqEditorial);

    // Crea celda para campo de texto para capturar la editorial
    let celdaEditorial = document.createElement("div");
    // Establece el atributo id de la celda
    celdaEditorial.setAttribute("id", "celdaEditorialId");
    // Agrega la celda a la fila 
    contenedorFormulario.appendChild(celdaEditorial);

    // Crea un campo de entrada de texto para capturar 
    // la editorial
    let campoEditorial = document.createElement("input");
    // Establece el atributo type del campo de entrada
    campoEditorial.setAttribute("type", "text");
    // Establece el atributo id del campo de entrada
    campoEditorial.setAttribute("id", "campoEditorialId");
    // Establece el atributo size del campo de entrada
    campoEditorial.setAttribute("size", "25");
    // Establece el atributo maxlength del campo de entrada
    campoEditorial.setAttribute("maxlength", "25");
    campoEditorial.setAttribute("required", "required");
    // Establece el atributo title del campo de entrada
    campoEditorial.setAttribute("title", "M&aacute;ximo 25 caracteres");
    // Agrega la celda a la fila 
    celdaEditorial.appendChild(campoEditorial);
//------------------------------------------------------------------------------------------------------------

    // Crea celda para la etiqueta de la Descripcion
    let celdaEtiqClasificacion = document.createElement("div");
    // Establece el atributo class de la celda
    celdaEtiqClasificacion.setAttribute("class", "derecha");
    // Agrega la celda a la fila 
    contenedorFormulario.appendChild(celdaEtiqClasificacion);

    // Crea una etiqueta de la clasificacion 
    let etiqClasificacion = document.createElement("label");
    // Establece el atributo for de la etiqueta
    etiqClasificacion.setAttribute("for", "campoCalificacionId");
    // Le agrega el texto a la etiqueta
    etiqClasificacion.innerHTML = "Calificación *";
    // Agrega la etiqueta a la celda 
    celdaEtiqClasificacion.appendChild(etiqClasificacion);

    // Crea celda para campo de texto para capturar la clasificacion
    let celdaClasificacion = document.createElement("div");
    // Establece el atributo id de la celda
    celdaClasificacion.setAttribute("id", "celdaDescripcionnId");
    // Agrega la celda a la fila 
    contenedorFormulario.appendChild(celdaClasificacion);

    // Crea un campo de entrada de texto para capturar 
    // la clasificacion de la revista
    let campoClasificacion = document.createElement("input");
    // Establece el atributo type del campo de entrada
    campoClasificacion.setAttribute("type", "text");
    // Establece el atributo id del campo de entrada
    campoClasificacion.setAttribute("id", "campoDescripcionId");
    // Establece el atributo size del campo de entrada
    campoClasificacion.setAttribute("size", "15");
    // Establece el atributo maxlength del campo de entrada
    campoClasificacion.setAttribute("maxlength", "15");
    campoClasificacion.setAttribute("required", "required");
    campoClasificacion.setAttribute("pattern","^[0-9]");
    // Agrega la celda a la fila 
    celdaClasificacion.appendChild(campoClasificacion);


//--------------------------------------------------------------------------------------------

    // Crea una celda en blanco
    let celdaVacia = document.createElement("div");
    // Establece el atributo class del titulo
    celdaVacia.setAttribute("class", "span centrada");
    // Le agrega el texto al titulo
    celdaVacia.innerHTML = "&nbsp;";
    // Agrega el titulo a su elemento padre
    contenedorFormulario.appendChild(celdaVacia);

    // Crea una celda con boton enviar
    let celdaBoton = document.createElement("div");
    // Establece el atributo class de la tabla
    celdaBoton.setAttribute("class", "span centrada");
    // Agrega la tabla al formulario
    contenedorFormulario.appendChild(celdaBoton);

    // Crea un boton
    let boton = document.createElement("button");
    // Establece el atributo type del boton
    boton.setAttribute("type", "button");
    // Establece el nombre de la funcion

    boton.setAttribute("onclick", "validaFormulario()");
    // Establece el texto del boton
    boton.innerHTML = "Enviar";
    // Agrega el boton
    celdaBoton.appendChild(boton);

    // Crea una celda en blanco
    let celdaVacia2 = document.createElement("div");
    // Establece el atributo class del titulo
    celdaVacia2.setAttribute("class", "span centrada");
    // Le agrega el texto al titulo
    celdaVacia2.innerHTML = "&nbsp;";
    // Agrega el titulo a su elemento padre
    contenedorFormulario.appendChild(celdaVacia2);

    // Crea una seccion para mostrar resultados
    let resultados = document.createElement("div");
    // Establece el atributo id de la seccion
    resultados.setAttribute("id", "resultadosId");
    // Agrega la celda a la fila 
    padre.appendChild(resultados);

}

function validaFormulario() {
    let id = document.getElementById("campoId").value;
    let nombre = document.getElementById("campoNombreId").value;
    let descripcion = document.getElementById("campoDescripcionId").value;
    if ((id.length === 0) || (nombre.length === 0) || (descripcion.length === 0)) {
        alert("Campos vacíos");

    } else {
            alert("Comentario guardado");
            despliegaProductos();
    }
}
/**
 * Funcion de respuesta para procesar la respuesta a la 
 * solicitud asincrona al servidor para obtener la lista
 * de revistas. Despliega la lista de revistas 
 */
function obtenProductos() {
    //   tipoMedio = document.getElementById("tipoMedioId").value;

    // Se instancia el objeto XMLHttpRequest
    peticion_http = new XMLHttpRequest();
    // Preparar la funcion de respuesta
    peticion_http.onreadystatechange = despliegaProductos;

    // Realizar peticion HTTP. Le envia en el URL el parametro con
    // el tipo de medio deseado de la lista de revistas
    if (peticion_http) {
        peticion_http.open('GET', 'ObtenProductos', true);
        peticion_http.send(null);
    }
}


/**
 * Funcion de respuesta para procesar la respuesta a la 
 * solicitud asincrona al servidor para obtener la lista
 * de revistas. Despliega la lista de revistas 
 */
function despliegaProductos() {

    borraHijos("mainId");

    // Establece el titulo de la tabla de acuerdo al tipo de
    // medio de los generos de la lista
    let titulo = null;
    let revistas = null;
    titulo = "Todas las Revistas";

    // Arreglo con los encabezados de la tabla de la lista
    // de generos

    let encabezados = ["id", "nombre", "descripcion", "precio", "Comentario"];
    if (peticion_http.readyState === READY_STATE_RESONSE_READY) {
        if (peticion_http.status === REQUEST_STATUS_OK) {
            // Convierte el arreglo Json de generos 
            // a un arreglo JavaScript de generos
            let revistasm = JSON.parse(peticion_http.responseText);
            
                // Despliega la tabla con la lista de generos
                despliegaTabla("mainId", titulo, encabezados, revistasm);
            
        }
    }

}


