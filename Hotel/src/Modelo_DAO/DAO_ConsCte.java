package Modelo_DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Vista.ConsultarCliente;

import Vista.ResultadosCliente;
import Vista.VentanaPrincipal;

public class DAO_ConsCte {
	
	String usuario="root";
	String contrasena="user123";
	String url="jdbc:mysql://localhost/Hotel";
	Connection conexion= null;
	Statement stmt;
	PreparedStatement stm ;
	ResultSet rs;
	VentanaPrincipal vp;
	ConsultarCliente cc;
	String cad= null;
	
	
	
	public void ConsultaCte(C3 c) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Conexion Exitosa");
		} catch(ClassNotFoundException e){
			System.out.println("Error en la conexion");
		}
		
		try {
			conexion = DriverManager.getConnection(url, usuario, contrasena);
			stmt = conexion.createStatement();
			cad = c.getNombre();
			stm= conexion.prepareStatement("SELECT nombre, apellido, tel, fecha_llegada, fecha_salida, numHabitacion  FROM huesped INNER JOIN hospedaje USING (idHuesped) WHERE nombre = ? AND apellido = ? ");
			stm.setString(1,c.getNombre());
			stm.setString(2,c.getApellidos());
			rs= stm.executeQuery();
			
			javax.swing.JOptionPane.showMessageDialog(null,"CONSULTA EXITOSA", "CONFIRMACION DE CONSULTA", JOptionPane.INFORMATION_MESSAGE);	
			
			ResultadosCliente rc = new ResultadosCliente("Resultados");
			
			while(rs.next()){
				Object[] datosFila = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)};
				rc.modelo.addRow(datosFila);	               
			}
			 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			javax.swing.JOptionPane.showMessageDialog(null,"CONSULTA NO EXITOSA.", "CONSULTA", JOptionPane.ERROR_MESSAGE);	
		
		}
	}

}
