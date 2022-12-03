package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Controlador.C_ModificarReservacion;
import Controlador.ValidarDatos;

public class ModificarReservacion extends JFrame implements ActionListener {
	
	JButton botonMod, botonCanc;
	JComboBox<String> year, dia, mes, yearS, diaS, mesS;
	JRadioButton sencilla, doble;
	JTextField textod, texto;
	ButtonGroup hab;
	VentanaPrincipal vp;
	ValidarDatos vd; 
	JLabel eti, etia, etib;

	public ModificarReservacion() {
		
		this.setSize(900, 600);
		this.getContentPane().setBackground(Color.GREEN);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Modificar Reservacion");
		setResizable(false);
		setVisible(true);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		this.getContentPane().add(panel);
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setLayout(null);
		vd= new ValidarDatos();

		

		// ETIQUETAS
		// TITULO PRINCIPAL
		eti = new JLabel();
		eti.setText("Datos a modificar");
		eti.setBounds(200, 5, 300, 80);
		panel.add(eti);
		eti.setFont(new Font("SERIF", Font.ITALIC, 30));
		eti.setForeground(Color.BLACK);
		

		etia = new JLabel();
		etia.setText("Id Reservacion");
		panel.add(etia);
		etia.setBounds(3, 60, 300, 80);
		etia.setForeground(Color.BLACK);
		etia.setFont(new Font("Arial", 4, 15));

		JLabel etib = new JLabel();
		etib.setText("Fecha de Llegada");
		panel.add(etib);
		etib.setBounds(3, 135, 300, 80);
		etib.setForeground(Color.BLACK);
		etib.setFont(new Font("Arial", 4, 15));
		
		JLabel etic = new JLabel();
		etic.setText("Fecha de Salida");
		panel.add(etic);
		etic.setBounds(3, 210, 300, 80);
		etic.setForeground(Color.BLACK);
		etic.setFont(new Font("Arial", 4, 15));

		JLabel etid = new JLabel();
		etid.setText("Tipo de Habitacion");
		panel.add(etid);
		etid.setBounds(3, 285, 300, 80);
		etid.setForeground(Color.BLACK);
		etid.setFont(new Font("Arial", 4, 15));

		JLabel etie = new JLabel();
		etie.setText("Precio");
		panel.add(etie);
		etie.setBounds(3, 360, 300, 80);
		etie.setForeground(Color.BLACK);
		
		etie.setFont(new Font("Arial", 4, 15));

		// CAJAS DE TEXTO
		texto = new JFormattedTextField();
		texto.setEditable(false);
		panel.add(texto);
		texto.setBounds(200, 90, 200, 30);// texto Id Reservacion

		textod = new JFormattedTextField();
		panel.add(textod);
		textod.setBounds(200, 380, 200, 30);// texto Precio

		// BOTONES
	    botonMod = new JButton("Modificar");
	    botonMod.setBounds(250, 450, 150, 30);
		panel.add(botonMod);
		botonMod.setForeground(Color.BLACK);
		
		botonMod.addActionListener(this);

	    botonCanc= new JButton("Cancelar");
		botonCanc.setBounds(415, 450, 150, 30);
		panel.add(botonCanc);
		botonCanc.setForeground(Color.BLACK);
		botonCanc.addActionListener(this);

		// COMBOBOX
		
		
		
		hab=new ButtonGroup();
		
		sencilla = new JRadioButton("Sencilla",true);
		doble = new JRadioButton("Doble");
		hab.add(sencilla);
		hab.add(doble);
		panel.add(sencilla);
		panel.add(doble);
		
		sencilla.setBounds(200, 310, 200, 30);
		doble.setBounds(200, 330, 200, 30);
		
		year = new JComboBox<String>();
		year.setBounds(620, 160, 200, 30);   //Fecha de llegada
		panel.add(year);
		
		dia = new JComboBox<String>();
		dia.setBounds(200, 160, 200, 30);    //Fecha de llegada
		panel.add(dia);
		
		mes = new JComboBox<String>();
		mes.setBounds(410, 160, 200, 30);    //Fecha de llegada
		panel.add(mes);
		
		diaS = new JComboBox<String>();
		diaS.setBounds(200, 230, 200, 30);  //Fecha de salida
		panel.add(diaS);
		
		mesS = new JComboBox<String>();
		mesS.setBounds(410, 230, 200, 30);    //Fecha de salida
		panel.add(mesS);
		
		yearS = new JComboBox<String>();
		yearS.setBounds(620, 230, 200, 30);   //Fecha de salida
		panel.add(yearS);
	
	    
		dia.addItem("--Día--");
		mes.addItem("--Mes--");
		year.addItem("--Año--");
		
		diaS.addItem("--Día--");
		mesS.addItem("--Mes--");
		yearS.addItem("--Año--");
		
		for(int i= 1; i<32; i++) {
			if(i<10){
				dia.addItem("0"+i);
				diaS.addItem("0"+i);
				
				
			}	
			
			else
			{
				dia.addItem(""+i);
				diaS.addItem(""+i);
				
				
			}
				
		}
		
		for(int i= 1; i<13; i++) {
			if(i<10){
				mes.addItem("0"+i);
				mesS.addItem("0"+i);
				
				
				
			}
				
			else
			{
				mes.addItem(""+i);
				mesS.addItem(""+i);
				
				
			}
				
				
		}
		for(int i= 2022; i<2041; i++) {
			year.addItem(""+i);
			yearS.addItem(""+i);	
			
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
if(e.getSource()==this.botonCanc) {
			
			if(vp!=null) {
				vp.dispose();		
			}
			dispose();
			vp= new VentanaPrincipal("Hotel Las Gaviotas");
			
		}
		
		if(e.getSource()==this.botonMod) {
			String fechaLlegada= null, fechaSalida= null, tipoHab=null;
			int idRes = Integer.parseInt(String.valueOf(texto.getText()));
			Double precio=0.0;
			int cont=0;
			
			if(sencilla.isSelected()) 
				tipoHab = "sencilla";
			else 
				tipoHab="doble";

			if(vd.ValidarFecha(dia.getSelectedIndex(), mes.getSelectedIndex(), year.getSelectedIndex())) {
				fechaLlegada=  year.getSelectedItem()+"/"+mes.getSelectedItem()+"/"+dia.getSelectedItem();
				cont++;
			}
			
			else 
				javax.swing.JOptionPane.showMessageDialog(null,"RESERVACION NO EXITOSA. REVISAR FECHA DE LLEGADA", "ERROR", JOptionPane.ERROR_MESSAGE);
			
			if(vd.ValidarFecha(diaS.getSelectedIndex(), mesS.getSelectedIndex(), yearS.getSelectedIndex())) {
				fechaSalida= yearS.getSelectedItem()+"/"+mesS.getSelectedItem()+"/"+diaS.getSelectedItem();
				cont++;
			}
			else 
				javax.swing.JOptionPane.showMessageDialog(null,"RESERVACION NO EXITOSA. REVISAR FECHA DE SALIDA", "ERROR", JOptionPane.ERROR_MESSAGE);
			
			if(vd.ValidarPrecio(textod.getText())) {
				precio= Double.parseDouble(String.valueOf(textod.getText()));
				cont++;
			}
			else 
				javax.swing.JOptionPane.showMessageDialog(null,"RESERVACION NO EXITOSA. REVISAR PRECIO", "ERROR", JOptionPane.ERROR_MESSAGE);
			
			if(cont==3) {
				C_ModificarReservacion m = new C_ModificarReservacion(idRes,fechaLlegada, fechaSalida, tipoHab, precio);
				m.Reservacion();
			
			}
			else {
				javax.swing.JOptionPane.showMessageDialog(null,"RESERVACION NO EXITOSA. REVISAR DATOS", "ERROR", JOptionPane.ERROR_MESSAGE);
				cont=0;
			}
				
		}
		
	}
}
