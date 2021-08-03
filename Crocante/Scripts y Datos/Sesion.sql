use proyecto;

drop table if exists sesion; 

create table sesion (
a varchar(40)
);


select * from sesion;


Drop procedure if exists insertar_sesion;
Drop procedure if exists Borrar_sesion;


DELIMITER $$ 

Create procedure  insertar_sesion(usuario varchar(15))

begin

INSERT INTO sesion values(usuario);

end ;
$$
DELIMITER ;

DELIMITER $$ 

Create procedure Borrar_sesion()

begin

Delete from Sesion;

end ;
$$

DELIMITER ;


DROP FUNCTION IF EXISTS usuario_sesion;
DELIMITER $$
CREATE FUNCTION usuario_sesion() 
RETURNS varchar(50) DETERMINISTIC
BEGIN

	DECLARE ab varchar(50);
	
    SELECT car_nombre INTO ab FROM Persona join Empleado on (per_id = persona_per_id) join Sesion on (a = per_nombre) join Cargo on (car_id = Cargo_car_id);
    
    RETURN ab;
END$$



DELIMITER ;

select usuario_sesion();

GRANT EXECUTE ON procedure proyecto.insertar_sesion TO 'Gerencia'@'localhost';

GRANT EXECUTE ON procedure proyecto.Borrar_sesion TO 'Gerencia'@'localhost';

GRANT EXECUTE ON function proyecto.usuario_sesion TO 'Gerencia'@'localhost';

GRANT EXECUTE ON procedure proyecto.insertar_sesion TO 'Caja'@'localhost';

GRANT EXECUTE ON procedure proyecto.Borrar_sesion TO 'Caja'@'localhost';

GRANT EXECUTE ON function proyecto.usuario_sesion TO 'Caja'@'localhost';

SELECT car_nombre FROM Persona join Empleado on (per_id = persona_per_id) join Sesion on (a = per_nombre) join Cargo on (car_id = Cargo_car_id);

GRANT ALL ON Sesion TO 'Gerencia'@'localhost';