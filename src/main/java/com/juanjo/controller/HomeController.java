package com.juanjo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	/*private CategoriaService categoriaService; 
	
	@Autowired(required=true)
	@Qualifier(value="categoriaService")
	public void setCategoriaService(CategoriaService service){
		this.categoriaService = service;
	}*/
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome(Model model){
		return "home";
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String welcomeHome(Model model){
		return "home";
	}

}
