/*

SE ULTILIZA PARA PONER EL FONDO A LOS JINTERNALFRAME

*/
package juego;


import javax.swing.JInternalFrame;





public class InternalFrameImagen extends JInternalFrame{
    private PanelImagen pi = new PanelImagen();
    public InternalFrameImagen(){
        setContentPane(pi);
    }
    public void setImage(String nombreImagen){
        pi.setImage(nombreImagen);
    }
}
