package Modelo;

public class Producto {
	int idproducto, cantidad;
	String descripcion, proveedor;
	double precio;
	public Producto() {
		
	}
	public Producto(int idproducto, int cantidad, String descripcion, String proveedor, double precio) {
		super();
		this.idproducto = idproducto;
		this.cantidad = cantidad;
		this.descripcion = descripcion;
		this.proveedor = proveedor;
		this.precio = precio;
	}
	public int getIdproducto() {
		return idproducto;
	}
	public void setIdproducto(int idproducto) {
		this.idproducto = idproducto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getProveedor() {
		return proveedor;
	}
	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}

}
