package com.cvccorp.javatest;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cvccorp.javatest.entity.Transferencia;
import com.cvccorp.javatest.repository.TransferenciaRepository;
import com.cvccorp.javatest.service.TransferenciaService;
import com.cvccorp.javatest.utils.Util;

@RunWith(SpringRunner.class)
public class TransferenciaServiceTest {
	
	@TestConfiguration
    static class TransferenciaServiceTestContextConfiguration {
  
        @Bean
        public TransferenciaService transferenciaService() {
            return new TransferenciaService();
        }
    }
 
    @MockBean
    private TransferenciaRepository transferenciaRepository;

   
    
     
    @Test
    public void whenTramsferenciaTipoA_thenTaxaA() throws Exception {
    	Transferencia tA = new Transferencia();
    	tA.setContaDestino("30005");
    	tA.setContaOrigem("10001");
    	tA.setValorTransferencia(new BigDecimal("100.00"));
    	tA.setDataTransferencia(LocalDate.now());
    	BigDecimal taxa = Util.calculaTaxa(tA.getDataTransferencia(), tA.getValorTransferencia());
    	tA.setTaxa(taxa);

        assertThat(taxa).isEqualTo(new BigDecimal("6.00"));
     }
    
    @Test
    public void whenTramsferenciaTipoB_thenTaxaB() throws Exception {
    	Transferencia tB = new Transferencia();
    	tB.setContaDestino("30005");
    	tB.setContaOrigem("10001");
    	tB.setValorTransferencia(new BigDecimal("100.00"));
    	tB.setDataTransferencia(LocalDate.now().plusDays(1));
    	BigDecimal taxa = Util.calculaTaxa(tB.getDataTransferencia(), tB.getValorTransferencia());
    	tB.setTaxa(taxa);

        assertThat(taxa).isEqualTo(new BigDecimal("12"));
     }
    
    @Test
    public void whenTramsferenciaTipoC_thenTaxaC2() throws Exception {
    	Transferencia t = new Transferencia();
    	t.setContaDestino("30005");
    	t.setContaOrigem("10001");
    	t.setValorTransferencia(new BigDecimal("100.00"));
    	t.setDataTransferencia(LocalDate.now().plusDays(11));
    	BigDecimal taxa = Util.calculaTaxa(t.getDataTransferencia(), t.getValorTransferencia());
    	t.setTaxa(taxa);

        assertThat(taxa).isEqualTo(new BigDecimal("8.00"));
     }
    
    @Test
    public void whenTramsferenciaTipoC_thenTaxaC3() throws Exception {
    	Transferencia t = new Transferencia();
    	t.setContaDestino("30005");
    	t.setContaOrigem("10001");
    	t.setValorTransferencia(new BigDecimal("100.00"));
    	t.setDataTransferencia(LocalDate.now().plusDays(20));
    	BigDecimal taxa = Util.calculaTaxa(t.getDataTransferencia(), t.getValorTransferencia());
    	t.setTaxa(taxa);

        assertThat(taxa).isEqualTo(new BigDecimal("8.00"));
     }
    

    @Test
    public void whenTramsferenciaTipoC_thenTaxaC4() throws Exception {
    	Transferencia t = new Transferencia();
    	t.setContaDestino("30005");
    	t.setContaOrigem("10001");
    	t.setValorTransferencia(new BigDecimal("100.00"));
    	t.setDataTransferencia(LocalDate.now().plusDays(33));
    	BigDecimal taxa = Util.calculaTaxa(t.getDataTransferencia(), t.getValorTransferencia());
    	t.setTaxa(taxa);

        assertThat(taxa).isEqualTo(new BigDecimal("4.00"));
     }
    
    @Test
    public void whenTramsferenciaTipoC_thenTaxaC5() throws Exception {
    	Transferencia t = new Transferencia();
    	t.setContaDestino("30005");
    	t.setContaOrigem("10001");
    	t.setValorTransferencia(new BigDecimal("100001.00"));
    	t.setDataTransferencia(LocalDate.now().plusDays(41));
    	BigDecimal taxa = Util.calculaTaxa(t.getDataTransferencia(), t.getValorTransferencia());
    	t.setTaxa(taxa);

        assertThat(taxa).isEqualTo(new BigDecimal("2000.02"));
     }
    
    @Test(expected = Exception.class)
    public void whenTramsferenciaTipoC_thenTaxaC6() throws Exception {
    	Transferencia t = new Transferencia();
    	t.setContaDestino("30005");
    	t.setContaOrigem("10001");
    	t.setValorTransferencia(new BigDecimal("100"));
    	t.setDataTransferencia(LocalDate.now().plusDays(41));
    	BigDecimal taxa = Util.calculaTaxa(t.getDataTransferencia(), t.getValorTransferencia());
    	t.setTaxa(taxa);

     }
        
}
