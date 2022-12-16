package Modelo_DAO;
//repos
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class DAO_CambioContr {
	String usuario="root";
	String contrasena="user123";
	String url="jdbc:mysql://localhost/hotel";
	Connection conexion= null;
	Statement stmt;
	PreparedStatement stm ;
	ResultSet rs;
	String clavebd;
	int r_act;
	
	public String ObtenerContr(Ing2 i) {
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
				i.setClaveOld(rs.getString(1));
				return rs.getString(1);
			}
				
		}
		
		catch (SQLException e) {
			e.printStackTrace();
			javax.swing.JOptionPane.showMessageDialog(null,"RECUPERACION DE CONTRASEÑA FALLIDA", "RECUPERACION FALLIDA", JOptionPane.ERROR_MESSAGE);	
		
		}
		return null;
	}
	
	public void CambioContr(Ing2 i) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Conexion Exitosa");
		} catch(ClassNotFoundException e){
			System.out.println("Error en la conexion");
		}
		
		try {
			conexion = DriverManager.getConnection(url, usuario, contrasena);
			stmt = conexion.createStatement();
			
			stm= conexion.prepareStatement("UPDATE clave SET CLAVE='"+i.getClaveNew()+"' WHERE CLAVE = ?");
			stm.setString(1,i.getClaveOld());
			r_act=stm.executeUpdate();
			
			if(r_act>0)
				javax.swing.JOptionPane.showMessageDialog(null,"CLAVE ACTUALIZADA EXITOSAMENTE", "CONFIRMACION DE MODIFICACION DE CLAVE", JOptionPane.INFORMATION_MESSAGE);	
			else
				javax.swing.JOptionPane.showMessageDialog(null,"CLAVE NO ACTUALIZADA. INTENTELO MAS TARDE", "ERROR", JOptionPane.INFORMATION_MESSAGE);
			
		} catch (SQLException e) {
			e.printStackTrace();
			javax.swing.JOptionPane.showMessageDialog(null,"CLAVE NO ACTUALIZADA. INTENTELO MAS TARDE", "ERROR", JOptionPane.INFORMATION_MESSAGE);
		}
	}
		
}
