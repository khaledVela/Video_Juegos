package MenuPrincipal.Topos;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;


public class Topo {
    private float x = 100;
    private float y = 100;
    private float posicionInicial = 0;
    private float velocidad = (float) 1;
    private int tamanio = 50;
    private boolean movimiento = true;
    private boolean golpe = false;
    private Thread hilo = new Thread();
    private Image fondoI = new ImageIcon("src/main/java/MenuPrincipal/Fotos/backtopos.png").getImage();
    private Image topoI = new ImageIcon("src/main/java/MenuPrincipal/Fotos/topito.png").getImage();
    private Image tierraI = new ImageIcon("src/main/java/MenuPrincipal/Fotos/tierra.png").getImage();

    public Topo(float x, float y) {
        this.x = x;
        this.y = y;
        posicionInicial = this.y;
        velocidad = velocidad();
    }

    public void golpeado() throws InterruptedException {
        golpe = !golpe;
    }

    public float velocidad() {
        int velocidades = (int) ((Math.random() * 4) + 1);
        switch (velocidades) {
            case 1:
                velocidad = (float) 0.25;
                break;
            case 2:
                velocidad = (float) 0.5;
                break;
            case 3:
                velocidad = (float) 1;
                break;
            case 4:
                velocidad = 2;
                break;
        }
        return velocidad;
    }

    public void mover() {
        if (golpe == false) {
            if (y * -1 >= y - posicionInicial * 2 + tamanio / 2 + 50) {
                movimiento = false;
                velocidad = velocidad();
            }
            if (y >= posicionInicial + tamanio / 2) {
                movimiento = true;
                velocidad = velocidad();
            }
            if (movimiento == false) {
                y += velocidad;
            }
            if (movimiento == true) {
                y -= velocidad;
            }
        }
    }

    public void setVelocidad(float velocidad) {
        this.velocidad = velocidad;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setMovimiento(boolean movimiento) {
        this.movimiento = movimiento;
    }

    public float getPosicionInicial() {
        return posicionInicial;
    }

    public int getTamanio() {
        return tamanio;
    }

    public boolean isMovimiento() {
        return movimiento;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void fondo(Graphics fondo) {
        fondo.drawImage(fondoI, 0, 0, 800, 400, null);
    }

    public void tierra(Graphics tierra) {
        int x = (int) this.x;
        int posicionInicial = (int) this.posicionInicial;
        tierra.drawImage(tierraI, x - tamanio / 4, posicionInicial, tamanio + tamanio / 2, tamanio + tamanio / 2, null);
        //tierra.drawRect(x - tamanio / 4, posicionInicial, tamanio + tamanio / 2, tamanio + tamanio / 2);
    }

    public void dibujar(Graphics topo) {
        int x = (int) this.x;
        int y = (int) this.y;
        topo.drawImage(topoI, x, y, tamanio, tamanio - tamanio / 2, null);
        //topo.drawRect(x, y, tamanio, tamanio - tamanio / 2);
    }
}
