package MenuPrincipal.Hokey;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Ventana_H extends JFrame implements KeyListener {
    private Hockey hockey;
    private String j1;
    private String j2;
    private Thread hilo;
    private int punto1;
    private int punto2;

    public Ventana_H(String j1, String j2,int punto1, int punto2) {
        super("Hockey");
        hockey = new Hockey(j1, j2,punto1, punto2);
        this.j1 = j1;
        this.j2 = j2;
        this.punto1=punto1;
        this.punto2=punto2;
        setSize(800, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        addKeyListener(this);
        hockey.setPreferredSize(new Dimension(100, 100));
        addKeyListener(hockey);
        add(hockey, BorderLayout.CENTER);
        hilo = new Thread(hockey);
        hilo.start();

        setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            //System.exit(0);
            setVisible(false);
            hilo.stop();
            punto2= hockey.getP2();
            punto1= hockey.getP1();
            new MenuPrincipal.Menu(j1,j2, punto1, punto2);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


    public static void main(String[] args) {
        new Ventana_H("khaled", "Ramon",0,0);
    }
}
