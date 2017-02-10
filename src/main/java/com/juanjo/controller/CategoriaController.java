package com.juanjo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.juanjo.entity.Categoria;
import com.juanjo.service.CategoriaService;

@Controller
public class CategoriaController {
	
	private CategoriaService categoriaService; 
	
	@Autowired(required=true)
	@Qualifier(value="categoriaService")
	public void setCategoriaService(CategoriaService service){
		this.categoriaService = service;
	}
	
	/*@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcomeHome(Model model){
		return "home";
	}*/
	
	@RequestMapping(value = "/categorias", method = RequestMethod.GET)
	public String listadoCategorias(Model model){
		model.addAttribute("categoria", new Categoria());
		model.addAttribute("listCategoria", this.categoriaService.listCategoria());
		return "categoria";
	}
	
	//For add and update categories both
    @RequestMapping(value= "/categoria/add", method = RequestMethod.POST)
	public String addCategoria(@ModelAttribute("categoria") Categoria c){
    	if(c.getId() == 0){
            //new category, add it
            this.categoriaService.addCategoria(c);
        }else{
            //existing category, call update
            this.categoriaService.updateCategoria(c);
        }
        return "redirect:/categorias";
	}
    
    @RequestMapping("/remove/{id}")
    public String removeCategoria(@PathVariable("id") long id){
    	this.categoriaService.removeCategoria(id);
    	return "redirect:/categorias";
    }
    
    @RequestMapping("/edit/{id}")
    public String editCategoria(@PathVariable("id") long id, Model model){
        model.addAttribute("categoria", this.categoriaService.getCategoria(id));
        model.addAttribute("listCategoria", this.categoriaService.listCategoria());
        return "categoria";
    }

}
