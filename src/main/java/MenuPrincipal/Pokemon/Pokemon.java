package MenuPrincipal.Pokemon;

import javax.swing.*;
import java.awt.*;

public class Pokemon {
    private int x = 100;
    private int y = 100;
    private int velocidad = 1;
    private int tamanio = 25;
    private boolean iz = true;
    private boolean ar = true;
    private boolean ab = true;
    private boolean dr = true;
    Image raiku = new ImageIcon("src/main/java/MenuPrincipal/Fotos/RaikouAbajo1.png").getImage();
    Image raikouAbajo1 = new ImageIcon("src/main/java/MenuPrincipal/Fotos/RaikouAbajo1.png").getImage();
    Image raikouAbajo2 = new ImageIcon("src/main/java/MenuPrincipal/Fotos/RaikouAbajo2.png").getImage();
    Image raikouArriba1 = new ImageIcon("src/main/java/MenuPrincipal/Fotos/RaikouArriba1.png").getImage();
    Image raikouArriba2 = new ImageIcon("src/main/java/MenuPrincipal/Fotos/RaikouArriba2.png").getImage();
    Image raikouDerecha1 = new ImageIcon("src/main/java/MenuPrincipal/Fotos/RaikouDerecha1.png").getImage();
    Image raikouDerecha2 = new ImageIcon("src/main/java/MenuPrincipal/Fotos/RaikouDerecha2.png").getImage();
    Image raikouIzquierda1 = new ImageIcon("src/main/java/MenuPrincipal/Fotos/RaikouIzquierda1.png").getImage();
    Image raikouIzquierda2 = new ImageIcon("src/main/java/MenuPrincipal/Fotos/RaikouIzquierda2.png").getImage();
    Image poke = raiku;

    public Pokemon() {
    }

    public Pokemon(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void moverIzquierda() {
        x -= velocidad;
        x -= velocidad;
        if (iz == true) {
            raiku = raikouIzquierda1;
        } else {
            raiku = raikouIzquierda2;
        }
        iz = !iz;
    }

    public void moverDerecha() {
        x += velocidad;
        if (dr == true) {
            raiku = raikouDerecha1;
        } else {
            raiku = raikouDerecha2;
        }
        dr = !dr;
    }

    public void moverArriba() {
        y -= velocidad;
        if (ar == true) {
            raiku = raikouArriba1;
        } else {
            raiku = raikouArriba2;
        }
        ar = !ar;
    }

    public void moverAbajo() {
        y += velocidad;
        if (ab == true) {
            raiku = raikouAbajo1;
        } else {
            raiku = raikouAbajo2;
        }
        ab = !ab;
    }

    public void estatic() {
        raiku = poke;
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

    public int getVelocidad() {
        return velocidad;
    }

    public void dibujar(Graphics g) {
        g.drawImage(raiku, x, y, tamanio, tamanio, null);
    }
}
