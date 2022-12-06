package Vista;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controlador.C_ConsultaReserva;
import Controlador.ValidarDatos;	

public class ConsultarReservacion extends JFrame implements ActionListener {
		
		JButton botonCanc,botonBus;
		VentanaPrincipal vp;
		ValidarDatos vd = new ValidarDatos();
		JTextField text ;
		
		
		public ConsultarReservacion(String titulo) {

			setSize(800, 600);
			setTitle(titulo);
			setResizable(false);
			setLocationRelativeTo(null);
			setVisible(true);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			
			JPanel panel = new JPanel();
			panel.setLayout(null);
			panel.setBackground(Color.LIGHT_GRAY);
			this.getContentPane().add(panel);
			
			JLabel eti0 = new JLabel("Ingrese el número de reservación");
			panel.add(eti0);
			eti0.setBounds(300, 10, 500, 150);
			eti0.setFont(new Font("Arial", 4, 15));

			JLabel eti1 = new JLabel("Número de Reservación");
			panel.add(eti1);
			eti1.setBounds(200, 150, 300, 80);
			eti1.setFont(new Font("Arial", 4, 15));

			text = new JTextField();
			panel.add(text);
			text.setBounds(400, 175, 200, 30);
			text.setFont(new Font("Arial", 4, 15));

			botonBus = new JButton("Buscar");
			botonBus.setBounds(200, 300, 150, 30);
			botonBus.setMnemonic('B');
			botonBus.setMnemonic('b');
			botonBus.setToolTipText("Presione ALT+B para Buscar");
			panel.add(botonBus);
			botonBus.addActionListener(this);

			botonCanc = new JButton("Cancelar");
			botonCanc.setBounds(450, 300, 150, 30);
			botonCanc.setMnemonic('C');
			botonCanc.setMnemonic('c');
			botonCanc.setToolTipText("Presione ALT+C para Cancelar");
			botonCanc.addActionListener(this);
			panel.add(botonCanc);
			
		}
		
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == this.botonCanc) {
					if(vp!=null) {
						vp.dispose();		
					}
					dispose();
					
					vp= new VentanaPrincipal("Hotel Las Gaviotas");		
			}
			
			if (e.getSource() == this.botonBus) {
				int numRes=0, cont=0;
				
				if(vd.NoReserva(text.getText())) {
    				numRes= Integer.parseInt(String.valueOf(text.getText()));
    				cont++;
				}
    			else 
    				javax.swing.JOptionPane.showMessageDialog(null,"CONSULTA NO EXITOSA. REVISAR NUMERO DE RESERVACION", "ERROR", JOptionPane.ERROR_MESSAGE);
    			
				if(cont==1) {
					C_ConsultaReserva c = new C_ConsultaReserva(numRes);
					c.ConsultaReserva();
					dispose();
				}
				else {
					javax.swing.JOptionPane.showMessageDialog(null,"CONSULTA NO EXITOSA. REVISAR DATOS", "ERROR", JOptionPane.ERROR_MESSAGE);
					cont=0;
				}
			}

		}

}
