# Consultas Algebra Relacional

-- Seleccionar los productos que cuesten menos de 5000
SELECT * FROM Producto WHERE pro_precio < 5000;

-- Mostrar empleados que trabajen menos de 8 horas
SELECT per_nombre, per_apellido, emp_horasSemanales, Sede_sede_id 
FROM Empleado JOIN Persona ON (per_id = Persona_per_id)
WHERE emp_horasSemanales < 8;

-- Seleccionar los pedidos hechos por domicilio
SELECT * FROM Venta WHERE ven_modalidad='Domicilio'; 

-- Calcular cuantos pedidos fueron hechos por domicilio
SELECT COUNT(ven_modalidad) AS CantidadDomicilios 
FROM Venta WHERE ven_modalidad='Domicilio'; 

-- Clientes Frecuentes (para el ejemplo, que tengan más de una compra)
SELECT per_nombre, per_apellido, per_teléfono, count(ven_id) 
FROM Persona JOIN Venta ON (per_id = Persona_per_id)
GROUP BY per_id HAVING count(ven_id) > 1; 

-- Barrios donde se piden mas domicilios
SELECT bar_nombre, count(dom_id) AS NumDomicilios 
FROM Domicilio JOIN Barrio ON (bar_id = Barrio_bar_id) 
GROUP BY bar_id HAVING count(dom_id) > 1 ; 

-- Mostrar una venta con calificacion  y  sus  respectivos comentarios 
SELECT ven_id, pro_nombre, cal_estrellas, com_descripcion 
FROM Comentario JOIN Calificación ON (com_id = Comentario_com_id)
	JOIN Venta ON (ven_id = Venta_ven_id) 
    JOIN Producto ON (pro_id = Calificación.Producto_pro_id);

-- Tiempos de entrega de los domicilios
SELECT per_nombre, dom_dirEntrega, bar_nombre, loc_nombre, dom_tiempoEntrega 
FROM Domicilio JOIN Barrio ON (bar_id = Barrio_bar_id) 
    JOIN Empleado ON (emp_id = Empleado_emp_id)
    JOIN Persona ON (per_id = Empleado.Persona_per_id)
    JOIN Localidad ON (loc_id = Localidad_loc_id);

-- Informacion de proveedores de algun insumo especifico
SELECT prov_id, prov_nombre, ins_id, ins_nombre 
FROM InventarioProveedor JOIN Insumo ON (ins_id = Insumo_ins_id) 
	JOIN Proveedor ON (prov_id = Proveedor_prov_id)
WHERE ins_id = 1; 


-- ---------------------------------------------------------------------------------
# Nuevas Consultas

-- Ventas de la semana (agrupado día) 
SELECT ven_diaSemana, COUNT(ven_id), SUM(ven_precioTotal) FROM Venta 
WHERE ven_fecha BETWEEN '2021-04-12' AND '2021-04-18 23:59:59' 
GROUP BY ven_diaSemana;

-- Promedio tiempo que demoran los domicilios 
SELECT SEC_TO_TIME(ROUND(AVG(TIME_TO_SEC(dom_tiempoEntrega)))) FROM domicilio;
SELECT bar_nombre, SEC_TO_TIME(ROUND(AVG(TIME_TO_SEC(dom_tiempoEntrega)))) 
FROM domicilio JOIN Barrio ON (bar_id = Barrio_bar_id) GROUP BY bar_id; -- agrupados por barrio
SELECT (SEC_TO_TIME(ROUND(AVG(TIME_TO_SEC(dom_tiempoEntrega))))) 
FROM domicilio JOIN venta ON (ven_id = Venta_ven_id) WHERE ven_fecha > '2021-06-00 00:00:00'; -- desde cierta fecha -- posible PA

-- Productos segun un tipo   *
SELECT pro_nombre, pro_precio, tip_tipo
FROM Producto JOIN Tipo ON (tip_id = Tipo_tip_id)
WHERE tip_tipo IN (Select tip_tipo from Tipo where tip_id = 1 or tip_id = 6 or tip_id = 7); -- Modificación para PA

-- Conteo productos de un tipo
SELECT tip_tipo, COUNT(tip_tipo)
FROM Producto JOIN Tipo ON (tip_id = Tipo_tip_id)
GROUP BY tip_id;
 
-- Relación insumo-sede  
SELECT sede_id, ins_nombre AS Insumo, dci_cantidad AS Cantidad, gast_fecha AS FechaCompra 
FROM Insumo JOIN DetalleCompraInsumo ON (ins_id = Insumo_ins_id) 
	JOIN Gasto ON (gast_id = CompraAlProveedor_Gastos_gast_id)
	JOIN CompraAlProveedor ON (gast_id = Gastos_gast_id) 
    JOIN Sede ON (sede_id = Sede_sede_id)
WHERE gast_fecha BETWEEN '2021-04-01' AND '2021-08-30'; -- posible PA 


-- Ventas del dia
SELECT ven_diaSemana, ven_id, ven_precioTotal, ven_modalidad, ven_formaPago FROM Venta WHERE ven_diaSemana = 'Domingo'; 
