package com.veterinaria.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.veterinaria.entity.Carrito;
import com.veterinaria.entity.JsonFilterfront;
import com.veterinaria.entity.TransaccionCabecera;
import com.veterinaria.service.CarritoService;

@Controller
public class CarritoController {

	
	@Autowired
	private CarritoService service;
	


	@RequestMapping("/insertarObtenerCarrito")
	@ResponseBody
	public List<Carrito> listaProductoPorNombre(Carrito carrito) {
		return service.insertarObtenerCarrito(carrito);
	}
	
	@RequestMapping("/listarCarrito")
	@ResponseBody
	public List<Carrito> listarCarrito(Carrito carrito) {
		return service.listarCarrito(carrito.getCodigo_usuario());
	}
	
	
	
	
	@RequestMapping("/agregarTransaccion")
	@ResponseBody
	public List<Carrito> agregarTransaccion( JsonFilterfront jsonfilter ) throws JSONException {
		System.out.println("json"+jsonfilter.getJson());
		JSONObject jsonformater = new JSONObject(jsonfilter.getJson());
		TransaccionCabecera cabecera=new TransaccionCabecera();
		cabecera.setCodigo_usuario(jsonformater.getInt("codigo_usuario"));
		cabecera.setEstado(jsonformater.getInt("estado"));
		cabecera.setMonto(new BigDecimal(jsonformater.getDouble("estado")));
		cabecera.setTransaccion_codigo(jsonformater.getInt("transaccion_codigo"));
		cabecera.setTransaccion_fecha(new Date());
		
//		 JSONArray arrayDetail = new JSONArray(jsonformater.getString("detalle"));
		
		return service.listarCarrito(2);
	}
	
	
	
	
	
	@RequestMapping("/eliminarProducto")
	public String eliminarProducto(Carrito carrito) {
		System.out.println("Producto Eliminado: carrito "+carrito.getCodigo_carrito() + "    usuario "+carrito.getCodigo_usuario());
		 service.eliminarItem(carrito.getCodigo_carrito(),carrito.getCodigo_usuario());
		return "consolidadoPagos";
	}
	

	@RequestMapping("/registrarTransaccion")
	public String registrarTransaccion(@RequestParam Map<String, String> attributeMap) {
			System.out.println("transaccion");
//		for (TransaccionDetalle obj : cabecera.getDetalle()) {
//			System.out.println("det : " + obj.getTransacciondet_cabe_codigo());
//		}
		
		//System.out.println("Producto Eliminado: carrito "+carrito.getCodigo_carrito() + "    usuario "+carrito.getCodigo_usuario());
		// service.eliminarItem(carrito.getCodigo_carrito(),carrito.getCodigo_usuario());
		return "consolidadoPagos";
	}
	
	
	
}
