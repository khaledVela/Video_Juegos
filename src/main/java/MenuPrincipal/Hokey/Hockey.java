package MenuPrincipal.Hokey;

import MenuPrincipal.Topos.Ventana_T;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Hockey extends JPanel implements KeyListener, Runnable {
    private Pelota circulo = new Pelota(this.getWidth(), this.getHeight() / 2);
    private Pelota circulo2 = new Pelota(0,0 );
    private Paletas jugador1 = new Paletas(60, 150);
    private Paletas jugador2 = new Paletas(600, 150);
    private Meta meta1 = new Meta(0, 110);
    private Meta meta2 = new Meta(783, 110);
    private JLabel panel;
    private int p1;
    private int p2;
    private int punto1 = 0;
    private int punto2 = 0;
    private String j1;
    private String j2;

    public Hockey(String j1, String j2,int punto1, int punto2) {
        this.j1 = j1;
        this.j2 = j2;
        this.p1 = punto1;
        this.p2 = punto2;
        setBackground(Color.black);
        this.addKeyListener(this);
        panel = new JLabel(j1 + " " + punto1 + " | " + j2 + " " + punto2);
        panel.setForeground(Color.white);
        add(panel);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        jugador1.dibujar(g);
        jugador2.dibujar(g);
        circulo.dibujar(g);
        circulo2.dibujar(g);
        meta1.dibujar(g);
        meta2.dibujar(g);
    }

    public void choque() {
        Rectangle metal = new Rectangle(meta1.getX(), meta1.getY(), 1, meta1.getTamanio());
        Rectangle metal2 = new Rectangle(meta2.getX(), meta2.getY(), 1, meta2.getTamanio());
        Rectangle circle = new Rectangle(circulo.getX(), circulo.getY(), circulo.getTamanio(), circulo.getTamanio());
        Rectangle circle2 = new Rectangle(circulo2.getX(), circulo2.getY(), circulo2.getTamanio(), circulo2.getTamanio());
        Rectangle jugador1 = new Rectangle(this.jugador1.getX(), this.jugador1.getY(), this.jugador1.getTamanio() / 2, this.jugador1.getTamanio());
        Rectangle jugador2 = new Rectangle(this.jugador2.getX(), this.jugador2.getY(), this.jugador2.getTamanio() / 2, this.jugador2.getTamanio());

        if (circle2.intersects(jugador1)) {
            circulo2.cambiarHorizontal();
            circulo2.cambiarAltura();
        }
        if (circle2.intersects(jugador2)) {
            circulo2.cambiarHorizontal();
            circulo2.cambiarAltura();
        }
        if (circle2.intersects(metal)) {
            punto2 += 1;
            circulo2.setX(400);
            circulo2.setY(50);
            repaint();
        }
        if (circle2.intersects(metal2)) {
            punto1 += 1;
            circulo2.setX(400);
            circulo2.setY(50);
            repaint();
        }
        if (circle.intersects(jugador1)) {
            circulo.cambiarHorizontal();
            circulo.cambiarAltura();
        }
        if (circle.intersects(jugador2)) {
            circulo.cambiarHorizontal();
            circulo.cambiarAltura();
        }
        if (circle.intersects(metal)) {
            punto2 += 1;
            circulo.setX(this.getWidth() / 2);
            circulo.setY(this.getHeight() / 2);
            repaint();
        }
        if (circle.intersects(metal2)) {
            punto1 += 1;
            circulo.setX(this.getWidth() / 2);
            circulo.setY(this.getHeight() / 2);
            repaint();
        }
        if (punto1 == 5) {
            JOptionPane.showMessageDialog(null, "Ganaste! " + j1);
            punto1 = 0;
            punto2 = 0;
            p1 += 1;
        }
        if (punto2 == 5) {
            JOptionPane.showMessageDialog(null, "Ganaste! " + j2);
            punto1 = 0;
            punto2 = 0;
            p2 += 1;
        }
    }

    private void verificarLimites() {
        if (circulo2.getX() < 0) {
            circulo2.cambiarHorizontal();
            circulo2.setX(0);
        }

        if (circulo2.getX() > this.getWidth() - circulo2.getTamanio()) {
            circulo2.cambiarHorizontal();
            circulo2.setX(this.getWidth() - circulo2.getTamanio());
        }
        if (circulo2.getY() < 0) {
            circulo2.cambiarAltura();
            circulo2.setY(0);
        }
        if (circulo2.getY() > this.getHeight() - circulo2.getTamanio()) {
            circulo2.cambiarAltura();
            circulo2.setY(this.getHeight() - circulo2.getTamanio());
        }
        if (circulo.getX() < 0) {
            circulo.cambiarHorizontal();
            circulo.setX(0);
        }

        if (circulo.getX() > this.getWidth() - circulo.getTamanio()) {
            circulo.cambiarHorizontal();
            circulo.setX(this.getWidth() - circulo.getTamanio());
        }
        if (circulo.getY() < 0) {
            circulo.cambiarAltura();
            circulo.setY(0);
        }

        if (circulo.getY() > this.getHeight() - circulo.getTamanio()) {
            circulo.cambiarAltura();
            circulo.setY(this.getHeight() - circulo.getTamanio());
        }
    }

    public int getP1() {
        return p1;
    }

    public int getP2() {
        return p2;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int mitad = this.getWidth() / 2;
        if (e.getKeyCode() == KeyEvent.VK_S) {
            jugador1.moverAbajo();
            if (jugador1.getY() > this.getHeight() - 50) {
                jugador1.setY(this.getHeight() - 50);
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_W) {
            jugador1.moverArriba();
            if (jugador1.getY() < 0) {
                jugador1.setY(0);
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_A) {
            jugador1.moverIzquierda();
            if (jugador1.getX() < 0) {
                jugador1.setX(0);
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            jugador1.moverDerecha();
            if (jugador1.getX() > mitad - 25) {
                jugador1.setX(mitad - 25);
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            jugador2.moverAbajo();
            if (jugador2.getY() > this.getHeight() - 50) {
                jugador2.setY(this.getHeight() - 50);
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            jugador2.moverArriba();
            if (jugador2.getY() < 0) {
                jugador2.setY(0);
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            jugador2.moverIzquierda();
            if (jugador2.getX() < mitad) {
                jugador2.setX(mitad);
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            jugador2.moverDerecha();
            if (jugador2.getX() > this.getWidth() - 25) {
                jugador2.setX(this.getWidth() - 25);
            }
        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {
        while (true) {
            try {
                choque();
                verificarLimites();
                circulo.mover();
                circulo2.mover();
                Thread.sleep(4, 0);
                panel.setText(j1 + " " + punto1 + " | " + j2 + " " + punto2);
                repaint();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
