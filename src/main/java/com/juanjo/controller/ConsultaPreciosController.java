package com.juanjo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.juanjo.entity.Producto;
import com.juanjo.entity.ProductoAlmacenado;
import com.juanjo.entity.view.ProductoView;
import com.juanjo.service.CategoriaService;
import com.juanjo.service.ProductoService;

@Controller
public class ConsultaPreciosController {
	
	private static final Logger log = LoggerFactory.getLogger(ConsultaPreciosController.class);
	
	private ProductoService productoService;
	@Autowired(required = true)
	@Qualifier(value = "productoService")
	public void setProductoService(ProductoService productoService) {
		this.productoService = productoService;
	}
	
	@Autowired(required = true)
	@Qualifier(value = "categoriaService")
	public void setCategoriaService(CategoriaService categoriaService){
	}
	
	@GetMapping(value = "/precios")
	public String listadoProductos(Model model){
		model.addAttribute("producto", new Producto());
		model.addAttribute("listadoProductos", this.productoService.listProducto());
		return "ConsultaPrecios";
	}
	
	public @ResponseBody Producto getProductoInJson(Producto item){
		return item;
	}
	
	@PostMapping(value = "/precios/search")
    public @ResponseBody ResponseEntity<ProductoView> searchPrecio(@ModelAttribute("producto") Producto p, Model model, RedirectAttributes redir){
		String clave = p.getClave();
		if(clave!=null && clave.trim().length()>0){
			ProductoView item = this.productoService.getProductoViewPorBarcode(clave);
			System.out.println("item encontrado por BarCode "+ item);
			//return item;
			return new ResponseEntity<ProductoView>(item, HttpStatus.OK);
		}
		
        return null;
    }
	
	@RequestMapping(value = "/ConsultaPrecios", method = RequestMethod.GET)
	public String precioEncontrado(@ModelAttribute("producto") Producto p){
		return "ConsultaPrecios";
	}
	
	@RequestMapping(value = "/precioNoEncontrado", method = RequestMethod.GET)
	public String precioNoEncontrado(@ModelAttribute("producto") Producto p){
		return "precioNoEncontrado";
	}
 
}
