package Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import Controlador.ValidarDatos;

public class ResultadosCliente extends JFrame implements ActionListener  {
	
	 	private JTable tabla = null;
	    public DefaultTableModel modelo = null;
	    JScrollPane desplazamiento = null;
	    JButton boton1,boton2;
	    ConsultarCliente cc;
	    VentanaPrincipal vp;
	    
	    public ResultadosCliente(String titulo) {
	    	
	        String[] columnas = {"Nombre", "Apellido", "Telefono", "Fecha Llegada", "Fecha Salida", "Num Hab"};
	        tabla = new JTable();
	        modelo = new DefaultTableModel();
	        desplazamiento = new JScrollPane(tabla);     
	        
	        boton1= new JButton("Volver a pantalla de inicio");
	        boton2= new JButton("Nueva Búsqueda");
	        
	        boton1.setMnemonic('I');
			boton1.setMnemonic('i');
			boton1.setToolTipText("Presione ALT+I para regresar al inicio ");
			boton1.addActionListener(this);
	        
	        boton2.setMnemonic('H');
			boton2.setMnemonic('h');
			boton2.setToolTipText("Presione ALT+H para una nueva búsqueda");
			boton2.addActionListener(this);

	        this.setTitle(titulo);
	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        this.setLayout(new BorderLayout());
	        setLocationRelativeTo(null);
	        setVisible(true);
	        setResizable(false);
	        setSize(900,900);
	        setLocationRelativeTo(null);

	        
	        modelo.setColumnIdentifiers(columnas);

	        desplazamiento.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	        desplazamiento.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

	        
	        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	        tabla.setFillsViewportHeight(true);
	        tabla.setModel(modelo);
	        
	        add(boton1,BorderLayout.EAST);
	        add(boton2,BorderLayout.WEST);

	        this.getContentPane().add(desplazamiento, BorderLayout.NORTH);
	        this.pack();
	    }

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			if(e.getSource()==boton1){
    			if(vp!=null) {
    				vp.dispose();		
    			}
    			dispose();
    			
    			vp= new VentanaPrincipal("Hotel Las Gaviotas");		
    		}
			
			if(e.getSource()==boton2) {
				if(cc!=null) {
					cc.dispose();		
				}
				dispose();
				cc = new ConsultarCliente("Consultar un cliente");
				
			}
			
		}
}
