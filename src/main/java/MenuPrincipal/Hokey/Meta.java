package MenuPrincipal.Hokey;

import javax.swing.*;
import java.awt.*;

public class Meta {
    private int x = 100;
    private int y = 100;
    private int tamanio = 141;
    private int velocidad = 1;
    private boolean irDerecha = true;
    private boolean irArriba = true;

    public Meta(int x, int y) {
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
        g.setColor(Color.white);
        g.fillRect(x,y,1,tamanio);
    }
}
