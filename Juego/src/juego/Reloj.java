/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package juego;


 
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class Reloj {
 
	Timer timer = new Timer(); // El timer que se encarga de administrar los tiempo de repeticion
	public int segundos; // manejar el valor del contador
	public boolean frozen; // manejar el estado del contador TIMER AUTOMATICO -- True Detenido | False Corriendo
 
	// clase interna que representa una tarea, se puede crear varias tareas y asignarle al timer luego
	class MiTarea extends TimerTask {
		public void run() {
                    if(!frozen){
                             segundos++;
                             System.out.println(segundos);
                             
                        Play.carga.setValue(segundos);
                    }      
		} 
	}
        public Reloj(){
           // timer.schedule(new MiTarea(), 0, 1000 ); //1000 milisegundos = 1seg
        }
        
        public void creaTimer(){
            timer.schedule(new MiTarea(), 0, 10 ); //1000 milisegundos = 1seg
        }
        
	public void Start() {
               System.out.println("Start");
		frozen = false;
	}
 
	public void Stop() {
		System.out.println("Stop");
		frozen = true;
	}
 
        public void Reset() {
		System.out.println("Reset");
		frozen = true;
		segundos = 0;
        }
 
}