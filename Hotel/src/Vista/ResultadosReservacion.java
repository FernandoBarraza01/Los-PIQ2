package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ResultadosReservacion extends JDialog implements ActionListener {
	
	JPanel panel1, panel2;
	JLabel label1, label2, label3, label4, label5, label6, label7, label8;
	public static JButton botonMod, botonCanc, botonSalir;
	public static JTextField texto1, texto2, texto3, texto4, texto5, texto6,texto7, texto8; 
	ModificarReservacion mr ;
	CancelarReservacion cr;
	VentanaPrincipal vp;
	
	
	public ResultadosReservacion(String titulo) {

		setSize(800, 600);
		setTitle(titulo);
		setResizable(false);
		setLocationRelativeTo(null);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		//setModal(true);
		
		
		panel1=new JPanel();
		panel2=new JPanel();
		
		botonMod=new JButton("Modificar");
		botonCanc=new JButton("Cancelar");
		botonSalir = new JButton("Salir");
		
		label1 = new JLabel("ID Reservacion");
		label2 = new JLabel("Nombre");
		label3 = new JLabel("Apellido(s)");
		label4 = new JLabel("Fecha llegada");
		label5 = new JLabel("Fecha Salida");
		label6 = new JLabel("Telefono");
		label7 = new JLabel("Tipo de habitacion");
		label8 = new JLabel("Status");
		
		texto1= new JTextField();
		texto1.setEditable(false);
		texto2= new JTextField();
		texto2.setEditable(false);
		texto3= new JTextField();
		texto3.setEditable(false);
		texto4= new JTextField();
		texto4.setEditable(false);
		texto5= new JTextField();
		texto5.setEditable(false);
		texto6= new JTextField();
		texto6.setEditable(false);
		texto7= new JTextField();
		texto7.setEditable(false);
		texto8= new JTextField();
		texto8.setEditable(false);
		
		panel1.setLayout(new GridLayout(0,1));
		panel1.setBackground(Color.LIGHT_GRAY);
		panel2.setBackground(Color.LIGHT_GRAY);
		
		add(panel1,BorderLayout.CENTER);
		add(panel2,BorderLayout.SOUTH);
		
		panel1.add(label1);
		panel1.add(texto1);
		panel1.add(label2);
		panel1.add(texto2);
		panel1.add(label3);
		panel1.add(texto3);
		panel1.add(label4);
		panel1.add(texto4);
		panel1.add(label5);
		panel1.add(texto5);
		panel1.add(label6);
		panel1.add(texto6);
		panel1.add(label7);
		panel1.add(texto7);
		panel1.add(label8);
		panel1.add(texto8);
		
		panel2.add(botonMod);
		panel2.add(botonCanc);
		panel2.add(botonSalir);
		
		botonMod.addActionListener(this);
		botonCanc.addActionListener(this);
		botonSalir.addActionListener(this);
		botonMod.setHorizontalAlignment(SwingConstants.CENTER);
		botonCanc.setHorizontalAlignment(SwingConstants.CENTER);
		botonSalir.setHorizontalAlignment(SwingConstants.CENTER);
		
		botonMod.setMnemonic('M');
		botonMod.setMnemonic('m');
		botonMod.setToolTipText("Presione ALT+M para Modificar");
		
		botonCanc.setMnemonic('C');
		botonCanc.setMnemonic('c');
		botonCanc.setToolTipText("Presione ALT+C para Cancelar reservación");
		
		botonSalir.setMnemonic('E');
		botonSalir.setMnemonic('e');
		botonSalir.setToolTipText("Presione ALT+E para Salir");
		
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==botonCanc) {
			if(cr!=null) {
				cr.dispose();		
			}
			else {
				dispose();
				cr= new CancelarReservacion();	
			}
			cr.campo1.setText(texto1.getText());	
		}
			
		if(e.getSource()==botonMod) {
			if(mr!=null) {
				mr.dispose();		
			}
			else {
				dispose();
				mr= new ModificarReservacion();
			}
			mr.texto.setText(texto1.getText());
		}
		
		if(e.getSource()==botonSalir) {
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
