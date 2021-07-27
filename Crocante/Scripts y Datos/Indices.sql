-- -----------------------------------------------------
-- Schema proyecto

use proyecto;
-- -------------------------------------------------------------------------------------------------------------
CREATE UNIQUE INDEX  indice_producto ON producto(pro_nombre);
CREATE INDEX indice_pro_precio ON producto(pro_precio);

-- No se incluyó el precio y el nombre de un producto en un indice compuesto ya que hay productos
-- diferentes con un mismo precio. De este modo se realizan dos indices: con la expresión UNIQUE INDEX 
-- para el nombre del producto (pro_nombre), y con la expresión INDEX para el precio del producto (pro_precio)

-- --------------------------------------------------------------------------------------------------------------

-- VENTAS Y GASTOS 

-- Se crean los siguientes indices debido a la importancia de los datos de ventas y gastos del restaurante 

CREATE INDEX indice_persona ON persona(per_nombre, per_teléfono);

CREATE INDEX indice_calificacion ON calificación(cal_fecha);

CREATE INDEX indice_comentario ON comentario(Venta_ven_id);

CREATE INDEX indice_domicilio ON domicilio(dom_tiempoEntrega);

CREATE UNIQUE INDEX indice_domicilio2 ON domicilio(Venta_ven_id);

CREATE INDEX indice_pedido ON pedido(Venta_ven_id);

-- Se puede observar que aunque ven_id sea una llave foránea que proviene de Venta, la mayoría delos índices
-- creados con este campo son no únicos. 
-- Esto debido a que  varios productos pueden estar en una misma venta, es decir, pueden tener repetido el
-- valor en ven_id.


CREATE INDEX indice_proveedor ON proveedor(prov_nombre, prov_número);

CREATE INDEX indice_gasto ON gasto(gast_fecha,gast_costo,gast_tipo);

CREATE INDEX indice_detallecomprainsumo ON detallecomprainsumo(CompraAlProveedor_Gastos_gast_id);


-- ----------------------------------------------------------------------------------------------------------











