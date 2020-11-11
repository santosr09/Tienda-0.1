package com.juanjo.controller;

import com.juanjo.entity.*;
import com.juanjo.entity.view.ProductoView;
import com.juanjo.service.NotaCompraService;
import com.juanjo.service.ProductoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("notaCompra")
public class NotaCompraController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(NotaCompraController.class);
	
	private ProductoService productoService;
	private NotaCompraService notaCompraService;
	
	@Autowired(required = true)
	@Qualifier(value = "productoService")
	public void setProductoService(ProductoService productoService) {
		this.productoService = productoService;
	}
	
	@Autowired(required = true)
	@Qualifier(value = "notaCompraService")
	public void setNotaCompraService(NotaCompraService notaService) {
		this.notaCompraService = notaService;
	}
	
	private List<ProductoView> productos = new ArrayList<ProductoView>();
	private Double totalAcumulado = 0.0;
	
	@GetMapping(value = "/compras")
	public String cargaNota( Model model) {
		NotaCompra nota = new NotaCompra();
		nota.setMontoTotal(totalAcumulado);
		LOGGER.debug("## /COMPRAS/ ## nota: "+ nota);
		nota.setDetalleCompra(new ArrayList<DetalleCompra>());
		model.addAttribute("notaCompra", nota);
		model.addAttribute("producto", new ProductoAlmacenado());
		model.addAttribute("detalleCompra", nota.getDetalleCompra());
		model.addAttribute("productos", productos);
		notaCompraService.crearNota(nota);
		return "NotaCompra";
	}
	
	@GetMapping(value = "/compras/update")
	public String actualizaNota(@ModelAttribute("notaCompra") NotaCompra nota, Model model) {
		nota.setMontoTotal(totalAcumulado);
		LOGGER.debug("## /compras/ ## nota: "+ nota);
		model.addAttribute("producto", new ProductoAlmacenado());
		model.addAttribute("detalleCompra", nota.getDetalleCompra());
		model.addAttribute("productos", productos);
		notaCompraService.update(nota);
		return "NotaCompra";
	}
	
	@RequestMapping(value = "/NotaCompra", method = RequestMethod.GET)
	public String notaCargada(@ModelAttribute("notaCompra") NotaCompra nota) {
		LOGGER.debug("## /NotaCompra ## nota: "+ nota);
		return "NotaCompra";
	}
	
	@PostMapping(value = "/compras/search")
	public String searchPrecio(@ModelAttribute("notaCompra") NotaCompra nota,
														 @ModelAttribute("producto") ProductoAlmacenado producto, Model model) {
		
		String clave = producto.getProducto().getClave();
		if (clave != null && !(clave.trim().isEmpty())) {
			ProductoAlmacenado item = this.productoService.getProductoAlmacenPorBarcode(clave);
			nota = notaCompraService.agregarProductoaNota(nota, item);
			LOGGER.info("## /compras/search ## nota.toString: "+ nota);
			model.addAttribute("notaCompra", nota);
			
			model.addAttribute("detalleCompra", nota.getDetalleCompra());
			model.addAttribute("productos", productos);
		}
		
		return "redirect:/compras/update";
	}
	
	@PostMapping(value = "/compras/updateQty")
	public @ResponseBody
	ResponseEntity<List<DetalleCompra>> updateQty(
			@RequestParam(value = "cantidadInput") String cantidadNueva,
			@RequestParam(value = "rowNum") String row,
			@RequestParam(value = "precioCompra") String precioCompra,
			@ModelAttribute("notaCompra") NotaCompra nota, Model model) {
		LOGGER.debug("##/compras/updateQty ## nota.toString: "+ nota);
		Double precioUltimo = Double.valueOf(precioCompra);
		Double cantNva = Double.valueOf(cantidadNueva);
		int indice = Integer.valueOf(row) - 1;
		DetalleCompra detalle = nota.getDetalleCompra().get(indice);
		detalle.setUnidades(cantNva);
		detalle.getProductoAlmacenado().setPrecioCompraUltimo(precioUltimo);
		double subTot = precioUltimo * cantNva;
		detalle.setMontoTotal(subTot);
		nota.getDetalleCompra().set(indice, detalle);
		
		totalAcumulado = totalAcumulado + subTot;
		nota.setMontoTotal(totalAcumulado);
		model.addAttribute("notaCompra", nota);
		
		notaCompraService.update(nota);
		
		return new ResponseEntity<List<DetalleCompra>>(nota.getDetalleCompra(), HttpStatus.OK);
		
	}
	
}
