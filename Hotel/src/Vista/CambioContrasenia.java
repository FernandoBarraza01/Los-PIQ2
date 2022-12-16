package Vista;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import Controlador.C_CambioContr;
import Controlador.C_Ingreso;
import Controlador.ValidarDatos;
import Utilidades.TextPrompt;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CambioContrasenia extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField PsswrdOld;
	private JLabel OldPssword;
	private JPasswordField NewPsswrd;
	private JLabel PsswrdNew;
	private JPasswordField ConfirmPsswrd;
	private JLabel PsswrdConfirm;
	JButton btnAceptar;
	JButton btnCancelar;
	Ingreso in;
	ValidarDatos vd;
	
	public CambioContrasenia() {
		setTitle("Cambiar contraseña");
		setResizable(false);
		vd= new ValidarDatos();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 350);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		OldPssword = new JLabel("Contraseña Anterior:");
		OldPssword.setBounds(50, 40, 183, 25);
		contentPane.add(OldPssword);
		

		
		PsswrdOld = new JPasswordField();
		PsswrdOld.setBounds(50, 66, 183, 25);
		contentPane.add(PsswrdOld);
		PsswrdOld.setColumns(10);
		
		TextPrompt placeholderPO = new TextPrompt("Contraseña anterior", PsswrdOld);
		placeholderPO.changeAlpha(0.75f);
		placeholderPO.changeStyle(Font.ITALIC);
		
		PsswrdNew = new JLabel("Nueva Contraseña:");
		PsswrdNew.setBounds(50, 95, 183, 25);
		contentPane.add(PsswrdNew);
		
		
		NewPsswrd = new JPasswordField();
		NewPsswrd.setText("");
		NewPsswrd.setBounds(50, 120, 183, 25);
		contentPane.add(NewPsswrd);
		NewPsswrd.setColumns(10);
		TextPrompt placeholderNP = new TextPrompt("Nueva contraseña", NewPsswrd);
		placeholderNP.changeAlpha(0.75f);
		placeholderNP.changeStyle(Font.ITALIC);
		
		PsswrdConfirm = new JLabel("Confirmar Contraseña:");
		PsswrdConfirm.setBounds(50, 150, 183, 25);
		contentPane.add(PsswrdConfirm);
		
		ConfirmPsswrd = new JPasswordField();
		ConfirmPsswrd.setBounds(50, 175, 183, 25);
		contentPane.add(ConfirmPsswrd);
		ConfirmPsswrd.setColumns(10);
		TextPrompt placeholderCP = new TextPrompt("Confirmar contraseña", ConfirmPsswrd);
		placeholderCP.changeAlpha(0.75f);
		placeholderCP.changeStyle(Font.ITALIC);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(30, 250, 90, 25);
		contentPane.add(btnAceptar);
		btnAceptar.addActionListener(this);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(150, 250, 90, 25);
		contentPane.add(btnCancelar);
		btnCancelar.addActionListener(this);
		
		/* Event Listeners */ 
		setVisible(true);
	
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		C_CambioContr i1=null;
		int cont=0;
		if(e.getSource()==btnAceptar) {
			char[] arrayClaveOld=PsswrdOld.getPassword();
			String claveOld=new String(arrayClaveOld);
			char[] arrayClaveNew=NewPsswrd.getPassword();
			String claveNew=new String(arrayClaveNew);
			char[] arrayClaveConf=ConfirmPsswrd.getPassword();
			String claveConf=new String(arrayClaveConf);
			if(vd.ValidarClave(claveOld))
				cont++;
			else
				javax.swing.JOptionPane.showMessageDialog(null,"INGRESE LA CLAVE DE DESBLOQUEO ACTUAL", "ERROR", JOptionPane.ERROR_MESSAGE);
			if(vd.ValidarClave(claveNew))
				cont++;
			else
				javax.swing.JOptionPane.showMessageDialog(null,"INGRESE LA NUEVA CLAVE DE DESBLOQUEO", "ERROR", JOptionPane.ERROR_MESSAGE);
			if(vd.ValidarClave(claveConf))
				cont++;
			else
				javax.swing.JOptionPane.showMessageDialog(null,"CONFIRME LA NUEVA CLAVE DE DESBLOQUEO", "ERROR", JOptionPane.ERROR_MESSAGE);
			if(cont==3) {
				i1 = new C_CambioContr(claveOld,claveNew,claveConf);
				switch(i1.CambioContr()) {
					case 1: 
						javax.swing.JOptionPane.showMessageDialog(null,"LA CLAVE ACTUAL ES INCORRECTA", "ERROR", JOptionPane.ERROR_MESSAGE);
						break;
					case 2:
						javax.swing.JOptionPane.showMessageDialog(null,"LA CLAVE NUEVA NO COINCIDE CON LA CONFIRMACIÓN, VUELVA A INTENTARLO", "ERROR", JOptionPane.ERROR_MESSAGE);
						break;
					default:
						dispose();
						in= new Ingreso();
				}
			}
		}
		if(e.getSource()==btnCancelar) {
			if(in!=null) {
				in.dispose();		
			}
			dispose();
			in= new Ingreso();	
		}
	}
		
		
}

