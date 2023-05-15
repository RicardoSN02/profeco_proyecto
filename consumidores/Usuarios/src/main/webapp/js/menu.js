/* 
 * biblioteca.js
 * 
 * Contiene los menues de la aplicacion Web 
 * videocentroWebAJAX.
 */

let READY_STATE_UNINITIALIZED = 0;
let READY_STATE_CONNECTIO_ESTABLISHED = 1;
let READY_STATE_REQUEST_RECEIVED = 2;
let READY_STATE_PROCESSING_REQUEST = 3;
let READY_STATE_RESONSE_READY = 4;

let REQUEST_STATUS_OK = 200;

let peticion_http;

// Opciones del menu principal de la aplicacion 
let menuPrincipalItems = ["Ofertas", "Productos", "Preferencias", "Wishlist"];

// Funciones que implementan las operaciones de las opciones
// del menu principal de la aplicacion 
let menuPrincipalFunciones = ["","obtenProductos()", "", ""];
                          
// Opciones del menu de las operaciones con las revistas 
let menuRevistasItems = ["Agregar revistas","Consultar revistas","Consulta revista",
                          "Página Inicial"];
                      
/**
 * Esta funcion despliega el menu principal de la aplicacion
 */
function despliegaMenuPrincipal() {
    
    // Limpia la seccion nav
    borraHijos("navId");
    despliegaMenu("navId", menuPrincipalItems, menuPrincipalFunciones);
}

