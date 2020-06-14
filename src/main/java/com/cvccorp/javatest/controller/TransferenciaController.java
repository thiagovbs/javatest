package com.cvccorp.javatest.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cvccorp.javatest.entity.Transferencia;
import com.cvccorp.javatest.service.TransferenciaService;

@RestController
@RequestMapping("/")
public class TransferenciaController {

	 @Autowired
	 TransferenciaService transefrenciaService;
	 
	 
	 @RequestMapping(value="/transferir", method=RequestMethod.POST)
		public @ResponseBody String executaTransferencia(@RequestBody Transferencia transferencia) {
			try {
				return transefrenciaService.realizaTransferencia(transferencia);
			}
			catch(Exception ex) { 
				return ex.getLocalizedMessage();
			}
	 }
	 
	 @RequestMapping(value="/extratos", method=RequestMethod.GET)
		public @ResponseBody List<Transferencia> getExtratos() {
			try {
				return transefrenciaService.exibeExtrato();
			}
			catch(Exception ex) { 
				return new ArrayList<Transferencia>();
			}
	 }
	 
	 
	
}
