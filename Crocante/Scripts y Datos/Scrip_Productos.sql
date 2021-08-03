Drop Procedure if exists Insertar_producto;
 
DELIMITER $$ 
create Procedure Insertar_producto(nombre varchar(50), precio int, tipo varchar(45))

Begin

    declare id int default 0;
    declare id_tipo int default 0;
    declare contador int default 0;

	start transaction;
    
    select max(pro_id) into id from producto join Tipo on (Tipo_tip_id = tip_id) where tip_tipo = tipo;
    select tip_id into id_tipo from Tipo where tip_tipo = tipo;
    set id = id + 1;
    
    Insert into Producto values (id, nombre, precio, id_tipo, 1);
	
    select count(pro_id) into contador from producto where pro_nombre = nombre;
    
    if contador > 1 then 
    
		rollback;
    
    else
    
		Commit;
    
    end if ;

END;
$$ 
DELIMITER ;

GRANT EXECUTE ON Procedure proyecto.Insertar_producto TO 'Gerencia'@'localhost';

call Insertar_producto("MegaHamborgesota", 1, 'Hamburguesa');

Drop Procedure if exists Editar_producto;
 
DELIMITER $$ 
create Procedure Editar_producto(nombre varchar(50), precio int, tipo varchar(45), id int)

Begin

    declare id_tipo int default 0;

    
    select tip_id into id_tipo from Tipo where tip_tipo = tipo;
    
	Update Producto set pro_nombre = nombre, pro_precio = precio, Tipo_tip_id = id_tipo  where pro_id = id;


END ;

$$ 
DELIMITER ;

GRANT EXECUTE ON Procedure proyecto.Editar_producto TO 'Gerencia'@'localhost';

call Editar_producto("H",1,'Hamburguesa', 11);

select * from producto;
select * from tipo;