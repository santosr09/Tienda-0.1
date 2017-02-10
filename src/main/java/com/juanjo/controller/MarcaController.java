package com.juanjo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.juanjo.entity.Marca;
import com.juanjo.service.MarcaService;

@Controller
public class MarcaController {
	
	private MarcaService marcaService; 
	
	@Autowired(required=true)
	@Qualifier(value="marcaService")
	public void setMarcaService(MarcaService service){
		this.marcaService = service;
	}
	
	@RequestMapping(value = "/marcas", method = RequestMethod.GET)
	public String listadoMarcas(Model model){
		model.addAttribute("marca", new Marca());
		model.addAttribute("listMarcas", this.marcaService.listMarca());
		return "marca";
	}
	
	//For add and update categories both
    @RequestMapping(value= "/marca/add", method = RequestMethod.POST)
	public String addCategoria(@ModelAttribute("marca") Marca c){
    	if(c.getId() == 0){
            //new category, add it
            this.marcaService.addMarca(c);
        }else{
            //existing category, call update
            this.marcaService.updateMarca(c);
        }
        return "redirect:/marcas";
	}
    
   /* @RequestMapping("/remove/{id}")
    public String removeMarca(@PathVariable("id") long id){
    	this.marcaService.removeMarca(id);
    	return "redirect:/marcas";
    }*/
    
    /*@RequestMapping("/edit/{id}")
    public String editMarca(@PathVariable("id") long id, Model model){
        model.addAttribute("marca", this.marcaService.getMarca(id));
        model.addAttribute("listMarca", this.marcaService.listMarca());
        return "marca";
    }*/

}
