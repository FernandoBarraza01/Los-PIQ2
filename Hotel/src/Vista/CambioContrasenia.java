package Vista;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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
	private JTextField PsswrdOld;
	private JLabel OldPssword;
	private JTextField NewPsswrd;
	private JLabel PsswrdNew;
	private JTextField ConfirmPsswrd;
	private JLabel PsswrdConfirm;
	JButton btnAceptar;
	JButton btnCancelar;

	
	public CambioContrasenia() {
		setTitle("Cambiar contraseña");
		setResizable(false);
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
		

		
		PsswrdOld = new JTextField();
		PsswrdOld.setBounds(50, 66, 183, 25);
		contentPane.add(PsswrdOld);
		PsswrdOld.setColumns(10);
		
		TextPrompt placeholderPO = new TextPrompt("Contraseña anterior", PsswrdOld);
		placeholderPO.changeAlpha(0.75f);
		placeholderPO.changeStyle(Font.ITALIC);
		
		PsswrdNew = new JLabel("Nueva Contraseña:");
		PsswrdNew.setBounds(50, 95, 183, 25);
		contentPane.add(PsswrdNew);
		
		
		NewPsswrd = new JTextField();
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
		
		ConfirmPsswrd = new JTextField();
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
		if(e.getSource()==btnAceptar) {
			
		}
		if(e.getSource()==btnCancelar) {
			Ingreso in = null;
			
			if(in!=null) {
				in.dispose();		
			}
			else {
				in= new Ingreso();
			}
		}
		}
		
		
	}

}
