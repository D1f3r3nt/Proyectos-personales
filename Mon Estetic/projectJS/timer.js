window.onload = countdown;
//Comprueba https://www.cuantofaltapara.com/1-enero
function getTime(ano, mes, dia) {
    fecha = new Date(ano, mes, dia, 0, 0, 0);
    let now = new Date(),
        time = (Date.parse(fecha.toUTCString()) - now + 1000) / 1000,
        seconds = ('0' + Math.floor(time % 60)).slice(-2),
        minutes = ('0' + Math.floor(time / 60 % 60)).slice(-2),
        hours = ('0' + Math.floor(time / 3600 % 24)).slice(-2),
        days = Math.floor(time / (3600 * 24));

    return {
        seconds,
        minutes,
        hours,
        days,
        time
    }
}

function countdown() {
    const item = document.querySelector('#timer');
    const timerUpdate = setInterval( () => {
        let currenTime = getTime(2023, 0, 1);
        item.innerHTML = `<div><p>DIAS</p><p>HORAS</p><p>MIN</p><p>SEC</p><p>${currenTime.days}</p><p>${currenTime.hours}</p><p>${currenTime.minutes}</p><p>${currenTime.seconds}</p></div>`;
        if (currenTime.time < 0) {
            clearInterval(timerUpdate);
            item.innerHTML = "";
            alert('LA OFERTA A FINALIZADO');
        }
    }, 1000);
}