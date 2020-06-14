package com.cvccorp.javatest.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "transferencia")
public class Transferencia implements Serializable{
	
	private static final long serialVersionUID = -701103476446452832L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String contaOrigem;
	private String contaDestino;
	private BigDecimal valorTransferencia;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataTransferencia;
	private BigDecimal taxa;
	
}
