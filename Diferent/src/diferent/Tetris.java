//-------------------------------------------------
//-------------------------------------------------
//-------------------------------------------------
//-------------------------------------------------
//-----------------------TETRIS-------------------
//-------------------------------------------------
//-------------------------------------------------
//-------------------------------------------------
package diferent;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;


public class Tetris extends javax.swing.JInternalFrame {

    JLabel statusbar;


    public Tetris() {

        statusbar = new JLabel(" 0");
        add(statusbar, BorderLayout.SOUTH);
        tablero_t board = new tablero_t(this);
        add(board);
        board.start();

        setSize(200, 400);
        setTitle("Tetris");
        setClosable(true);
        setIconifiable(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
   }

   public JLabel getStatusBar() {
       return statusbar;
   }

    public static void main(String[] args) {

        Tetris game = new Tetris();
        game.setVisible(true);

    } 

}

