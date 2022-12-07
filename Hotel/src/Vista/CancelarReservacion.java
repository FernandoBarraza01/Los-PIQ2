package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Controlador.C_CancelarReservacion;

public class CancelarReservacion extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
		JPanel panel,panel2;
		JButton botonSalir;
		JButton botonConf;
		VentanaPrincipal vp;
		JTextField campo1;

		public CancelarReservacion() {
			setSize(800, 600);
			setTitle("Cancelar Reservacion");
			setLocationRelativeTo(null);
			setResizable(false);
			iniciar();
			etiquetas();
			campo_text();
			agregar_botones();
			setVisible(true);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
		}

		public void iniciar() {

			panel = new JPanel();
			panel.setLayout(null);
			panel.setBackground(Color.LIGHT_GRAY);
			add(panel,BorderLayout.CENTER);
			
			panel2 = new JPanel();
			panel2.setBackground(Color.LIGHT_GRAY);
			add(panel2,BorderLayout.SOUTH);

		}

		public void etiquetas() {
			JLabel text1 = new JLabel();
			text1.setText("ID de Reservacion a Cancelar");
			text1.setBounds(250, 75, 500, 50);
			panel.add(text1);
			
			JLabel text2 = new JLabel("Id Reservacion:");
			text2.setBounds(100, 100, 400, 150);
			panel.add(text2);


		}

		public void campo_text() {
			campo1 = new JTextField();
			campo1.setBounds(250, 160, 100, 30);
			campo1.setEditable(false);
			panel.add(campo1);

			
		}

		public void agregar_botones() {
			
			botonConf = new JButton("Confirmar");
			botonConf.setBounds(450, 450, 300, 30);
			botonConf.setEnabled(true);
			botonConf.addActionListener(this);
			
			botonSalir = new JButton("Volver a la pantalla de inicio");
			botonSalir.setBounds(100, 450, 300, 30);
			botonSalir.setEnabled(true);
			botonSalir.addActionListener(this);
			
			botonConf.setMnemonic('C');
			botonConf.setMnemonic('c');
			botonConf.setToolTipText("Presione ALT+C para Cancelar reservación");
			
			botonSalir.setMnemonic('E');
			botonSalir.setMnemonic('e');
			botonSalir.setToolTipText("Presione ALT+E para Salir");
			panel2.add(botonConf);
			panel2.add(botonSalir);
			
			
			
			
		}

		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == this.botonSalir) {
				if(vp!=null) {
					vp.dispose();		
				}
				dispose();
				vp= new VentanaPrincipal("Hotel Las Gaviotas");	
			}
			
			if (e.getSource() == this.botonConf) {
				
				String status= "Cancelada";
				int numRes= 0;
				numRes= Integer.parseInt(String.valueOf(campo1.getText()));
				int op;
				op= javax.swing.JOptionPane.showConfirmDialog(null,"¿DESEA CANCELAR LA RESERVACION?", "CANCELACION", JOptionPane.YES_NO_OPTION);	
				
				if(op==0) {
					C_CancelarReservacion c = new C_CancelarReservacion(numRes, status);
					c.CancelarReservacion();
					if(vp!=null) {
						vp.dispose();		
					}
					else {
						dispose();
						vp= new VentanaPrincipal("Hotel Las Gaviotas");		
					}
				}
			}

		}
}
