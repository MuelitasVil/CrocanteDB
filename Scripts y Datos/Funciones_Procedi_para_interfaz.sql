use proyecto;

SET GLOBAL log_bin_trust_function_creators = 1;

drop function if exists Mostrar_Cargo;
DELIMITER $$

CREATE function Mostrar_Cargo(nombre varchar(50)) returns char(15) deterministic  
BEGIN

	Declare cargo varchar(50) default "";
	Select car_nombre into cargo from Cargo join Empleado on (Cargo_car_id = car_id) join Persona on (Persona_per_id = per_id) where nombre = per_nombre;
	return cargo;

END;
$$
DELIMITER ;

select Mostrar_Cargo('Venus');


DROP FUNCTION IF EXISTS get_CC_venta;
DELIMITER $$
CREATE FUNCTION get_CC_venta(ventaID INT) 
RETURNS BIGINT(10) DETERMINISTIC
BEGIN
	DECLARE cc BIGINT(10);
    SELECT Persona_per_id INTO cc FROM Venta WHERE ven_id = ventaId;
    RETURN cc;
END$$
DELIMITER ;

DROP TRIGGER IF EXISTS updt_costoVenta;
DELIMITER $$
CREATE TRIGGER updt_costoVenta AFTER INSERT ON Pedido 
FOR EACH ROW
BEGIN
	DECLARE total INT;
    SELECT SUM(pro_precio) INTO total 
    FROM Producto JOIN Pedido ON (pro_id = Producto_pro_id) 
    WHERE Venta_ven_id=NEW.Venta_ven_id;
	UPDATE Venta SET ven_precioTotal = total WHERE ven_id = NEW.Venta_ven_id;
END $$
DELIMITER ;

DROP TRIGGER IF EXISTS dlt_costoVenta;
DELIMITER $$
CREATE TRIGGER dlt_costoVenta AFTER DELETE ON Pedido 
FOR EACH ROW
BEGIN
	DECLARE total INT;
    SELECT SUM(pro_precio) INTO total 
    FROM Producto JOIN Pedido ON (pro_id = Producto_pro_id) 
    WHERE Venta_ven_id=OLD.Venta_ven_id;
	UPDATE Venta SET ven_precioTotal = total WHERE ven_id = OLD.Venta_ven_id;
END $$
DELIMITER ;



drop function if exists Numero_gasto;

DELIMITER $$
CREATE function Numero_gasto() returns int deterministic 
BEGIN

	Declare numero int default 0;
	select count(*) into numero from gasto; 
	return numero;

END $$
DELIMITER ;


Drop Procedure if exists Agregar_Gasto; 
DELIMITER $$
CREATE Procedure Agregar_Gasto(Nombre varchar(50), costo int, tipo varchar(50), sede tinyint)   
BEGIN

	INSERT INTO Gasto VALUES(null, Nombre, costo, now(), tipo, sede);

END $$
DELIMITER ;

