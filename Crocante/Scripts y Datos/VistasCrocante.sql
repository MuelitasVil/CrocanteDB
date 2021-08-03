use proyecto;

Drop view if exists vw_Hamburguesas;
Drop view if exists vw_Perros;
Drop view if exists vw_Carnes;
Drop view if exists vw_Varios;
Drop view if exists vw_Mazorcada;
Drop view if exists vw_Salchipapa;
Drop view if exists vw_Bebidas;
Drop view if exists vw_Adiciones;

Drop view if exists vw_Empleado;
Drop view if exists vw_Emp_id ;
Drop view if exists vw_Carta;
Drop view if exists vw_Comentario;
Drop view if exists vw_Mejores_Platos;
Drop view if exists vw_Tiempo_Barrios;
Drop view if exists vw_Proveedores;

Drop view if exists vw_recent_coments;
Drop view if exists vw_Gastos;
Drop view if exists vw_Barrio_mas_vende;
Drop view if exists  vw_Mejores_Clientes ;
Drop view if exists  vw_Venta_Mes;
Drop view if exists vw_Compras_Insumo;

-- vista de solo productos 
CREATE VIEW vw_Hamburguesas AS SELECT pro_nombre AS Producto, pro_precio AS Precio FROM Producto WHERE Tipo_tip_id = 1;
CREATE VIEW vw_Perros AS SELECT pro_nombre AS Producto, pro_precio AS Precio FROM Producto WHERE Tipo_tip_id = 2;
CREATE VIEW vw_Carnes AS SELECT pro_nombre AS Producto, pro_precio AS Precio FROM Producto WHERE Tipo_tip_id = 3;
CREATE VIEW vw_Varios AS SELECT pro_nombre AS Producto, pro_precio AS Precio FROM Producto WHERE Tipo_tip_id = 4;
CREATE VIEW vw_Mazorcada AS SELECT pro_nombre AS Producto, pro_precio AS Precio FROM Producto WHERE Tipo_tip_id = 5;
CREATE VIEW vw_Salchipapa AS SELECT pro_nombre AS Producto, pro_precio AS Precio FROM Producto WHERE Tipo_tip_id = 6;
CREATE VIEW vw_Bebidas AS SELECT pro_nombre AS Producto, pro_precio AS Precio FROM Producto WHERE Tipo_tip_id = 7;
CREATE VIEW vw_Adiciones AS SELECT pro_nombre AS Producto, pro_precio AS Precio FROM Producto WHERE Tipo_tip_id = 8;


-- empleado/cargo/horas
CREATE VIEW vw_Empleado AS SELECT Sede_sede_id, concat(per_nombre," ", per_apellido) as nombre, car_nombre, car_descripción, emp_horasSemanales, sal_valor
FROM Empleado JOIN Persona ON (per_id = Persona_per_id)
	JOIN Cargo ON (car_id = Cargo_car_id)
    JOIN Salario ON (emp_id = Empleado_emp_id) 
    where emp_estado = 1;

select * from vw_Empleado;


CREATE VIEW vw_Emp_id AS SELECT emp_id, per_nombre, per_apellido, Sede_sede_id     -- utíl para la caja
FROM Empleado JOIN Persona ON (per_id = Persona_per_id);

select * from vw_Emp_id;
 
-- proveedor - insumo
CREATE VIEW vw_Proveedores AS SELECT prov_correo, prov_nombre, ins_nombre 
FROM Proveedor JOIN inventarioproveedor ON (prov_id = Proveedor_prov_id)
	JOIN Insumo ON (ins_id = Insumo_ins_id);
select * from vw_Proveedores;
-- -------------------------------------------------------

-- Clientes 

-- Carta (Tambien sirve para empleado y gerente) 

CREATE VIEW vw_Carta AS SELECT pro_nombre AS Producto, pro_precio AS Precio FROM producto;
select * from vw_Carta;

-- Mejores Platos (Tambien sirve para empleado y gerente) 

CREATE VIEW vw_Mejores_Platos AS SELECT pro_nombre, ROUND(AVG(cal_estrellas),2)
FROM producto JOIN calificación ON (Producto_pro_id = pro_id) GROUP BY pro_nombre
ORDER BY AVG(cal_estrellas) DESC; 

select * from vw_Mejores_Platos;

-- Reseñas (Tambien sirve para gerente) 
CREATE VIEW vw_Comentario AS SELECT com_descripcion, ven_fecha 
FROM Comentario JOIN Venta ON (ven_id = Venta_ven_id); 
SELECT * FROM vw_Comentario;

CREATE VIEW vw_recent_coments AS SELECT date(ven_fecha), com_descripcion 
FROM Comentario JOIN Venta ON (ven_id = Venta_ven_id)
where ven_fecha between date_sub(now(),INTERVAL 1 WEEK) and now();
SELECT * FROM vw_recent_coments;

-- Tiempo de entrega domicilios por barrios en los últimos 6 meses  (Tambien sirve para empleado y gerente) 

Create View vw_Tiempo_Barrios as select bar_nombre AS Barrio, SEC_TO_TIME(ROUND(AVG(TIME_TO_SEC(dom_tiempoEntrega)))) AS 'Tiempo Promedio'
from domicilio join Barrio on (Barrio_bar_id = bar_id)
	JOIN venta ON (ven_id = Venta_ven_id)
    WHERE ven_fecha BETWEEN date_sub(now(),INTERVAL 6 MONTH) and now()
    GROUP BY bar_id;

SELECT * FROM vw_Tiempo_Barrios;
 
 -- Gerente 
 
 -- gastos 
 
 CREATE VIEW vw_Gastos AS SELECT * FROM gasto;
 select * from vw_Gastos;
 
 -- Barrios que más venden (domicilio)
Create View vw_Barrio_mas_vende as SELECT bar_id, bar_nombre as 'Nombre', count(dom_id) as 'Número de domicilios' 
FROM domicilio join barrio on (Barrio_bar_id = bar_id) group by bar_id order by count(dom_id) desc ;

select * from vw_Barrio_mas_vende;

 -- Mejores clientes :)
 
Create View vw_Mejores_Clientes as SELECT per_nombre as 'Nombre', per_apellido as 'Apellido', per_teléfono as 'Teléfono', count(ven_id) as'Total Ventas' 
FROM Persona join venta on (ven_id=venta.ven_id) where per_id=Persona_per_id and per_id not like 0 group by per_id HAVING count(ven_id) > 1 ;

-- Tabla total ventas último mes :)
 
Create View vw_Venta_Mes as Select sum(ven_precioTotal), count(ven_id) 
from venta where ven_fecha between date_sub(now(), INTERVAL 1 MONTH) AND now() 
ORDER BY sum(ven_precioTotal), sum(ven_precioTotal) DESC; 

select * from vw_Venta_Mes;

-- Compras de Insumo -- gerencia
CREATE VIEW vw_Compras_Insumo AS SELECT gast_fecha, gast_descripción, prov_nombre, dci_precioUnitario, dci_cantidad, gast_costo
FROM CompraAlProveedor JOIN Gasto ON (gast_id = Gastos_gast_id)
	JOIN Proveedor ON (prov_id = Proveedor_prov_id)
    JOIN detallecomprainsumo ON (CompraAlProveedor_Gastos_gast_id = gast_id);
    
select * from vw_Compras_Insumo;