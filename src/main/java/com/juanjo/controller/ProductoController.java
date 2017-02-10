package com.juanjo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.juanjo.entity.Producto;
import com.juanjo.service.CategoriaService;
import com.juanjo.service.ProductoService;

@Controller
public class ProductoController {
	
	private ProductoService productoService;
	private CategoriaService categoriaService;

	@Autowired(required = true)
	@Qualifier(value = "productoService")
	public void setProductoService(ProductoService productoService) {
		this.productoService = productoService;
	}
	
	@Autowired(required = true)
	@Qualifier(value = "categoriaService")
	public void setCategoriaService(CategoriaService categoriaService){
		this.categoriaService = categoriaService;
	}
	
	@RequestMapping(value = "/productos", method = RequestMethod.GET)
	public String listadoProductos(Model model){
		model.addAttribute("producto", new Producto());
		model.addAttribute("listProducto", this.productoService.listProducto());
		model.addAttribute("listCategorias", this.categoriaService.listCategoria());
		return "producto";
		
	}
	
	//For add and update productos both
    @RequestMapping(value= "/producto/add", method = RequestMethod.POST)
	public String addCategoria(@ModelAttribute("producto") Producto p){
    	if(p.getId() == 0){
            //new producto, add it
            this.productoService.addProducto(p);
        }else{
            //existing producto, call update
            this.productoService.updateProducto(p);
        }
        return "redirect:/productos";
	}
    
    @RequestMapping("/removeProducto/{id}")
    public String removeCategoria(@PathVariable("id") long id){
    	this.productoService.removeProducto(id);
    	return "redirect:/productos";
    }
    
    @RequestMapping("/editProducto/{id}")
    public String editCategoria(@PathVariable("id") long id, Model model){
        model.addAttribute("producto", this.productoService.getProducto(id));
        model.addAttribute("listCategorias", this.categoriaService.listCategoria());
        return "producto";
    }

}
