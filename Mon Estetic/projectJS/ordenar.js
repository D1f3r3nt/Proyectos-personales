let tipoUnas = document.querySelectorAll('.unas');
let tipoDiseno = document.querySelectorAll('.diseno');
let tipoFacial = document.querySelectorAll('.facial');
let tipoLift = document.querySelectorAll('.lifting');
let pagina = document.querySelector('#posicion');
let rows = document.querySelector('#galeria');

function seleccionar(id) {
    let selector = document.getElementById(id);

    switch (selector.value) {
        case "unas": exposeElement(tipoUnas); break;
        case "diseno": exposeElement(tipoDiseno); break;
        case "facial": exposeElement(tipoFacial); break;
        case "lifting": exposeElement(tipoLift); break;
        default: exposeAll(); break;
    }
}

function exposeElement (tipo) {
    let divs = tipo.length;
    let lines = Math.floor((divs/4)+0.9);
    let num = lines*250+100;
    tipoUnas.forEach(element => element.style.display = "none");
    tipoDiseno.forEach(element => element.style.display = "none");
    tipoFacial.forEach(element => element.style.display = "none");
    tipoLift.forEach(element => element.style.display = "none");
    tipo.forEach(element => element.style.display = "flex");
    pagina.style.height = num+"px";
    rows.style.gridTemplateRows = "repeat("+lines+", 250px)";
}

function exposeAll() {
    tipoUnas.forEach(element => element.style.display = "flex");
    tipoDiseno.forEach(element => element.style.display = "flex");
    tipoFacial.forEach(element => element.style.display = "flex");
    tipoLift.forEach(element => element.style.display = "flex");
    pagina.style.height = "2600px";
    rows.style.gridTemplateRows = "repeat(10, 250px)";
}