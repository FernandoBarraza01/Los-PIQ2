package Vista;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controlador.C_ConsultarCliente;
import Controlador.C_Reservacion;
import Controlador.ValidarDatos;



public class ConsultarCliente extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	VentanaPrincipal vp;
	JButton botonBus ,botonCanc;
	JTextField nombres, apelli;
	JLabel nombre, apell, etiq;
	ValidarDatos vd = new ValidarDatos();
	ResultadosCliente rc;

	public ConsultarCliente (String titulo)throws HeadlessException{
        setTitle(titulo);
        setSize(800,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(this);
        setResizable(false);
           
        JPanel panel = new JPanel();
        this.getContentPane().add(panel);
        panel.setLayout(null);
        panel.setBackground(Color.LIGHT_GRAY);
        
        etiq =  new JLabel("Ingrese los datos a consultar:");
        etiq.setBounds(300, 80, 300, 30);
        panel.add(etiq);
        
        nombre = new JLabel("Nombre:");
        nombre.setBounds(150, 150, 100, 30);
        panel.add(nombre);
        
        nombres = new JTextField();
        nombres.setBounds(250,150, 400, 30);
        panel.add(nombres);
        
        apell = new JLabel("Apellidos:");
        apell.setBounds(150, 250, 100, 30);
        panel.add(apell);
        
        apelli = new JTextField();
        apelli.setBounds(250,250, 400, 30);
        panel.add(apelli);
        
        botonBus = new JButton("Buscar");
        botonBus.setBounds(200, 350, 100, 30);
        botonBus.setMnemonic('B');
		botonBus.setMnemonic('b');
		botonBus.setToolTipText("Presione ALT+B para Buscar");
        panel.add(botonBus);
        botonBus.addActionListener(this);
        
        botonCanc=new JButton("Cancelar");
        botonCanc.setBounds(350, 350, 100, 30);
        botonCanc.setMnemonic('C');
		botonCanc.setMnemonic('c');
		botonCanc.setToolTipText("Presione ALT+C para Cancelar");
        panel.add(botonCanc);
        botonCanc.addActionListener(this);
        
        setResizable(false);
		setVisible(true);
           
	}
        @Override
        public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
        	if(e.getSource()==botonCanc){
    			if(vp!=null) {
    				vp.dispose();		
    			}
    			dispose();
    			
    			vp= new VentanaPrincipal("Hotel Las Gaviotas");		
    		}
        	
        	if(e.getSource()==botonBus) {
        		String nombre ="", apellido="";
        		nombre=nombres.getText();
        		apellido = apelli.getText();
        		C_ConsultarCliente c = new C_ConsultarCliente(nombre, apellido);
				if(c.ConsultaCte()==false) {
					javax.swing.JOptionPane.showMessageDialog(null,"NOMBRE Y APELLIDOS REQUERIDOS", "CONSULTA NO EXITOSA", JOptionPane.INFORMATION_MESSAGE);
				}
				else
					dispose();
				
        		/*if(vd.ValidarNombre(nombres.getText())) {
    				nombre=nombres.getText();
    				cont++;
        		}
    			else {
    				do
    					nombre=javax.swing.JOptionPane.showInputDialog(null,"CONSULTA NO EXITOSA. Vuelve a escribir el  NOMBRE", "ERROR", JOptionPane.ERROR_MESSAGE);
    				while(!vd.ValidarNombre(nombre));
    				cont++;
    			}
    			if(vd.ValidarApellidos(apelli.getText())) {
    				apellido = apelli.getText();
    				cont++;
    			}
    			else {
    				do
    					apellido=javax.swing.JOptionPane.showInputDialog(null,"CONSULTA NO EXITOSA. Vuelve a escribir el APELLIDO", "ERROR", JOptionPane.ERROR_MESSAGE);
    				while(!vd.ValidarApellidos(apellido));
    				cont++;
    			}
        		if(cont==2) {
        			C_ConsultarCliente c = new C_ConsultarCliente(nombre, apellido);
    				c.ConsultaCte();
    				dispose();
        		}
        		else {
        			javax.swing.JOptionPane.showMessageDialog(null,"CONSULTA NO EXITOSA", "REVISAR DATOS", JOptionPane.INFORMATION_MESSAGE);
        			cont=0;
        		}
        		*/
        	}
	
		
        }
}
