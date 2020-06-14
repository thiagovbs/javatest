package com.cvccorp.javatest.utils;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;

public class Util {


	private static BigDecimal TAXA_A = new BigDecimal("3");
	private static BigDecimal PORCENTAGEM_A = new BigDecimal("3");
	private static BigDecimal TAXA_B = new BigDecimal("12");
	private static BigDecimal PORCENTAGEM_OITO = new BigDecimal("8");
	private static BigDecimal PORCENTAGEM_SEIS = new BigDecimal("6");
	private static BigDecimal PORCENTAGEM_QUATRO = new BigDecimal("4");
	private static BigDecimal PORCENTAGEM_DOIS = new BigDecimal("2");
	private static BigDecimal LIMITE_MINIMO = new BigDecimal("100000");
	
	
	public static BigDecimal retornaPorcentagem(BigDecimal valor, BigDecimal porcentagem ) {
		return valor.multiply(porcentagem).divide(new BigDecimal("100"));
	}
	
	
	public static BigDecimal calculaTaxa(LocalDate dataTransferencia, BigDecimal valor) throws Exception {
		BigDecimal taxa = BigDecimal.ZERO;
		Period intervalo = Period.between(LocalDate.now(), dataTransferencia);
		Integer dias = intervalo.getDays();
		Integer meses = intervalo.getMonths();
		
		//agendamento mesmo dia
		if (meses == 0 && dias ==0) { 
			 return TAXA_A.add(retornaPorcentagem(valor, PORCENTAGEM_A));
		
		//agendamento entre 1 e 10 dias 
		}else if (meses == 0 && (intervalo.getDays() > 0 && intervalo.getDays() <= 10) ) {
			return TAXA_B.multiply(BigDecimal.valueOf(intervalo.getDays()));
		
		//agendamento acima de 10 dias até 20 dias	
		}else if( meses == 0 && (dias > 10 && dias <= 20) ) { 
			taxa = retornaPorcentagem(valor, PORCENTAGEM_OITO);
		
		//agendamento acima de 20 dias até 30 dias
		}else if((meses == 1 && dias == 0) || (meses == 0 && dias > 20)) { 
			taxa = retornaPorcentagem(valor, PORCENTAGEM_SEIS);
		
		//agendamento acima de 30 dias até 40 dias
		}else if(meses == 1 && (dias >= 1 && dias <= 10)) { 
			taxa = retornaPorcentagem(valor, PORCENTAGEM_QUATRO);
		
		//agendamento acima de 40 dias e valor > 100 mil
		}else if(meses > 1 || (meses == 1 && dias >= 10) && (valor.compareTo(LIMITE_MINIMO) > 0)) { 
			taxa = retornaPorcentagem(valor, PORCENTAGEM_DOIS);
		
		//Não existe taxa aplicável
		}else {
			throw new Exception("Taxa não aplicável.");
		}

		return taxa;
	}
	
}
