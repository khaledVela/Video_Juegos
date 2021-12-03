package MenuPrincipal.Hokey;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Paletas {
    private int x;
    private int y;
    private int tamanio = 50;
    private int velocidad = 10;
    Image p1 = new ImageIcon("src/main/java/MenuPrincipal/Fotos/marioDerecha.png").getImage();
    Image p1d = new ImageIcon("src/main/java/MenuPrincipal/Fotos/marioDerechaCaminando.png").getImage();
    Image p1i = new ImageIcon("src/main/java/MenuPrincipal/Fotos/marioIzquierdaCaminando.png").getImage();
    Image pp = new ImageIcon("src/main/java/MenuPrincipal/Fotos/marioDerecha.png").getImage();
    Image p2 = new ImageIcon("src/main/java/MenuPrincipal/Fotos/luigiIzquierda.png").getImage();
    Image p2d = new ImageIcon("src/main/java/MenuPrincipal/Fotos/luigiDerechaCaminando.png").getImage();
    Image p2i = new ImageIcon("src/main/java/MenuPrincipal/Fotos/luigiIzquierdaCaminando.png").getImage();
    Image p = new ImageIcon("src/main/java/MenuPrincipal/Fotos/luigiIzquierda.png").getImage();
    Image hock = new ImageIcon("src/main/java/MenuPrincipal/Fotos/Hock.png").getImage();

    public Paletas(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void moverIzquierda() {
        x -= velocidad;
        p2 = p2i;
        p1 = p1i;
    }

    public void moverDerecha() {
        x += velocidad;
        p2 = p2d;
        p1 = p1d;
    }

    public void moverArriba() {
        y -= velocidad;
        p2 = p;
        p1 = pp;
    }

    public void moverAbajo() {
        y += velocidad;
        p2 = p;
        p1 = pp;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public void dibujar(Graphics g) {
        if (x < 380) {
            g.drawImage(hock, 0, 0, 785, 363, null);
            g.drawImage(p1, x, y, tamanio / 2, tamanio, null);
        } else {
            g.drawImage(p2, x, y, tamanio / 2, tamanio, null);
        }

    }
}