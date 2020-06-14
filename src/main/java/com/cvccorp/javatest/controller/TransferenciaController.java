package com.cvccorp.javatest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cvccorp.javatest.dto.Erro;
import com.cvccorp.javatest.dto.RetornoDTO;
import com.cvccorp.javatest.entity.Transferencia;
import com.cvccorp.javatest.service.TransferenciaService;

@RestController
@RequestMapping("api")
public class TransferenciaController {

	 @Autowired
	 TransferenciaService transefrenciaService;
	 
	 
	 @RequestMapping(value="/transferir", method=RequestMethod.POST)
		public @ResponseBody RetornoDTO<String,Erro> executaTransferencia(@RequestBody Transferencia transferencia) {
			try {
				return new RetornoDTO<String, Erro>(transefrenciaService.realizaTransferencia(transferencia),null);
			}
			catch(Exception ex) { 
				return new RetornoDTO<String, Erro>(null,new Erro(ex.getLocalizedMessage()));
			}
	 }
	 
	 @RequestMapping(value="/extratos", method=RequestMethod.GET)
		public @ResponseBody RetornoDTO<List<Transferencia>,Erro> getExtratos() {
				
		 	try {
				return new RetornoDTO<List<Transferencia>, Erro>(transefrenciaService.exibeExtrato(),null);
			}
			catch(Exception ex) { 
				return new RetornoDTO<List<Transferencia>, Erro>(null,new Erro(ex.getLocalizedMessage())); 
			}
	 }
	 
	 
	
}
