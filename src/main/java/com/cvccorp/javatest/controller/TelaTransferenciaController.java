package com.cvccorp.javatest.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cvccorp.javatest.entity.Transferencia;
import com.cvccorp.javatest.service.TransferenciaService;

@Controller
@RequestMapping("/")
public class TelaTransferenciaController {
	
	@Autowired
    TransferenciaService transferenciaService;	
	
	
	
	@GetMapping("/")
	public ModelAndView getTela() {
		
		ModelAndView mv = new ModelAndView("/home");
		try {
			mv.addObject("transferencias", transferenciaService.exibeExtrato());
		} catch (Exception e) {
			
		}
		return mv;
	}
    
	@GetMapping("/add")
	public ModelAndView add(Transferencia transferencia) {
		
		ModelAndView mv = new ModelAndView("/transferenciaAdd");
		mv.addObject("transferencia", transferencia);
		
		return mv;
	}
	
	
	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		
		transferenciaService.delete(id);
		
		return getTela();
	}
	
	@PostMapping("/save")
	public ModelAndView save(Transferencia transferencia, BindingResult result) {
		
		if(result.hasErrors()) {
			return add(transferencia);
		}
		try {
			transferenciaService.realizaTransferencia(transferencia);
			return getTela();
		} catch (Exception e) {
			ObjectError error = new FieldError("transferencia","","Erro: "+e.getLocalizedMessage());
			result.addError(error);
			return add(transferencia);
		}
		
	}
    
  
	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		
		return add(transferenciaService.findOne(id));
	}
	

}
