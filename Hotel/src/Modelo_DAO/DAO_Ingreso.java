package Modelo_DAO;
/*
 * @author Luis Fernando Lopez
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import Vista.Ingreso;
import Vista.VentanaPrincipal;

public class DAO_Ingreso {
	String usuario="root";
	String contrasena="user123";
	String url="jdbc:mysql://localhost/hotel";
	Connection conexion= null;
	Statement stmt;
	PreparedStatement stm ;
	ResultSet rs;
	String clavebd;
	
	public String Ingreso(Ing1 i) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Conexion Exitosa");
		} catch(ClassNotFoundException e){
			System.out.println("Error en la conexion");
		}
		
		try {
			conexion = DriverManager.getConnection(url, usuario, contrasena);
			stmt = conexion.createStatement();
			stm= conexion.prepareStatement("SELECT *  FROM clave");
			rs= stm.executeQuery();
			
			
			if(rs.next()) {
				i.setClave(rs.getString(1));
				return rs.getString(1);
				/*if(i.getClave().equals(rs.getString(1))) {
					VentanaPrincipal vp=new VentanaPrincipal("Hotel Las Gaviotas");
				}
				else {
					javax.swing.JOptionPane.showMessageDialog(null,"CLAVE INCORRECTA. VUELVA A INTENTARLO", "ACCESO DENEGADO", JOptionPane.ERROR_MESSAGE);
					return 0;
				}*/
			}
				
		}
		
		catch (SQLException e) {
			e.printStackTrace();
			javax.swing.JOptionPane.showMessageDialog(null,"INGRESO NO EXITOSO.", "INGRESO FALLIDO", JOptionPane.ERROR_MESSAGE);	
		
		}
		return null;
	}
}
