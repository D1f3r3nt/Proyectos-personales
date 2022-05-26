import React, { useEffect, useState } from "react";
import './ListaTareas.css';
import Carga from "./carga/Carga";

const ListaTareas = () => {
    const [nombres, setNombres] = useState();

    useEffect(() => {
        fetch("http://localhost:8080/nombre/getAll")
        .then(res=>res.json())
        .then((result)=>{
            setNombres(result);
        })
    }, []);

    return ( 
        <div id="ListaTareas">
            <h3>Mi lista de tareas</h3>
            <div>
            {!nombres ? <Carga/> : 
            nombres.map( (todo) => {
                return <div key={todo.id}>{todo.name}</div>
            })
            }
            </div>
        </div>
     ); 
}

export default ListaTareas;