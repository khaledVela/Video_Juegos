package MenuPrincipal.Pokemon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Ventana_P extends JFrame implements KeyListener {
    private Dibujar juego ;
    private String j1;
    private String j2;
    private int punto1;
    private int punto2;

    public Ventana_P(String j1, String j2, int punto1, int punto2) {
        super("Pokemon");
        setSize(750, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.j1 = j1;
        this.j2 = j2;
        this.punto1 = punto1;
        this.punto2 = punto2;
        juego= new Dibujar(j1, j2,punto1, punto2);
        addKeyListener(this);
        juego.setPreferredSize(new Dimension(100, 100));
        add(juego, BorderLayout.CENTER);
        addKeyListener(juego);

        setVisible(true);
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            setVisible(false);
            punto1 = juego.getPunto1();
            punto2 = juego.getPunto2();
            new MenuPrincipal.Menu(j1, j2, punto1, punto2);
            //System.exit(0);
            //aux = false;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public static void main(String[] args) {
        new Ventana_P("Khaled", "Ramon", 0, 0);
    }
}