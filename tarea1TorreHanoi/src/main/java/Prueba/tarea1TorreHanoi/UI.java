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
		private boolean esLaPrimeraVez = true;
		
        @SuppressWarnings("deprecation")
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
    				esLaPrimeraVez = false;
    				
    				if (!jugador.isEstaJugando()) {
    					botonIniciar.disable();
    					botonIniciar.setText("Jugando ...");
        				class HiloDelJugador extends Thread{
        					
        					@Override
        					public void run() {
        						jugador.calculoTorre(Integer.parseInt(campoCantidadDiscos.getText()), 0);
        					}
        				}
        				
        				HiloDelJugador hiloDelJugador = new HiloDelJugador();
        				hiloDelJugador.start();
    				} else {
    					System.out.println("Esta jugando ...");
    				}
    			}
    		});
    		
    		
    		
            Timer timer = new Timer(40, new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    repaint();
                }
            });
            timer.start();
            
            this.add(labelCantidadDiscos);
            this.add(campoCantidadDiscos);
            this.add(botonIniciar);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(800, 500);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            
            if (!jugador.isEstaJugando()) {
            	botonIniciar.setText("Iniciar");
            	botonIniciar.enable();
            }
            
            Graphics2D torre1 = (Graphics2D) g.create();
            torre1.setColor(Color.BLUE);
            torre1.fillRect(150, 200, 20, 200);
            torre1.dispose();
            
            Graphics2D torre2 = (Graphics2D) g.create();
            torre2.setColor(Color.BLUE);
            torre2.fillRect(350, 200, 20, 200);
            torre2.dispose();
            
            Graphics2D torre3 = (Graphics2D) g.create();
            torre3.setColor(Color.BLUE);
            torre3.fillRect(550, 200, 20, 200);
            torre3.dispose();
            
            int x = 110;
            int y = 380;

            Graphics2D disco1 = (Graphics2D) g.create();
            disco1.setColor(Color.ORANGE);
            
            Graphics2D disco2 = (Graphics2D) g.create();
            disco2.setColor(Color.GREEN);
            
            Graphics2D disco3 = (Graphics2D) g.create();
            disco3.setColor(Color.GRAY);
            
            Graphics2D disco4 = (Graphics2D) g.create();
            disco4.setColor(Color.RED);
            
            Graphics2D disco5 = (Graphics2D) g.create();
            disco5.setColor(Color.CYAN);
            
            if (esLaPrimeraVez) {
                disco1.fillRect(x, 300, 50, 20);
                disco2.fillRect(x, 320, 70, 20);
                disco3.fillRect(x, 340, 90, 20);
                disco4.fillRect(x, 360, 110, 20);
                disco5.fillRect(x, 380, 130, 20);
            }
            
            // Pintar discos
            for (Varilla varilla: jugador.getMisVarillas()) {
            	if (varilla.getIdVarilla() == 0) {
            		x = 110;
            	} else if (varilla.getIdVarilla() == 1) {
            		x = 310;
            	} else if (varilla.getIdVarilla() == 2) {
            		x = 510;
            	}
            	y = 380;
            	for(Disco disco: varilla.getLosDiscos()) {
            		
            		if (disco.getNumeroDisco() == 0) {
            			disco1.fillRect(x, y, disco.obtenerLargoDelDisco(), 20);
            		}else if (disco.getNumeroDisco() == 1) {
            			disco2.fillRect(x, y, disco.obtenerLargoDelDisco(), 20);
            		} else if (disco.getNumeroDisco() == 2) {
            			disco3.fillRect(x, y, disco.obtenerLargoDelDisco(), 20);
            		} else if (disco.getNumeroDisco() == 3) {
            			disco4.fillRect(x, y, disco.obtenerLargoDelDisco(), 20);
            		} else if (disco.getNumeroDisco() == 4) {
            			disco5.fillRect(x, y, disco.obtenerLargoDelDisco(), 20);
            		} 
                    
                    y -= 20;
            	}
            }
            
        }

    }
}
