/* 
 * biblioteca.js
 * 
 * Contiene los menues de la aplicacion Web 
 * videocentroWebAJAX.
 */

function despliegaLogin() {
    // Obtener el elemento contenedor
    var loginForm = document.getElementById("loginForm");

// Crear el input de usuario
    var usernameInput = document.createElement("input");
    usernameInput.type = "text";
    usernameInput.id = "username";
    usernameInput.placeholder = "Usuario";
    usernameInput.required = true;

// Crear el input de contraseña
    var passwordInput = document.createElement("input");
    passwordInput.type = "password";
    passwordInput.id = "password";
    passwordInput.placeholder = "Contraseña";
    passwordInput.required = true;

// Crear el botón de ingresar
    var loginButton = document.createElement("button");
    loginButton.textContent = "Ingresar";
    loginButton.addEventListener("click", obtenToken);

// Agregar los elementos al formulario
    loginForm.appendChild(usernameInput);
    loginForm.appendChild(passwordInput);
    loginForm.appendChild(loginButton);
}


function obtenToken() {
    // Obtener los valores de usuario y contraseña
    username = document.getElementById("username").value;
    password = document.getElementById("password").value;
    // Se instancia el objeto XMLHttpRequest
    peticion_http = new XMLHttpRequest();
    
    // Se instancia el objeto XMLHttpRequest

    // Preparar la funcion de respuesta
    peticion_http.onreadystatechange = login;

    // Realizar peticion HTTP. Le envia en el URL el parametro con

    if (peticion_http) {
        peticion_http.open("GET", "Login?username=" + username
                    + "&password=" + password );
        peticion_http.send(null);
    }
}


function login() {
    if (peticion_http.readyState === 4) {
        if (peticion_http.status === 200) {
            // Convierte el arreglo Json de generos 
            // a un arreglo JavaScript de generos
            if (peticion_http.responseText.length > 2) {
                // Inicio de sesión exitoso
                alert('Inicio de sesión exitoso');
                // Redirigir a la página index.html
                window.location.href = 'index.html';
            } else {
                alert("Contraseña o usuario incorrecto");
            }

        }
    }

}
