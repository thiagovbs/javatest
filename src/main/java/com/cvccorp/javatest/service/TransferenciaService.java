package com.cvccorp.javatest.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cvccorp.javatest.entity.Transferencia;
import com.cvccorp.javatest.repository.TransferenciaRepository;
import com.cvccorp.javatest.utils.Util;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TransferenciaService {
	
	@Autowired
	TransferenciaRepository transferenciaRepository;
	
	
	public String realizaTransferencia(Transferencia t) {
		log.info("Iniciando Transferência");
	
		try {
			log.info("Calculando taxa da Transferência....");
			BigDecimal taxa = Util.calculaTaxa(t.getDataTransferencia(), t.getValorTransferencia()); 
			t.setTaxa(taxa);
		    log.info("Taxa calculada: "+taxa);
		    transferenciaRepository.save(t);
		} catch (Exception e) {
			log.error("Ocorreu um erro ao calcular a taxa da transferência", e);
			return e.getLocalizedMessage();
		}
		
		return "Trnsferência realizada com sucesso";
	}
	
	public List<Transferencia> exibeExtrato(){
		
		return transferenciaRepository.findAll();
	}

}
