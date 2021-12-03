package MenuPrincipal;

import MenuPrincipal.Hokey.Hockey;
import MenuPrincipal.Hokey.Ventana_H;
import MenuPrincipal.Pokemon.Ventana_P;
import MenuPrincipal.Topos.Ventana_T;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Menu extends JFrame implements ActionListener, MouseListener {
    private JPanel jpanel;
    private JButton jbpokemon = new JButton("Pokemon");
    private JButton jbtopo = new JButton("Topos");
    private JButton jbhokey = new JButton("Hokey");
    private JLabel jlmarca;
    private JLabel jlpokemon;
    private JLabel jltopo;
    private JLabel jlhokey;
    private String jugador1;
    private String jugador2;
    private int punto1;
    private int punto2;
    private JLabel panel;

    public Menu(String jugador1, String jugador2,int punto1,int punto2) {
        setSize(700, 500);
        setTitle("Tres en Uno");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(700, 500));
        setLocationRelativeTo(null);
        this.punto1 = punto1;
        this.punto2 = punto2;
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        Panel();
        System.out.println(jugador1 + " " + punto1 + " | " + jugador2 + " " + punto2);
        setVisible(true);
    }

    public Menu() {
        setSize(700, 500);
        setTitle("Tres en Uno");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(700, 500));
        setLocationRelativeTo(null);
        jugador1 = JOptionPane.showInputDialog(rootPane, "Nombre del jugador 1");
        jugador2 = JOptionPane.showInputDialog(rootPane, "Nombre del jugador 2");
        punto1 = 0;
        punto2 = 0;
        Panel();
        setVisible(true);
    }

    public String getJugador1() {
        return jugador1;
    }

    public String getJugador2() {
        return jugador2;
    }

    private void Panel() {
        jpanel = new JPanel();
        jpanel.setLayout(null);
        jpanel.setBackground(new Color(255, 188, 88));
        this.getContentPane().add(jpanel);
        panel = new JLabel(jugador1 + " " + punto1 + " | " + jugador2 + " " + punto2);
        panel.setBounds(300,10,300,20);
        panel.setForeground(Color.BLACK);
        jpanel.add(panel);
        jlmarca = new JLabel(new ImageIcon("descargas.png"));
        jlmarca.setBounds(-125, -250, 960, 958);
        jpanel.add(jlmarca);
        jbpokemon.setBounds(50, 50, 100, 50);
        jbpokemon.addMouseListener(this);
        jbpokemon.addActionListener(this::actionPerformed);
        jbtopo.setBounds(300, 350, 100, 50);
        jbtopo.addMouseListener(this);
        jbtopo.addActionListener(this::actionPerformed);
        jbhokey.setBounds(540, 50, 100, 50);
        jbhokey.addMouseListener(this);
        jbhokey.addActionListener(this::actionPerformed);
        jpanel.add(jbpokemon);
        jpanel.add(jbtopo);
        jpanel.add(jbhokey);
        //pokemon
        jlpokemon = new JLabel(new ImageIcon("Pokemon.png"));
        jlpokemon.setBounds(-125, -250, 960, 958);
        jlpokemon.setVisible(false);
        jpanel.add(jlpokemon);
        //topo
        jltopo = new JLabel(new ImageIcon("topo.png"));
        jltopo.setBounds(-125, -250, 960, 958);
        jltopo.setVisible(false);
        jpanel.add(jltopo);
        //hokey
        jlhokey = new JLabel(new ImageIcon("Hokey.jpeg"));
        jlhokey.setBounds(-125, -250, 960, 958);
        jlhokey.setVisible(false);
        jpanel.add(jlhokey);
    }

    public static void main(String[] args) {
        new Menu();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clic = (JButton) e.getSource();
        if (clic.equals(jbpokemon)) {
            JOptionPane.showMessageDialog(rootPane, "Iniciando el juego Pokemon");
            Ventana_P pokemon = new Ventana_P(jugador1, jugador2,punto1,punto2);
            setVisible(false); //esto permite eliminar la ventana aterior
        }
        if (clic.equals(jbtopo)) {
            JOptionPane.showMessageDialog(rootPane, "Iniciando el juego Topo");
            Ventana_T topos = new Ventana_T(jugador1, jugador2, punto1, punto2);
            setVisible(false);

        }
        if (clic.equals(jbhokey)) {
            JOptionPane.showMessageDialog(rootPane, "Iniciando el juego Hokey");
            new Ventana_H(jugador1, jugador2, punto1, punto2);
            setVisible(false);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        int x = 0;
        int y = 0;
        x = e.getXOnScreen();
        if (x > 390 && x < 491) {
            jlpokemon.setVisible(true);
            jltopo.setVisible(false);
            jlhokey.setVisible(false);
            repaint();
        }
        if (x > 640 && x < 741) {
            jlpokemon.setVisible(false);
            jltopo.setVisible(true);
            jlhokey.setVisible(false);
            repaint();
        }
        if (x > 880 && x < 981) {
            jlpokemon.setVisible(false);
            jltopo.setVisible(false);
            jlhokey.setVisible(true);
            repaint();
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
