package Vista;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.C_Ingreso;
import Controlador.ValidarDatos;

import java.awt.BorderLayout;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class Ingreso extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField passwordField;
	private JLabel lblIngreseContrasea;
	private JLabel lblShow;
	ValidarDatos vd;
	VentanaPrincipal vp;
	JButton btnEntrar;
	JButton btModificar;
	
	public Ingreso() {
		setResizable(false);
		setTitle("Hotel Las Gaviotas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 400);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		vd= new ValidarDatos();
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(236, 190, 208, 25);
		panel.add(passwordField);
		
		
		btnEntrar = new JButton("Entrar");
		btnEntrar.setBounds(200, 221, 86, 25);
		panel.add(btnEntrar);
		btnEntrar.addActionListener(this);
		
		btModificar = new JButton("Cambiar Clave");
		btModificar.setBounds(358, 221, 120, 25);
		panel.add(btModificar);
		btModificar.addActionListener(this);
		
		btnEntrar.setMnemonic('A');
		btnEntrar.setMnemonic('A');
		btnEntrar.setToolTipText("Presione ALT+A para Acceder");
		
		btModificar.setMnemonic('M');
		btModificar.setMnemonic('m');
		btModificar.setToolTipText("Presione ALT+M para Cambiar clave");
		
		
		JLabel lblBgImage = new JLabel();
		Image imagen=(new ImageIcon(Ingreso.class.getResource("/Images/playa.png"))).getImage();
		
		lblIngreseContrasea = new JLabel("Ingrese contraseña");
		lblIngreseContrasea.setFont(new Font("Dialog", Font.BOLD, 18));
		lblIngreseContrasea.setBounds(236, 159, 214, 19);
		panel.add(lblIngreseContrasea);
		
		char[] eyeSymbol_ = Character.toChars(128065);
		String eyeSymbol  = new String(eyeSymbol_);
		lblShow = new JLabel(eyeSymbol); 
		lblShow.setBounds(447, 195, 70, 15);
		panel.add(lblShow);
		lblBgImage.setIcon(new ImageIcon(imagen.getScaledInstance(600, 325, Image.SCALE_SMOOTH)));
		lblBgImage.setBounds(43, 0, 600, 360);
		panel.add(lblBgImage);
		setVisible(true);
		/* Events listeners */
		lblShow.addMouseListener(new MouseAdapter()  
		{  
		    public void mouseClicked(MouseEvent e)  
		    {
		    	if (passwordField.getEchoChar() == '\u2022') {
		    		passwordField.setEchoChar((char)0);
		    		lblShow.setText("\u25C9");
		    	}else {
		    		passwordField.setEchoChar('\u2022');
		    		lblShow.setText(eyeSymbol);
		    	}
		    }  
		}); 

		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int cont=0;
		C_Ingreso i1=null;
		int band=1;
		if(e.getSource()==btnEntrar) {
			char[] arrayClave=passwordField.getPassword();
			String clave=new String(arrayClave);
			if(vd.ValidarClave(clave))
				cont++;
			else
				javax.swing.JOptionPane.showMessageDialog(null,"INGRESE UNA CLAVE DE DESBLOQUEO", "ERROR", JOptionPane.ERROR_MESSAGE);
			if(cont==1)
				i1 = new C_Ingreso(clave);
			if(i1.Ingreso())
				if(vp!=null) {
					vp.dispose();		
				}
				else {
					dispose();
					vp= new VentanaPrincipal("Hotel Las Gaviotas");
				}
			
			else
				javax.swing.JOptionPane.showMessageDialog(null,"CLAVE INCORRECTA. VUELVA A INTENTARLO", "ACCESO DENEGADO", JOptionPane.ERROR_MESSAGE);
		}
		if(e.getSource()==btModificar) {
			System.out.println("Cualquier pendejada");
		}
	}
}
