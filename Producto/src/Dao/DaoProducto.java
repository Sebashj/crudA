package Dao;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Conexion.Conexion;
import Modelo.Producto;

public class DaoProducto {
	Conexion cx =null;
	
	public DaoProducto() {
		cx=new Conexion();
	}
	
	public boolean insertarProducto(Producto user) {
		PreparedStatement ps=null;
		try {
			ps=cx.conectar().prepareStatement("INSERT INTO Producto VALUES(null,?,?,?,?)");
			ps.setString(1, user.getDescripcion());
			ps.setDouble(2, user.getPrecio());
			ps.setInt(3, user.getCantidad());
			ps.setString(4, user.getProveedor());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			
			e.printStackTrace();
			return false;
		}
		
	}
	public ArrayList<Producto> fetchProductos(){
		ArrayList<Producto> lista=new ArrayList<Producto>();
		PreparedStatement ps=null;
		ResultSet rs =null;
		try {
			ps=cx.conectar().prepareStatement("SELECT * FROM Producto");
			rs=ps.executeQuery();
			while(rs.next()) {
				Producto u=new Producto();
				u.setIdproducto(rs.getInt("Idproducto"));
				u.setDescripcion(rs.getString("Descripcion"));
				u.setPrecio(rs.getDouble("Precio"));
				u.setCantidad(rs.getInt("Cantidad"));
				u.setProveedor(rs.getString("Proveedor"));
				lista.add(u);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return lista;
		
	}
	public boolean eliminarProducto(int idproducto) {
		PreparedStatement ps=null;
		try {
			ps=cx.conectar().prepareStatement("DELETE FROM Producto WHERE idproducto=?");
			ps.setInt(1, idproducto);
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			
			e.printStackTrace();
			return false;
		}
		
	}
	
	public boolean editarProducto(Producto user) {
		PreparedStatement ps=null;
		try {
			ps=cx.conectar().prepareStatement("UPDATE Producto SET Descripcion=?, Precio=?, Cantidad=?, Proveedor=?  WHERE idproducto=?");
			ps.setString(1, user.getDescripcion());
			ps.setDouble(2, user.getPrecio());
			ps.setInt(3, user.getCantidad());
			ps.setString(4, user.getProveedor());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			
			e.printStackTrace();
			return false;
		}
		
	}

}

