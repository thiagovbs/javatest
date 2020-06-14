package com.cvccorp.javatest.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

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
	
	
	public String realizaTransferencia(Transferencia t) throws Exception {
		log.info("Iniciando Transferência");
	
		log.info("Calculando taxa da Transferência....");
		BigDecimal taxa = Util.calculaTaxa(t.getDataTransferencia(), t.getValorTransferencia()); 
		t.setTaxa(taxa);
		log.info("Taxa calculada: "+taxa);
		transferenciaRepository.save(t);
		
		return "Transferência realizada com sucesso";
	}
	
	public List<Transferencia> exibeExtrato() throws Exception{
		
		if (!transferenciaRepository.findAll().isEmpty()) {
			return transferenciaRepository.findAll();
		}else
			throw new Exception("Não há agendamentos a serem listados");
	}
	
	public void delete(Long id) {
		Optional<Transferencia> t = transferenciaRepository.findById(id);
		transferenciaRepository.delete(t.get());
	}
	
	public Transferencia findOne(Long id) {
		Optional<Transferencia> t = transferenciaRepository.findById(id);
		return t.get();
	}
	
	
}
