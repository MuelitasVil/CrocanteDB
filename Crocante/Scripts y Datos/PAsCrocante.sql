DELIMITER $$

-- posibilidad combos (precio: 3500) [PA] :)
CREATE PROCEDURE Add_Combo(IN numVenta int)
BEGIN
	UPDATE Venta SET ven_precioTotal = ven_precioTotal + 3500 WHERE ven_id = numVenta;
END $$

CREATE PROCEDURE Del_Combo(IN numVenta int)
BEGIN
	UPDATE Venta SET ven_precioTotal = ven_precioTotal - 3500 WHERE ven_id = numVenta;
END $$

-- costo domicilio [PA] :)
CREATE PROCEDURE costo_domicilio(IN costo INT, IN numVenta INT)
BEGIN
	UPDATE Domicilio SET dom_precio = costo WHERE Venta_ven_id = numVenta;
    UPDATE Venta SET ven_precioTotal = ven_precioTotal + costo WHERE ven_id = numVenta;
END $$

-- Relación insumo-sede :)

CREATE PROCEDURE ReStock(IN desde date, IN hasta date)
BEGIN
	SELECT Sede_sede_id, ins_nombre AS Insumo, dci_cantidad AS Cantidad, gast_fecha AS FechaCompra 
	FROM Insumo JOIN DetalleCompraInsumo ON (ins_id = Insumo_ins_id) 
		JOIN Gasto ON (gast_id = CompraAlProveedor_Gastos_gast_id)
		JOIN CompraAlProveedor ON (gast_id = Gastos_gast_id) 
	WHERE gast_fecha BETWEEN desde AND hasta;
END $$

-- ganancia del día :)
CREATE FUNCTION ganancia_diaria()
RETURNS INT DETERMINISTIC
BEGIN
	DECLARE total int;
    SELECT SUM(ven_precioTotal) INTO TOTAL FROM Venta WHERE DATE(ven_fecha) = curdate() AND ven_estadoPago = 'Pagado';
    RETURN total;
END $$
	
-- pago domicilios :)
CREATE PROCEDURE dom_entrega(IN numVenta int)
BEGIN
	UPDATE Domicilio SET dom_estado = 'Entregado' WHERE Venta_ven_id = numVenta;
END $$

-- pago venta :)
CREATE PROCEDURE venta_paga(IN numVenta int)
BEGIN
	UPDATE Venta SET ven_estadoPago = 'Pagado' WHERE ven_id = numVenta;
END $$

-- gastos por salario  :|
CREATE PROCEDURE gast_salario()-- --
BEGIN
	DECLARE total INT;
	SELECT SUM(sal_valor) INTO total FROM Salario JOIN Empleado ON (emp_id = Empleado_emp_id) WHERE emp_Estado = 1;
	INSERT INTO Gasto (gast_descripción, gast_costo, gast_fecha, gast_tipo, Sede_sede_id) VALUES ('Pago Salarios', total, curdate(), 'Nomina', 1);
END $$

-- costo gasto segun precio unitario y cantidad :| ?
CREATE PROCEDURE dci_gasto (in idgasto int)
BEGIN
	DECLARE cant INT;
    DECLARE precio INT;
    SELECT dci_cantidad INTO cant FROM detallecomprainsumo WHERE CompraAlProveedor_Gastos_gast_id = idgasto;
    SELECT dci_precioUnitario INTO precio FROM detallecomprainsumo WHERE CompraAlProveedor_Gastos_gast_id = idgasto;
	UPDATE Gasto SET gast_costo = (cant*precio) WHERE gast_id = idgasto;
END $$


DELIMITER ;

select * from venta;
select * from domicilio;
select * from gasto;
select * from detallecomprainsumo;
#PRUEBAS
CALL Add_Combo(7); -- :)
CALL Del_Combo(7); -- :)
CALL costo_domicilio(5000, 4); --
CALL ReStock('2021-04-01', '2021-08-30'); -- :)
SELECT ganancia_diaria(); -- :)
CALL dom_entrega(7);-- :)
CALL venta_paga(7); -- :)
CALL gast_salario(); -- :)
CALL dci_gasto (7); --

-- --------------

-- Visualizar el tipo de producto más vendido según el día
Drop procedure if exists Venta_Tipos_dia;
   
DELIMITER $$

create Procedure Venta_Tipos_dia(dia varchar(40))

Begin
		
	Declare tipo1, tipo2, tipo3, tipo4, tipo5, tipo6, tipo7, tipo8 int default 0; 
    Declare tipo1t, tipo2t, tipo3t, tipo4t, tipo5t, tipo6t, tipo7t, tipo8t varchar(40) default 0; 
        
	Drop table if exists Tabla_venta;
    
    Create table if not exists Tabla_venta(
    id int,
    nom varchar(40),
    ventas int,
    dia varchar(40)
    );
    
    Select tip_tipo into tipo1t from Tipo where tip_id = 1;
	Select tip_tipo into tipo2t from Tipo where tip_id = 2;
	Select tip_tipo into tipo3t from Tipo where tip_id = 3;
	Select tip_tipo into tipo4t from Tipo where tip_id = 4;
	Select tip_tipo into tipo5t from Tipo where tip_id = 5;
	Select tip_tipo into tipo6t from Tipo where tip_id = 6;
	Select tip_tipo into tipo7t from Tipo where tip_id = 7;
    Select tip_tipo into tipo8t from Tipo where tip_id = 8;
    
    select count(*) into tipo1 From Producto JOIN Pedido ON (pro_id = Producto_pro_id)  JOIN Venta ON (ven_id = Venta_ven_id)  join Tipo ON (tip_id= Tipo_tip_id) where ven_diaSemana = dia and tip_id = 1;
    select count(*) into tipo2 From Producto JOIN Pedido ON (pro_id = Producto_pro_id)  JOIN Venta ON (ven_id = Venta_ven_id)  join Tipo ON (tip_id= Tipo_tip_id) where ven_diaSemana = dia and tip_id = 2;
    select count(*) into tipo3 From Producto JOIN Pedido ON (pro_id = Producto_pro_id)  JOIN Venta ON (ven_id = Venta_ven_id)  join Tipo ON (tip_id= Tipo_tip_id) where ven_diaSemana = dia and tip_id = 3;
    select count(*) into tipo4 From Producto JOIN Pedido ON (pro_id = Producto_pro_id)  JOIN Venta ON (ven_id = Venta_ven_id)  join Tipo ON (tip_id= Tipo_tip_id) where ven_diaSemana = dia and tip_id = 4;
    select count(*) into tipo5 From Producto JOIN Pedido ON (pro_id = Producto_pro_id)  JOIN Venta ON (ven_id = Venta_ven_id)  join Tipo ON (tip_id= Tipo_tip_id) where ven_diaSemana = dia and tip_id = 5;
    select count(*) into tipo6 From Producto JOIN Pedido ON (pro_id = Producto_pro_id)  JOIN Venta ON (ven_id = Venta_ven_id)  join Tipo ON (tip_id= Tipo_tip_id) where ven_diaSemana = dia and tip_id = 6;
    select count(*) into tipo7 From Producto JOIN Pedido ON (pro_id = Producto_pro_id)  JOIN Venta ON (ven_id = Venta_ven_id)  join Tipo ON (tip_id= Tipo_tip_id) where ven_diaSemana = dia and tip_id = 7;
    select count(*) into tipo8 From Producto JOIN Pedido ON (pro_id = Producto_pro_id)  JOIN Venta ON (ven_id = Venta_ven_id)  join Tipo ON (tip_id= Tipo_tip_id) where ven_diaSemana = dia and tip_id = 8;
    
    insert into Tabla_venta values(1,tipo1t, tipo1,dia);
    insert into Tabla_venta values(2,tipo2t, tipo2,dia);
    insert into Tabla_venta values(3,tipo3t, tipo3,dia);
    insert into Tabla_venta values(4,tipo4t, tipo4,dia);
    insert into Tabla_venta values(5,tipo5t, tipo5,dia);
    insert into Tabla_venta values(6,tipo6t, tipo6,dia);
    insert into Tabla_venta values(7,tipo7t, tipo7,dia);
    insert into Tabla_venta values(8,tipo8t, tipo8,dia);
    
END;
$$ 
DELIMITER ;

drop Procedure if exists Tipo_mas_dia;
DELIMITER $$

create Procedure Tipo_mas_dia(dia varchar(40))

Begin
	Call Venta_Tipos_dia(dia);
	Select id, nom, dia, ventas from Tabla_venta join Producto on (id = Tipo_tip_id) join pedido on (Producto_pro_id = pro_Id ) join Venta on (ven_id = Venta_ven_id) where ven_fecha between date_sub(now(),INTERVAL 6 MONTH) and now() order by ventas desc limit 1 ;

END;
$$ 
DELIMITER ;


Call Tipo_mas_dia('Miercoles');

-- --------------------------

drop Procedure if exists Venta_Producto_dia;
DELIMITER $$
create Procedure Venta_Producto_dia(dia varchar(40))
BEGIN

	Drop table if exists numventas;
	Create table if not exists numventas(
    id int,    
    ventas int
    );
    
	insert into numventas select pro_id, count(pro_id) From Producto JOIN Pedido ON (pro_id = Producto_pro_id)  JOIN Venta ON (ven_id = Venta_ven_id) where ven_diaSemana = dia group by pro_id;
 
	Select distinct pro_nombre, ven_diaSemana, ventas from Producto Join pedido ON (pro_id=pedido.Producto_pro_id) Join Venta ON (ven_id=pedido.Venta_ven_id) Join Numventas ON (Pro_id=Numventas.id) where ven_diaSemana=dia and ven_fecha between date_sub(now(),INTERVAL 6 MONTH) and now() Order by ventas desc;
END;
$$ 
DELIMITER ;


 
Call Venta_Producto_dia('Lunes');
