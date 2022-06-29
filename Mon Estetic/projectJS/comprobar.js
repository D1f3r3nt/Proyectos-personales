window.onload = go;

function go() {
    const timerUpdate = setInterval( () => {
        validar();
    }, 100);
}

function validar(){
    let name = validar_name();
    let tel = validar_tel();
    let tratamiento = validar_tratamiento();
    let dia = validar_dia();

    return name && tel && tratamiento && dia;
}

function validar_name(){
    let pattern = /^[A-Z][a-z]+$/;
    let thing = document.querySelector('#nombre');
    let message = document.querySelector('label[for="nombre"] span');

    if (thing.value.length !== 0){
        if (pattern.test(thing.value)){
            message.innerHTML = "";
            return true;
        }else{
            message.innerHTML = "Incorrecto";
            message.style.color = "orange";
            return false;
        }
    }
    message.innerHTML = "Obligatorio";
    message.style.color = "red";
    return false;
}

function validar_tel(){
    let pattern = /^(6|9|7){1}[0-9]{8}$/;
    let thing = document.querySelector('#telefono');
    let message = document.querySelector('label[for="telefono"] span');

    if (thing.value.length !== 0){
        if (pattern.test(thing.value)){
            message.innerHTML = "";
            return true;
        }else{
            message.innerHTML = "Incorrecto";
            message.style.color = "orange";
            return false;
        }
    }
    message.innerHTML = "Obligatorio";
    message.style.color = "red";
    return false;
}

function validar_tratamiento(){
    let thing = document.getElementById('tratamiento').value;
    let message = document.querySelector('label[for="tratamiento"] span');
    if (thing == "default") {
        message.innerHTML = "Obligatorio";
        message.style.color = "red";
        return false;
    } else {
        if(document.getElementById('segundoTratamiento')) {
            let thing2 = document.getElementById('segundoTratamiento').value;
            if (thing2 == "default") {
                message.innerHTML = "2º Obligatorio";
                message.style.color = "red";
                return false;
            }
            if (thing == thing2) {
                message.innerHTML = "Incorrecto";
                message.style.color = "orange";
                return false;
            }
        }
    }

    message.innerHTML = "";
    return true;
}

function validar_dia(){
    let thing = document.querySelector('#cita');
    let message = document.querySelector('label[for="cita"] span');

    if(thing.value.length !== 0 ) {
        let dia = new Date(thing.value);
        const hoy = new Date();
        if (dia > hoy) {
            if (dia.getDay() == 0 || dia.getDay() == 1) {
                message.innerHTML = "Cerrado";
                message.style.color = "orange";
                return false;
            } else {
                if (dia.getHours() >= 18 || dia.getHours() < 8) {
                    message.innerHTML = "Cerrado";
                    message.style.color = "orange";
                    return false;
                }
                message.innerHTML = "";
                return true;
            }
        }else{
            message.innerHTML = "Incorrecto";
            message.style.color = "orange";
            return false;
        }
    }

    message.innerHTML = "Obligatorio";
    message.style.color = "red";
    return false;
}

