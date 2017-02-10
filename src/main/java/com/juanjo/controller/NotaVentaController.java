package com.juanjo.controller;

import java.util.ArrayList;
import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.juanjo.entity.DetalleVenta;
import com.juanjo.entity.NotaVenta;
import com.juanjo.entity.ProductoAlmacenado;
import com.juanjo.entity.view.ProductoView;
import com.juanjo.service.NotaVentaService;
import com.juanjo.service.ProductoService;

@Controller
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
	public String cargaNota( Model model) {
		NotaVenta nota = new NotaVenta();
		nota.setMontoTotal(totalAcumulado);
		LOGGER.debug("## /ventas/ ## nota: "+ nota);
		nota.setDetalleVenta(listadoVenta);
		model.addAttribute("nota", nota);
		model.addAttribute("producto", new ProductoAlmacenado());
		model.addAttribute("detalleVenta", nota.getDetalleVenta());
		model.addAttribute("productos", productos);

		return "NotaVenta";
	}

	@RequestMapping(value = "/NotaVenta", method = RequestMethod.GET)
	public String notaCargada(@ModelAttribute("nota") NotaVenta nota) {
		LOGGER.debug("## /Notaventa ## nota: "+ nota);
		return "NotaVenta";
	}

	@PostMapping(value = "/ventas/search")
	public String searchPrecio(@ModelAttribute("nota") NotaVenta nota,
			@ModelAttribute("producto") ProductoAlmacenado producto, Model model) {

		String clave = producto.getProducto().getClave();
		if (clave != null && !(clave.trim().isEmpty())) {
			ProductoAlmacenado item = this.productoService.getProductoAlmacenPorBarcode(clave);
			DetalleVenta detalle = new DetalleVenta();
			detalle.setNotaVenta(nota);
			detalle.setCantidad(1.0);
			detalle.setPrecioVenta(item.getPrecioVenta());
			detalle.setProductoVenta(item);
			double subTot = detalle.getCantidad() * detalle.getPrecioVenta();
			detalle.setTotalLinea(subTot);
			detalle.setRowNum(listadoVenta.size() + 1);
			listadoVenta.add(0, detalle);
			nota.setDetalleVenta(listadoVenta);
			totalAcumulado = totalAcumulado + subTot;
			nota.setMontoTotal(totalAcumulado);

			LOGGER.info("## /ventas/search ## nota.toString: "+ nota);
			model.addAttribute("nota", nota);

			model.addAttribute("detalleVenta", nota.getDetalleVenta());
			model.addAttribute("productos", productos);
		}

		return "redirect:/ventas";
	}

	@PostMapping(value = "/ventas/updateQty")
	public @ResponseBody ResponseEntity<List<DetalleVenta>> updateQty(
			@RequestParam(value = "cantidadInput") String cantidadNueva, @RequestParam(value = "rowNum") String row,
			@ModelAttribute("nota") NotaVenta nota, Model model) {
		LOGGER.debug("##/ventas/updateQty ## nota.toString: "+ nota);
		Double cantNva = new Double(cantidadNueva);
		int indice = new Integer(row) - 1;
		DetalleVenta detalle = listadoVenta.get(indice);
		detalle.setCantidad(cantNva);
		double subTot = detalle.getPrecioVenta() * cantNva;
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
