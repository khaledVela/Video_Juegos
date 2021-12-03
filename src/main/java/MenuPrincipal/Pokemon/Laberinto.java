package MenuPrincipal.Pokemon;

import javax.swing.*;
import java.awt.*;

public class Laberinto {
    private int[][] laberinto = {
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 2, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 9, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 3, 0, 0, 0, 1, 1, 1, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 5, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 5, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1},
            {1, 0, 0, 9, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 1, 5, 5, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
    };

    private Point jugador;
    private Point jugador2;
    private Point gold;
    private Point rayquaza;
    private int punto1;
    private int punto2;
    private String j1;
    private String j2;

    public Laberinto(String j1, String j2,int punto1, int punto2) {
        this.j1 = j1;
        this.j2 = j2;
        this.punto1=punto1;
        this.punto2=punto2;
        for (int i = 0; i < laberinto.length; i++) {
            for (int j = 0; j < laberinto[0].length; j++) {
                if (laberinto[i][j] == 2) {
                    jugador = new Point(j, i);
                    gold = jugador;
                }
                if (laberinto[i][j] == 3) {
                    jugador2 = new Point(j, i);
                    rayquaza = jugador2;
                }
            }
        }
    }

    public Point getJugador1() {
        return jugador;
    }

    public Point getJugador2() {
        return jugador2;
    }

    public void moverAbajo(Point jugador, int x) {
        if (x == 3) {
            if (laberinto[jugador.y + 1][jugador.x] == 9) {
                laberinto[jugador.y + 1][jugador.x] = 9;
                JOptionPane.showMessageDialog(null, "Raiquaza escapo!");
                punto2+=1;
                laberinto[jugador.y][jugador.x] = 0;
                jugador.y = jugador.y + 1;
            }
            if (laberinto[jugador.y + 1][jugador.x] == 5) {
                laberinto[jugador.y + 2][jugador.x] = x;
                laberinto[jugador.y][jugador.x] = 0;
                jugador.y = jugador.y + 2;
            }
        }
        if (x == 2) {
            if (laberinto[jugador.y + 1][jugador.x] == 3) {
                laberinto[jugador.y + 1][jugador.x] = x;
                laberinto[jugador.y][jugador.x] = 0;
                jugador.y = jugador.y + 1;
                JOptionPane.showMessageDialog(null, "Gold ha capturado a Raiquaza!");
                punto1+=1;
            }
        }
        if (laberinto[jugador.y + 1][jugador.x] == 0) {
            laberinto[jugador.y + 1][jugador.x] = x;
            laberinto[jugador.y][jugador.x] = 0;
            jugador.y = jugador.y + 1;
        }
        verificarMeta(x);
    }

    public void moverArriba(Point jugador, int x) {
        if (x == 3) {
            if (laberinto[jugador.y - 1][jugador.x] == 9) {
                laberinto[jugador.y - 1][jugador.x] = 9;
                JOptionPane.showMessageDialog(null, "Raiquaza escapo!");
                punto2+=1;
                laberinto[jugador.y][jugador.x] = 0;
                jugador.y = jugador.y - 1;
            }
            if (laberinto[jugador.y - 1][jugador.x] == 5) {
                laberinto[jugador.y - 2][jugador.x] = x;
                laberinto[jugador.y][jugador.x] = 0;
                jugador.y = jugador.y - 2;
            }
        }
        if (x == 2) {
            if (laberinto[jugador.y - 1][jugador.x] == 3) {
                laberinto[jugador.y - 1][jugador.x] = x;
                laberinto[jugador.y][jugador.x] = 0;
                jugador.y = jugador.y - 1;
                JOptionPane.showMessageDialog(null, "Gold ha capturado a Raiquaza!");
                punto1+=1;
            }
        }
        if (laberinto[jugador.y - 1][jugador.x] == 0) {
            laberinto[jugador.y - 1][jugador.x] = x;
            laberinto[jugador.y][jugador.x] = 0;
            jugador.y = jugador.y - 1;
        }
        verificarMeta(x);
    }

    public void moverIzquierda(Point jugador, int x) {
        if (x == 3) {
            if (laberinto[jugador.y][jugador.x - 1] == 9) {
                laberinto[jugador.y][jugador.x - 1] = 9;
                JOptionPane.showMessageDialog(null, "Raiquaza escapo!");
                punto2+=1;
                laberinto[jugador.y][jugador.x] = 0;
                jugador.x = jugador.x - 1;
                reinicio();
            }
            if (laberinto[jugador.y][jugador.x - 1] == 5) {
                laberinto[jugador.y][jugador.x - 2] = x;
                laberinto[jugador.y][jugador.x] = 0;
                jugador.x = jugador.x - 2;
            }
        }
        if (x == 2) {
            if (laberinto[jugador.y][jugador.x - 1] == 3) {
                laberinto[jugador.y][jugador.x - 1] = x;
                laberinto[jugador.y][jugador.x] = 0;
                jugador.x = jugador.x - 1;
                JOptionPane.showMessageDialog(null, "Gold ha capturado a Raiquaza!");
                punto1+=1;
            }
        }
        if (laberinto[jugador.y][jugador.x - 1] == 0) {
            laberinto[jugador.y][jugador.x - 1] = x;
            laberinto[jugador.y][jugador.x] = 0;
            jugador.x = jugador.x - 1;
        }
        verificarMeta(x);
    }

    public void moverDerecha(Point jugador, int x) {
        if (x == 3) {
            if (laberinto[jugador.y][jugador.x + 1] == 9) {
                laberinto[jugador.y][jugador.x + 1] = 9;
                JOptionPane.showMessageDialog(null, "Raiquaza escapo!");
                punto2+=1;
                laberinto[jugador.y][jugador.x] = 0;
                jugador.x = jugador.x + 1;
            }
            if (laberinto[jugador.y][jugador.x + 1] == 5) {
                laberinto[jugador.y][jugador.x + 2] = x;
                laberinto[jugador.y][jugador.x] = 0;
                jugador.x = jugador.x + 2;
            }
        }
        if (x == 2) {
            if (laberinto[jugador.y][jugador.x + 1] == 3) {
                laberinto[jugador.y][jugador.x + 1] = x;
                laberinto[jugador.y][jugador.x] = 0;
                jugador.x = jugador.x + 1;
                JOptionPane.showMessageDialog(null, "Gold ha capturado a Raiquaza!");
                punto1+=1;
            }
        }
        if (laberinto[jugador.y][jugador.x + 1] == 0) {
            laberinto[jugador.y][jugador.x + 1] = x;
            laberinto[jugador.y][jugador.x] = 0;
            jugador.x = jugador.x + 1;
        }
        verificarMeta(x);
    }

    private void verificarMeta(int x) {
        if (laberinto[jugador.y][jugador.x] == 9) {
            System.out.println("pepe");
            laberinto[jugador.y][jugador.x] = x;
        }
    }

    public void reinicio() {
        jugador = gold;
        jugador2 = rayquaza;
    }

    public int[][] getLaberinto() {
        return laberinto;
    }

    public int getAncho() {
        return laberinto.length;
    }

    public int getAlto() {
        return laberinto[0].length;
    }
    public int getPunto1() {
        return punto1;
    }

    public int getPunto2() {
        return punto2;
    }
}
