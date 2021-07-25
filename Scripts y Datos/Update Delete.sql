use proyecto;

-- Borrar alguna venta erronea 

Delete from Venta where ven_id = 2; -- Proximamente se utilizaran trigger para eliminar el pedido correspondiente

-- Cambiar el Estado de pago una venta

Update Venta set ven_estadoPago = "Pagado" where ven_id = 3; -- Funciona

Select * from venta;

-- Cambiar el Estado de un domicilio

Update Domicilio set dom_estado = "Entregado" where dom_id = 4; -- Funciona

select * from Domicilio;

-- Cambiar el cargo de un empleado 

Update Empleado set Cargo_car_id = 1 where emp_id = 2; -- Funciona

select * from Empleado;

select * from Cargo;

-- Cambiar el salario de un empleado 

Update Salario set sal_valor  = 0000 where Empleado_emp_id = 1; -- Funciona

select * from Salario;

-- Cambiar el precio de un producto 

Update Producto set pro_precio = 9999 where pro_id = 11; -- Funciona

select * from Producto;

-- Cambiar el Costo de un gasto 

Update gasto set gast_costo = 9999 where gast_id = 1; -- Funciona

select * from gasto;

-- Cambiar el nombre de una Persona 

Update Persona set per_nombre = "venus" where per_id = 1; -- Funciona

select * from Persona;

-- Cambiar el apellido de una Persona 

Update Persona set per_apellido = "Bakero" where per_id = 1; -- Funciona

select * from Persona;

-- Cambiar el apellido de una persona

Update Persona set per_dirección = "Cambio dirreccion" where per_id = 1; -- Funciona 

select * from Persona; 

-- Cambiar el apellido de una persona

Update Persona set per_teléfono = 3302106502 where per_id = 1; -- Funciona

select * from Persona; 

-- Cambiar el correo de una persona

Update Persona set per_correo = "Perso_correo@a" where per_id = 1;

select * from Persona; 

-- Cambiar el nombre de un proveedor

Update Proveedor set prov_nombre = "Gilberto" where prov_id = 1;

select * from Proveedor; 

-- Cambiar el correo de un proveedor

Update Proveedor set prov_correo = "proveedor@a" where prov_id = 1;

select * from Proveedor; 

-- Cambiar el numero de un proveedor

Update Proveedor set prov_número = 32015642 where prov_id = 1;

select * from Proveedor;
