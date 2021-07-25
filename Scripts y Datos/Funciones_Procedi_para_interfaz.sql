use proyecto;

SET GLOBAL log_bin_trust_function_creators = 1;

drop  function Mostrar_Cargo;
DELIMITER $$

CREATE function Mostrar_Cargo(nombre varchar(50), apellido varchar(50)) returns char(15)   

BEGIN

Declare cargo varchar(50) default "";

Select car_nombre into cargo from Cargo join Empleado on (Cargo_car_id = car_id) join Persona on (Persona_per_id = per_id) where nombre = per_nombre and per_apellido = apellido;
 
return cargo;

END;
$$
DELIMITER ;

set @Cargo = Mostrar_Cargo('Venus' , 'Baquero');
select @Cargo;


select * from Persona; 
select * from cargo;


SELECT ven_diaSemana, COUNT(ven_id), SUM(ven_precioTotal) FROM Venta 
WHERE ven_fecha BETWEEN '2021-04-12' AND '2021-04-18 23:59:59' 
GROUP BY ven_diaSemana;

drop  function Mostrar_Cargo;
DELIMITER $$

CREATE Procedure Calificacion_personas_Producto(nombre varchar(50), fecha date, tipo int)   

BEGIN

	if nombre = "" then
	set nombre = "%";
    end if;
    
    if fecha = "" then
	set fecha = "0000-00-00";
    end if;
    
    if tipo = 0 then
	
    select pro_nombre, avg(cal_Estrellas) from producto join calificación on (Producto_pro_id = pro_id) where  group by pro_nombre;
    
    else 
    
    select pro_nombre, avg(cal_Estrellas) from producto join calificación on (Producto_pro_id = pro_id) where Tipo_tip_id = tipo group by pro_nombre;
    
    end if;
	
 select pro_nombre, avg(cal_Estrellas) from producto join calificación on (Producto_pro_id = pro_id)  group by pro_nombre;
 

END;
$$
DELIMITER ;

select * from calificación;

Call Calificacion_personas_Producto("", "", 0);