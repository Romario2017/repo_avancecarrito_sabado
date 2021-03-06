package com.veterinaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.veterinaria.entity.Proveedor;
import com.veterinaria.service.ProveedorService;

@Controller
public class ProveedorController {
	
	@Autowired
	private ProveedorService service;
	
	@RequestMapping("/listaProveedor")
	@ResponseBody
	public List<Proveedor> listaProveedor() {
		return service.listaProveedor();
	}
}
