package MenuPrincipal.Topos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class Game extends JPanel implements MouseListener, Runnable {
    private ArrayList<Topo> lista = new ArrayList<>();
    private int punto1 = 0;
    private JLabel panel;
    private String j1;

    public Game(String j1) {
        this.j1 = j1;
        panel = new JLabel(j1 + " | " + punto1 + " | ");
        add(panel);
        lista.add(new Topo(50, 100));
        lista.add(new Topo(150, 200));
        lista.add(new Topo(300, 250));
        lista.add(new Topo(400, 100));
        lista.add(new Topo(500, 200));
        lista.add(new Topo(700, 100));
        setBackground(Color.WHITE);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        lista.get(0).fondo(g);
        for (int i = 0; i < lista.size(); i++) {
            lista.get(i).dibujar(g);
            lista.get(i).tierra(g);
        }
        repaint();
    }

    public void verificar(Topo topo, int x, int y, MouseEvent e) throws InterruptedException {
        Rectangle topos = new Rectangle((int) topo.getX(), (int) topo.getY() + 30, topo.getTamanio(), topo.getTamanio() - topo.getTamanio() / 2);
        Rectangle tierras = new Rectangle((int) topo.getX() - topo.getTamanio() / 4, (int) topo.getPosicionInicial() + 30, topo.getTamanio() + topo.getTamanio() / 2, topo.getTamanio() + topo.getTamanio() / 2);
        if (tierras.contains(e.getPoint())) {
            return;
        }
        if (topos.contains(e.getPoint())) {
            float posicion = (float) topo.getPosicionInicial();
            punto1 += 1;
            topo.setY(posicion);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            int x = e.getX();
            int y = e.getY();
            try {
                for (int i = 0; i < lista.size(); i++) {
                    verificar(lista.get(i), x, y, e);
                }
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void run() {
        while (true) {
            try {
                for (int i = 0; i < lista.size(); i++) {
                    lista.get(i).mover();
                    Thread.sleep(1);
                }
                panel.setText(j1 + " | " + punto1 + " | ");
                repaint();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
