package com.empresa.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.empresa.entity.Deporte;
import com.empresa.entity.Modalidad;
import com.empresa.service.DeporteService;
import com.empresa.service.ModalidadService;

@Controller
public class RegistroModalidadController {

	@Autowired
	private DeporteService  deporteService;
	
	@Autowired
	private ModalidadService  modalidadService;
	
	
	@RequestMapping("/verRegistraModalidad")
	public String verRegistra() {
		return "registraModalidad";
	}
	
	@ResponseBody
	@RequestMapping("/listaDeporte")
	public List<Deporte> listaDeporte(){
		return deporteService.listaTodos();
	}
	
	@ResponseBody
	@RequestMapping("/registraModalidad")
	public Map<String, Object> registraModalidad(Modalidad obj){
		HashMap<String, Object> salida = new HashMap<String, Object>();
		try {
			Modalidad objSalida = modalidadService.insertaModalidad(obj);
			if (objSalida == null) {
				salida.put("MENSAJE", "Registro erróneo");	
			}else {
				salida.put("MENSAJE", "Registro exitoso");	
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("MENSAJE", "Registro erróneo");	
		}	
		return salida;
	}
	
	
			
	
}







