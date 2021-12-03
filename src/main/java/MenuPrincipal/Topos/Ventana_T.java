package MenuPrincipal.Topos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Ventana_T extends JFrame implements KeyListener {
    private Game juego;
    private String j1;
    private String j2;
    private int punto1;
    private int punto2;
    //private Menu menu = new Menu();
    //private boolean aux = true;

    public Ventana_T(String j1, String j2,int punto1, int punto2) {
        super("Topos");
        juego = new Game(j1);
        this.j1 = j1;
        this.j2 = j2;
        this.punto1 = punto1;
        this.punto2 = punto2;
        setSize(800, 400);
        addKeyListener(this);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        juego.setPreferredSize(new Dimension(100, 100));
        add(juego, BorderLayout.CENTER);
        addMouseListener(juego);
        Thread hilo = new Thread(juego);
        hilo.start();
        setVisible(true);
    }

    /*public boolean isAux() {
        return aux;
    }*/

    public static void main(String[] args) {
        new Ventana_T("khaled", "Ramon", 0 , 0);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            setVisible(false);
            new MenuPrincipal.Menu(j1, j2, punto1, punto2);
            //System.exit(0);
            //aux = false;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
