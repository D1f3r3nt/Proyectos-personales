function presionado(id) {
    let rellenar = document.querySelector('form > span');
    let boton = document.getElementById(id);
    let select = "<select id=\"segundoTratamiento\" name=\"segundoTratamiento\">\n" +
        "                <option value=\"default\" disabled selected>Elige...</option>\n" +
        "                <option value=\"DC\">Diseño de cejas</option>\n" +
        "                <option value=\"AP\">Extension de pestañas</option>\n" +
        "                <option value=\"LP\">Lifting de pestañas</option>\n" +
        "                <option value=\"SL\">Sesión láser</option>\n" +
        "                <option value=\"AE\">Aplicación de esmalte</option>\n" +
        "                <option value=\"P\">Pedicura</option>\n" +
        "                <option value=\"TH\">Tinte Henna</option>\n" +
        "                <option value=\"TC\">Tratamiento de cutis</option>\n" +
        "                <option value=\"TF\">Tratamiento facial</option>\n" +
        "                <option value=\"UG\">Uñas de gel</option>\n" +
        "            </select>";
    rellenar.innerHTML = select;
    rellenar.style.gridColumnEnd = "span 2";
    let elemento = document.querySelector('form > span > select');
    elemento.style.padding = "8px";
    elemento.style.borderRadius = "5px";
    elemento.style.border = "none";
    elemento.style.outline = "none";
    elemento.style.width = "600px";
    boton.disabled = true;
    boton.hidden = true;
}