//-------------------------------------------------
//-------------------------------------------------
//-------------------------------------------------
//-------------------------------------------------
//-----------------------BLOQUES-------------------
//-------------------------------------------------
//-------------------------------------------------
//-------------------------------------------------
package diferent;


import javax.swing.JFrame;

public class raketa extends javax.swing.JInternalFrame {

    public raketa()
    {
        add(new tablero());
        setTitle("Bloques");
        setClosable(true);
        setIconifiable(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(comun.WIDTH, comun.HEIGTH);
        setIgnoreRepaint(true);
        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        new raketa();
    }
}
