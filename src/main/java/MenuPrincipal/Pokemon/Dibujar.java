package MenuPrincipal.Pokemon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Dibujar extends JPanel implements KeyListener {

    private Laberinto laberinto ;
    private Personaje gold = new Personaje(0,0);
    private Pokemon raiku = new Pokemon(0,0);
    private int punto1;
    private int punto2;
    private String j1;
    private String j2;
    private JLabel panel;
    Image fondo = new ImageIcon("src/main/java/MenuPrincipal/Fotos/BackGound.png").getImage();
    Image arbolito = new ImageIcon("src/main/java/MenuPrincipal/Fotos/Arbolito.png").getImage();
    Image meta = new ImageIcon("src/main/java/MenuPrincipal/Fotos/Meta.png").getImage();
    Image salto = new ImageIcon("src/main/java/MenuPrincipal/Fotos/BardaSalto.png").getImage();
    Image pasto = new ImageIcon("src/main/java/MenuPrincipal/Fotos/pasto.png").getImage();

    public Dibujar(String j1, String j2,int punto1, int punto2) {
        this.j1 = j1;
        this.j2 = j2;
        this.punto1=punto1;
        this.punto2=punto2;
        panel = new JLabel(j1 + " " + punto1 + " | " + j2 + " " + punto2);
        panel.setBounds(300,10,300,20);
        panel.setForeground(Color.BLACK);
        add(panel);
        laberinto= new Laberinto(j1, j2,punto1, punto2);
    }

    @Override
    public void paintComponent(Graphics g) {
        int x = 50;
        int y = 20;
        super.paintComponent(g);
        g.drawImage(pasto, 0, 0, 800, 500, null);
        int ancho = this.getWidth() / laberinto.getAlto(); //getWith = ancho
        int alto = this.getHeight() / laberinto.getAncho(); //getHeigth = alto
        for (int i = 0; i < laberinto.getLaberinto().length; i++) {
            x = 0;
            for (int j = 0; j < laberinto.getLaberinto()[0].length; j++) {
                int pos = laberinto.getLaberinto()[i][j];
                System.out.print(pos == 0 ? " " : pos);
                x += 25;
                switch (pos) {
                    case 1:
                        g.drawImage(arbolito, x, y, 25, 25, null);
                        break;
                    case 2:
                        gold.setX(x);
                        gold.setY(y);
                        gold.dibujar(g);
                        break;
                    case 3:
                        raiku.setX(x);
                        raiku.setY(y);
                        raiku.dibujar(g);
                        break;
                    case 5:
                        g.drawImage(salto, x, y, 25, 25, null);
                        break;
                    case 9:
                        g.drawImage(meta, x, y, 25, 25, null);
                        break;
                    default:
                        //g.drawImage(pasto, x, y, 20, 20, null);
                }
            }
            y += 25;
            System.out.println(" ");
        }
    }
    public int getPunto1() {
        punto1=laberinto.getPunto1();
        return punto1;
    }

    public int getPunto2() {
        punto2=laberinto.getPunto2();
        return punto2;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()== KeyEvent.VK_DOWN){
            gold.moverAbajo();
            System.out.println("push");
            laberinto.moverAbajo(laberinto.getJugador1(),2);
            repaint();
        }
        if(e.getKeyCode()== KeyEvent.VK_UP){
            gold.moverArriba();
            System.out.println("push");
            laberinto.moverArriba(laberinto.getJugador1(),2);
            repaint();
        }
        if(e.getKeyCode()== KeyEvent.VK_LEFT){
            gold.moverIzquierda();
            System.out.println("push");
            laberinto.moverIzquierda(laberinto.getJugador1(),2);
            repaint();
        }
        if(e.getKeyCode()== KeyEvent.VK_RIGHT){
            gold.moverDerecha();
            System.out.println("push");
            laberinto.moverDerecha(laberinto.getJugador1(),2);
            repaint();
        }
        if(e.getKeyCode()== KeyEvent.VK_S){
            raiku.moverAbajo();
            System.out.println("push");
            laberinto.moverAbajo(laberinto.getJugador2(),3);
            repaint();
        }
        if(e.getKeyCode()== KeyEvent.VK_W){
            raiku.moverArriba();
            System.out.println("push");
            laberinto.moverArriba(laberinto.getJugador2(),3);
            repaint();
        }
        if(e.getKeyCode()== KeyEvent.VK_A){
            raiku.moverIzquierda();
            System.out.println("push");
            laberinto.moverIzquierda(laberinto.getJugador2(),3);
            repaint();
        }
        if(e.getKeyCode()== KeyEvent.VK_D){
            raiku.moverDerecha();
            System.out.println("push");
            laberinto.moverDerecha(laberinto.getJugador2(),3);
            repaint();
        }

        panel.setText(j1 + " " + laberinto.getPunto1() + " | " + j2 + " " + laberinto.getPunto2());
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
