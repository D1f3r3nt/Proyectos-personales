/*

SE ULTILIZA PARA PONER EL FONDO A LOS JINTERNALFRAME

*/
package juego;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class PanelImagen extends JPanel {
    private Image img;
    public PanelImagen(){
        img = null;
    }
    
    public PanelImagen(String nombreimagen){
        if(nombreimagen != null){
            img = new ImageIcon(getClass().getResource(nombreimagen)).getImage();
        }
    }
    public void setImage(String nombreimagen){
        if(nombreimagen != null){
            img = new ImageIcon(getClass().getResource(nombreimagen)).getImage();
        } else {
            img = null;
        }
        repaint();
    }
    
    public void paint(Graphics g){
        if(img != null){
            g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
            this.setOpaque(false);
        }else{
            setOpaque(true);
        }
        super.paint(g);
    }
}
