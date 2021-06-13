package com.veterinaria.service;

import java.util.List;

import com.veterinaria.entity.Carrito;
import com.veterinaria.entity.Producto;

public interface CarritoService {
	public abstract List<Carrito> insertarObtenerCarrito(Carrito carrito);
	public abstract List<Carrito> listarCarrito(int codigousuario);
	public void eliminarItem(int codigocarrito, int codigousuario);
	
}
