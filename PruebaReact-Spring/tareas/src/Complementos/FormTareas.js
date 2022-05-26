import React, { useState } from "react";
import './FormTareas.css';
import { BrowserRouter, Link} from "react-router-dom";

const FormTareas = () => {

    const[name, setName]=useState('');

    const guardarDatos=(e)=>{
        e.preventDefault()
        const send = {name}
        if (name.trim().length == 0) {
            alert("Introduzca un valor");
        } else {
            fetch("http://localhost:8080/nombre/add", {
                method:"POST",
                headers:{"Content-Type":"application/json"},
                body:JSON.stringify(send)
            }).then(()=>{
                alert("Valor guardado");
                window.location="http://localhost:3000/";
            })
        }
    }

    return (
        <BrowserRouter>
        <div id="FormTareas">
            <form>
                <label htmlFor="nombre">Nombre</label>
                <input id="nombre" 
                        type="text" 
                        placeholder="Nombre" 
                        value={name} 
                        onChange={(e)=>setName(e.target.value)}/>
                <Link to="../"><input type="submit" 
                        id="send" 
                        className="btn btn-primary bg-danger" 
                        value="Guardar" 
                        onClick={guardarDatos}/></Link>
            </form>
        </div>
        </BrowserRouter>
    );
}

export default FormTareas;