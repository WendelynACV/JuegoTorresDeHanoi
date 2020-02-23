package Prueba.tarea1TorreHanoi;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


/**
 * Hello world!
 *
 */
public class UI
{
	/**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new UI();
    }

    public UI() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Torre de Hanoi");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new Panel());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class Panel extends JPanel {

		private static final long serialVersionUID = 1L;
		private Jugador jugador; 
		private JButton botonIniciar;
		
		private JLabel labelCantidadDiscos;
		private JTextField campoCantidadDiscos;
		
		private int x = 0;
        private int y = 0;

        public Panel() {
        	jugador = new Jugador();
        			
        	labelCantidadDiscos = new JLabel("Cantidad de discos", SwingConstants.LEFT);
    		labelCantidadDiscos.setBounds(10, 45, 225, 50);
    		labelCantidadDiscos.setLayout(new BorderLayout());
    		labelCantidadDiscos.setForeground(Color.ORANGE);
    		labelCantidadDiscos.setFont(new Font("Tahoma", Font.BOLD, 16));
        	
    		campoCantidadDiscos = new JTextField();
    		campoCantidadDiscos.setBounds(85, 95, 86, 20);
    		campoCantidadDiscos.setColumns(10);
    		campoCantidadDiscos.setText("5");
    		campoCantidadDiscos.disable();
    		
    		botonIniciar = new JButton("Iniciar");
    		botonIniciar.setBounds(10, 267, 89, 23);
    		botonIniciar.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent e) {
    		        jugador.calculoTorre(Integer.parseInt(campoCantidadDiscos.getText()), 0);
    			}
    		});
    		
            Timer timer = new Timer(40, new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    moveBall();
                    repaint();
                }
            });
            timer.start();
            
            this.add(labelCantidadDiscos);
            this.add(campoCantidadDiscos);
            this.add(botonIniciar);
        }

        protected void moveBall() {
            x++;
            y++;
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(800, 500);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setColor(Color.RED);
            g2d.fillOval(x, y, 30, 30);
            g2d.dispose();
        }

    }
}
