package MenuPrincipal.Hokey;

import javax.swing.*;
import java.awt.*;

public class Pelota {
    private int x;
    private int y;
    private int tamanio = 25;
    private int velocidad = 1;
    Image pelo = new ImageIcon("src/main/java/MenuPrincipal/Fotos/Caparazon.png").getImage();
    private boolean irDerecha = true;
    private boolean irArriba = true;

    public Pelota(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void mover() {
        if (irDerecha)
            moverDerecha();
        else
            moverIzquierda();
        if (irArriba)
            moverArriba();
        else
            moverAbajo();
    }

    public void moverIzquierda() {
        x -= velocidad;
    }

    public void moverDerecha() {
        x += velocidad;
    }

    public void moverArriba() {
        y -= velocidad;
    }

    public void moverAbajo() {
        y += velocidad;
    }

    public void cambiarHorizontal() {
        irDerecha = !irDerecha;
    }

    public void cambiarAltura() {
        irArriba = !irArriba;
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
        g.drawImage(pelo, x, y, tamanio, tamanio, null);
    }
}
