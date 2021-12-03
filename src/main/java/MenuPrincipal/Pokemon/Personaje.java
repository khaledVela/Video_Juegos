package MenuPrincipal.Pokemon;

import javax.swing.*;
import java.awt.*;

public class Personaje {
    private int x = 100;
    private int y = 100;
    private int velocidad = 1;
    private int tamanio = 25;
    private boolean iz = true;
    private boolean ar = true;
    private boolean ab = true;
    private boolean dr = true;
    Image gold = new ImageIcon("src/main/java/MenuPrincipal/Fotos/GoldAbajoParado.png").getImage();
    Image goldAbajoParado = new ImageIcon("src/main/java/MenuPrincipal/Fotos/GoldAbajoParado.png").getImage();
    Image goldAbajoCorriendo1 = new ImageIcon("src/main/java/MenuPrincipal/Fotos/GoldAbajoCorriendo1.png").getImage();
    Image goldAbajoCorriendo2 = new ImageIcon("src/main/java/MenuPrincipal/Fotos/GoldAbajoCorriendo2.png").getImage();
    Image goldArribaParado = new ImageIcon("src/main/java/MenuPrincipal/Fotos/GoldArribaParado.png").getImage();
    Image goldArribaCorriendo1 = new ImageIcon("src/main/java/MenuPrincipal/Fotos/GoldArribaCorriendo1.png").getImage();
    Image goldArribaCorriendo2 = new ImageIcon("src/main/java/MenuPrincipal/Fotos/GoldArribaCorriendo2.png").getImage();
    Image goldDerechaParado = new ImageIcon("src/main/java/MenuPrincipal/Fotos/GoldDerechaParado.png").getImage();
    Image goldDerechaCorriendo1 = new ImageIcon("src/main/java/MenuPrincipal/Fotos/GoldDerechaCorriendo1.png").getImage();
    Image goldDerechaCorriendo2 = new ImageIcon("src/main/java/MenuPrincipal/Fotos/GoldDerechaCorriendo2.png").getImage();
    Image goldIzquierdaParado = new ImageIcon("src/main/java/MenuPrincipal/Fotos/GoldIzquierdaParado.png").getImage();
    Image goldIzquierdaCorriendo1 = new ImageIcon("src/main/java/MenuPrincipal/Fotos/GoldIzquierdaCorriendo1.png").getImage();
    Image goldIzquierdaCorriendo2 = new ImageIcon("src/main/java/MenuPrincipal/Fotos/GoldIzquierdaCorriendo2.png").getImage();
    Image perso = gold;

    public Image getGold() {
        return gold;
    }

    public Personaje() {

    }

    public Personaje(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void moverIzquierda() {
        x -= velocidad;
        if (iz == true) {
            gold = goldIzquierdaCorriendo1;
        } else {
            gold = goldIzquierdaCorriendo2;
        }
        iz = !iz;
    }

    public void moverDerecha() {
        x += velocidad;
        if (dr == true) {
            gold = goldDerechaCorriendo1;
        } else {
            gold = goldDerechaCorriendo2;
        }
        dr = !dr;
    }

    public void moverArriba() {
        y -= velocidad;
        if (ar == true) {
            gold = goldArribaCorriendo1;
        } else {
            gold = goldArribaCorriendo2;
        }
        ar = !ar;
    }

    public void moverAbajo() {
        y += velocidad;
        if (ab == true) {
            gold = goldAbajoCorriendo1;
        } else {
            gold = goldAbajoCorriendo2;
        }
        ab = !ab;
    }

    public void estatic() {
        Image gold = perso;
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
        g.drawImage(gold, x, y, tamanio, tamanio, null);
    }
}
