CREATE TABLE marca (
	id BIGINT NOT NULL PRIMARY KEY,
	descripcion   VARCHAR(100) NOT NULL,
	status  INTEGER
);

CREATE TABLE producto (
	id BIGINT NOT NULL PRIMARY KEY,
	clave   VARCHAR(50) NOT NULL,
	clave_alterna   VARCHAR(50),
	id_categoria BIGINT REFERENCES categoria(id),
	id_marca BIGINT REFERENCES marca(id),
	descripcion VARCHAR(100) NOT NULL,
	status INTEGER
);

CREATE TABLE producto_almacen (
	id BIGINT NOT NULL PRIMARY KEY,
	id_producto BIGINT REFERENCES producto(id),
	existencia_maxima DECIMAL(10,2),
	existencia_minima DECIMAL(10,2),
	existencia_virtual DECIMAL(10,2),
	existencia DECIMAL(10,2),
	precio_compra_ultimo DECIMAL(10,2),
	precio_compra_promedio DECIMAL(10,2),
	precio_venta_minimo DECIMAL(10,2),
	precio_venta_calculado DECIMAL(10,2),
	precio_venta DECIMAL(10,2),
	presentacion VARCHAR(50) NOT NULL
);

CREATE TABLE nota_venta (
	id SERIAL NOT NULL PRIMARY KEY,
	fecha_hora VARCHAR(25) NOT NULL,
	cliente VARCHAR(25),
	vendedor VARCHAR(25),
	total_articulos DECIMAL(5,2),
	monto_total DECIMAL(5,2),
	iva DECIMAL(5,2)
);

CREATE TABLE proveedor (
	id BIGINT NOT NULL PRIMARY KEY,
	nombre   VARCHAR(50) NOT NULL,
	descripcion VARCHAR(100),
	direccion   VARCHAR(150),
	telefono1 VARCHAR(10),
	telefono2 VARCHAR(10),
	email VARCHAR(100),
	status INTEGER
);

CREATE TABLE nota_compra (
	id SERIAL NOT NULL PRIMARY KEY,
	id_proveedor BIGINT REFERENCES proveedor(id),
	fecha_hora VARCHAR(25) NOT NULL,
	total_articulos DECIMAL(5,2),
	monto_total DECIMAL(5,2),
	iva DECIMAL(5,2)
);

CREATE TABLE detalle_compra (
	id SERIAL NOT NULL PRIMARY KEY,
	id_nota_compra BIGINT REFERENCES nota_compra(id),
	id_producto BIGINT REFERENCES producto(id),
	id_presentacion_compra BIGINT REFERENCES cat_presentacion(id),
	unidades DECIMAL(5,2),
	monto_total DECIMAL(5,2),
	iva DECIMAL(5,2)
);

CREATE TABLE cat_presentacion (
	id BIGINT NOT NULL PRIMARY KEY,
	nombre   VARCHAR(10) NOT NULL,
	unidades_contenidas DECIMAL(2,1),
	factor_conversion DECIMAL(2,1),
	status  INTEGER
);

CREATE TABLE detalle_venta (
	id SERIAL NOT NULL PRIMARY KEY,
	id_nota_venta BIGINT REFERENCES nota_compra(id),
	id_producto BIGINT REFERENCES producto(id),
	unidades DECIMAL(5,2),
	monto_total DECIMAL(5,2)
);


INSERT INTO producto_almacen (id, id_producto, existencia_maxima, existencia_minima, 
	existencia_virtual, existencia, precio_compra_ultimo, precio_compra_promedio, precio_venta_minimo, 
	precio_venta_calculado, precio_venta, presentacion)
	VALUES(2, 2, 50, 8,
		20, 20, 10, 10.5, 9,
		12.6, 12.5, 'PIEZA');

INSERT INTO producto_almacen (id, id_producto, existencia_maxima, existencia_minima, 
	existencia_virtual, existencia, precio_compra_ultimo, precio_compra_promedio, precio_venta_minimo, 
	precio_venta_calculado, precio_venta, presentacion)
	VALUES(3, 3, 50, 8,
		14, 14, 11, 11.5, 10,
		13.6, 13.7, 'PIEZA');

INSERT INTO producto (id, clave, clave_alterna,  id_marca, descripcion, status) 
VALUES(1, '97339000054', '97339000054', 1, 'DOWNY LIBRE ENJUAGE TANGO 850 ML', 0);

INSERT INTO producto (id, clave, clave_alterna, id_marca, descripcion, status) 
VALUES(2, '7501001155841', '7501001155841', 0, 'DOWNY LIBRE ENJUAGUE 800 ML FLORAL', 0);

INSERT INTO producto (id, clave, clave_alterna, id_marca, descripcion, status) 
VALUES(2, '7501025413002', '7501025413002', 0, 'ENSUEÑO MAX PRIMAVERAL 850 ML', 0);

INSERT INTO producto (id, clave, clave_alterna, id_marca, descripcion, status) 
VALUES(4, '7501025413002', '7501025413002', 0, 'SUAVITEL PRIMAVERA 850 ML', 0);

INSERT INTO producto (id, clave, clave_alterna, id_marca, descripcion, status) 
VALUES(5, '7501052475004', '7501052475004', 0, 'VINAGRE BLANCO CLEMENTE 500 ML', 0);

INSERT INTO producto (id, clave, clave_alterna, id_marca, descripcion, status) 
VALUES(6, '7501060500019', '7501060500019', 0, 'ACEITE PATRONA  1 LT', 0);

INSERT INTO categoria (id, descripcion, status) VALUES(0, 'SIN DEFINIR', 0);
INSERT INTO marca (id, descripcion, status) VALUES(0, 'SIN DEFINIR', 0);

INSERT INTO marca (id, descripcion, status) VALUES(1, 'GAMESA', 0);
INSERT INTO marca (id, descripcion, status) VALUES(2, 'SAN MARCOS', 0);
INSERT INTO marca (id, descripcion, status) VALUES(3, 'ALPURA', 0);
INSERT INTO marca (id, descripcion, status) VALUES(4, 'P&G', 0);
INSERT INTO marca (id, descripcion, status) VALUES(5, 'COCA-COLA', 0);
INSERT INTO marca (id, descripcion, status) VALUES(6, 'LALA', 0);
INSERT INTO marca (id, descripcion, status) VALUES(7, 'FUD', 0);
INSERT INTO marca (id, descripcion, status) VALUES(8, 'PALMOLIVE', 0);



ALTER TABLE public.nota_venta ADD COLUMN id_detalle bigint;

ALTER TABLE public.producto_almacen ADD COLUMN id_presentacion_venta bigint;

ALTER TABLE public.producto_almacen ADD COLUMN id_presentacion_compra bigint;



ALTER TABLE public.categoria
  ADD CONSTRAINT categoria_pkey PRIMARY KEY(id);

ALTER TABLE public.producto ADD CONSTRAINT producto_id_categoria_fkey FOREIGN KEY (id_categoria)
      REFERENCES public.categoria (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION;

ALTER TABLE public.producto_almacen ADD CONSTRAINT producto_id_presentacion_venta_fkey FOREIGN KEY (id_presentacion_venta)
      REFERENCES public.cat_presentacion (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION;

ALTER TABLE public.producto_almacen ADD CONSTRAINT producto_id_presentacion_compra_fkey FOREIGN KEY (id_presentacion_compra)
      REFERENCES public.cat_presentacion (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION;


INSERT INTO presentacion (id, nombre, unidades_contenidas, factor_conversion, status) 
VALUES(1, 'PIEZA', 1.0, 1.0, 0);

INSERT INTO presentacion (id, nombre, unidades_contenidas, factor_conversion, status) 
VALUES(2, 'METRO', 1.0, 1.0, 0);

INSERT INTO presentacion (id, nombre, unidades_contenidas, factor_conversion, status) 
VALUES(3, 'KILO', 1.0, 1.0, 0);

PASSWORD POSTGRES - > l**a1234



id bigint NOT NULL,
  clave character varying(50) NOT NULL,
  clave_alterna character varying(50),
  id_marca bigint,
  descripcion character varying(100) NOT NULL,
  status integer,
  id_categoria bigint,
  CONSTRAINT producto_pkey PRIMARY KEY (id),

 7501001155841

 