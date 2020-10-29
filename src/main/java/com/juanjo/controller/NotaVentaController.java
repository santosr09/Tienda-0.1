package com.juanjo.controller;

import java.util.ArrayList;
import java.util.List;

import com.juanjo.entity.view.NotaVentaView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.juanjo.entity.DetalleVenta;
import com.juanjo.entity.NotaVenta;
import com.juanjo.entity.ProductoAlmacenado;
import com.juanjo.entity.view.ProductoView;
import com.juanjo.service.NotaVentaService;
import com.juanjo.service.ProductoService;

@Controller
@SessionAttributes("notaView")
public class NotaVentaController {

	private static final Logger LOGGER = LoggerFactory.getLogger(NotaVentaController.class);
	public static final double CANTIDAD_DEFAULT = 1.0;

	private ProductoService productoService;
	private NotaVentaService notaVentaService;
	
	private List<ProductoView> productos = new ArrayList<ProductoView>();
	private List<DetalleVenta> listadoVenta = new ArrayList<DetalleVenta>();
	private Double totalAcumulado = new Double(0.0);
	

	@Autowired(required = true)
	@Qualifier(value = "productoService")
	public void setProductoService(ProductoService productoService) {
		this.productoService = productoService;
	}

	@Autowired(required = true)
	@Qualifier(value = "notaVentaService")
	public void setNotaVentaService(NotaVentaService notaService) {
		this.notaVentaService = notaService;
	}

	@GetMapping(value = "/ventas")
	public String crearNota(Model model) {
		NotaVentaView notaView = new NotaVentaView(notaVentaService.crearNota(new NotaVentaView()));
		LOGGER.debug("## /ventas/ ## nota: "+ notaView);
		model.addAttribute("notaView", notaView);
		model.addAttribute("productoView", new ProductoView());
		return "nota-venta-form";
	}
	
	@GetMapping(value = "/ventas/{idNota}")
	public String cargaNota(@PathVariable String idNota, Model model) {
		LOGGER.debug("## ventas/id ide de la nota: "+ idNota);
		model.addAttribute("productoView", new ProductoView());
		return "nota-venta";
	}


	@PostMapping(value = "/ventas/search")
	//public String searchPrecio(@ModelAttribute("nota") NotaVentaView nota,
	public String searchPrecio(@ModelAttribute("notaView") NotaVentaView nota,
			@ModelAttribute("productoView") ProductoView producto, Model model) {
		System.out.println("/ventas/search  - NotaVenta: "+ nota);
		String clave = producto.getClave();
		System.out.println("clave a buscar: "+ clave);
		if (clave != null && !(clave.trim().isEmpty())) {
			ProductoAlmacenado item = this.productoService.getProductoAlmacenPorBarcode(clave);
			System.out.println("Producto Almacenado: "+ item);
			if(item == null) {
				model.addAttribute("productoView", new ProductoView());
				return "redirect:/ventas/" + nota.getFolio();
			}
			LOGGER.debug("detalle en notaVenta: " + nota.getDetalleVenta());
			DetalleVenta detalle = new DetalleVenta();
			//detalle.setNotaVenta(nota);
			detalle.setUnidades(1.0);
			detalle.setProductoVenta(item);
			double subTot = detalle.getUnidades() * item.getPrecioVenta();
			detalle.setTotalLinea(subTot);
			detalle.setRowNum(listadoVenta.size() + 1);
			listadoVenta.add(0, detalle);
			nota.setDetalleVenta(listadoVenta);
			totalAcumulado = totalAcumulado + subTot;
			nota.setMontoTotal(totalAcumulado);

			LOGGER.info("## /ventas/search ## nota.toString: "+ nota);
			model.addAttribute("notaView", nota);
			model.addAttribute("productoView", new ProductoView(item));

		}

		return "redirect:/ventas/" + nota.getFolio();
		//return "redirect:/nota-venta-form";
		//return "nota-venta-form";
	}

	@PostMapping(value = "/ventas/updateQty")
	public @ResponseBody ResponseEntity<List<DetalleVenta>> updateQty(
			@RequestParam(value = "cantidadInput") String cantidadNueva, @RequestParam(value = "rowNum") String row,
			@ModelAttribute("nota") NotaVenta nota, Model model) {
		LOGGER.debug("##/ventas/updateQty ## nota.toString: "+ nota);
		Double cantNva = new Double(cantidadNueva);
		int indice = new Integer(row) - 1;
		DetalleVenta detalle = listadoVenta.get(indice);
		detalle.setUnidades(cantNva);
		double subTot = 99.99;
		detalle.setTotalLinea(subTot);
		System.out.println("double TotalLinea: " + subTot);
		listadoVenta.set(indice, detalle);
		
		totalAcumulado = totalAcumulado + subTot;
		nota.setMontoTotal(totalAcumulado);
		model.addAttribute("nota", nota);
		return new ResponseEntity<List<DetalleVenta>>(listadoVenta, HttpStatus.OK);

	}

	@PostMapping(value = "/ventas/cobrar")
	public String cobrarNota(@ModelAttribute("nota") NotaVenta nota, Model model) {
		NotaVenta notaNueva = new NotaVenta();
		listadoVenta.clear();
		totalAcumulado = 0.0;
		notaNueva.setDetalleVenta(listadoVenta);
		model.addAttribute("nota", notaNueva);
		model.addAttribute("producto", new ProductoAlmacenado());
		model.addAttribute("detalleVenta", notaNueva.getDetalleVenta());
		model.addAttribute("productos", productos);

		return "redirect:/ventas";
	}

	private void salidaProductoAlmacen(ProductoView producto) {
		this.notaVentaService.salidaProducto(producto.getClave(), CANTIDAD_DEFAULT);
	}

}
