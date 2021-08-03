Use proyecto ;

select * from insumo;
select * from inventarioproveedor;
SELECT * from detallecomprainsumo;
select * from gasto;
select * from compraalproveedor;

describe compraalproveedor;


 
 -- Procedimiento para insertar valores en detalle compra insumo con el id.

drop procedure if exists Insertar_comprainsumo_id;
DELIMITER $$ 
create Procedure Insertar_comprainsumo_id(id_insumo int,proveedor int, cantidad int, costo int)
	Begin
    
    declare id int default 0;
    declare total int default 0;
    declare descrp varchar(50);
	
    select ins_nombre into descrp from insumo where ins_id = id_insumo;
    
    set total = cantidad * costo;
    
	iNSERT INTO gasto values (Null, descrp, total, now(), "Insumos", 1);
    
    select count(*) into id from gasto;
    
    iNSERT INTO compraalproveedor values (id, proveedor);
    
    insert into detallecomprainsumo values (id_insumo, id, proveedor, cantidad, costo);
            
END ; 
$$ 
DELIMITER ;

GRANT EXECUTE ON Procedure proyecto.Insertar_comprainsumo_id TO 'Gerencia'@'localhost';

 -- Procedimiento para insertar valores en detalle compra insumo con el nombre del insumo.

drop procedure if exists Insertar_comprainsumo_nombre;

DELIMITER $$ 
create Procedure Insertar_comprainsumo_nombre(nom_insumo varchar(40),proveedor int, cantidad int, costo int)
	Begin
    
    declare id int default 0;
    declare total int default 0;
    declare id_insumo int default 0;
	
    select ins_id into id_insumo from insumo where ins_nombre = nom_insumo;
    
    set total = cantidad * costo;
    
	iNSERT INTO gasto values (Null, nom_insumo, total, now(), "Insumos", 1);
    
    select count(*) into id from gasto;
    
    iNSERT INTO compraalproveedor values (id, proveedor);
    
    insert into detallecomprainsumo values (id_insumo, id, proveedor, cantidad, costo);
            
END ; 
$$ 
DELIMITER ;

GRANT EXECUTE ON Procedure proyecto.Insertar_comprainsumo_nombre TO 'Gerencia'@'localhost';

Call Insertar_comprainsumo_nombre("tomate", 1, 3, 3);


-- Procedimiento para insertar insumo al proveedor con id 

drop procedure if exists Insertar_insumo_proveedor;

DELIMITER $$ 
create Procedure Insertar_insumo_proveedor (id_ins int, id_proveedor int)
	
Begin

insert into inventarioproveedor values (id_ins, id_proveedor);
	
            
END; 

$$ 
DELIMITER ;

GRANT EXECUTE ON Procedure proyecto.Insertar_insumo_proveedor TO 'Gerencia'@'localhost';




-- ------------------------------- Procedimiento para insertar insumo al proveedor con id --------------------------------------------

drop procedure if exists Insertar_insumo_proveedor_nombre;

DELIMITER $$ 

create Procedure Insertar_insumo_proveedor_nombre (nom_ins varchar(50), id_proveedor int)
	
Begin

declare id_insumo int default 0;
select ins_id into id_insumo from insumo where ins_nombre = nom_ins;
insert into inventarioproveedor values (id_insumo, id_proveedor);
	
            
END; 

$$ 
DELIMITER ;

GRANT EXECUTE ON Procedure proyecto.Insertar_insumo_proveedor_nombre TO 'Gerencia'@'localhost';

Call Insertar_insumo_proveedor_nombre("Carne",6);


-- ----------------------- Procedimiento para editar insumo ---------------------------------

Drop Procedure if exists  editar_Insumo;
 
DELIMITER $$

CREATE Procedure editar_Insumo(id int, Nombre varchar(50), tipo varchar(50))   

BEGIN

Update insumo set ins_nombre = Nombre,  ins_existencia = tipo where ins_id = id;

END;

$$

DELIMITER ;

GRANT EXECUTE ON Procedure proyecto. editar_Insumo TO 'Gerencia'@'localhost';

select * from insumo;

Call editar_Insumo(1, "Super tomates alv", "5 cocas");

-- ----------------------- Procedimiento para insertar proveedor ---------------------------------

drop procedure if exists Insertar_proveedor;


DELIMITER $$ 

create Procedure Insertar_proveedor (nombre varchar(50), numero int, correo varchar(45))
	
Begin

insert into Proveedor values (null, nombre, numero, correo, 1);
            
END; 

$$ 
DELIMITER ;

GRANT EXECUTE ON Procedure proyecto.Insertar_proveedor TO 'Gerencia'@'localhost';

Call Insertar_proveedor("alguien", 3100, "GatitaEstelar@gmail.com");
select * from proveedor;


-- ----------------------- Actualizar compra al proveedor ---------------------------------

Drop Procedure if exists Actualizar_Detalle_compra_insumo;
 
DELIMITER $$ 
 
create Procedure Actualizar_Detalle_compra_insumo(precio int, id int, cantidad int)

Begin
    
		
Update detallecomprainsumo set dci_cantidad = cantidad, dci_precioUnitario = precio where CompraAlProveedor_Gastos_gast_id = id; 
		
        
END;
$$ 
DELIMITER ;

GRANT EXECUTE ON Procedure proyecto.Actualizar_Detalle_compra_insumo TO 'Gerencia'@'localhost';

DELIMITER $$ 
create trigger upd_Detalle_Gasto before update on detallecomprainsumo
		
        FOR each row begin
        
        set @N_CANTIDAD = new.dci_cantidad,
        @N_Precio = new.dci_precioUnitario;
        
        Update Gasto set gast_costo = (@N_CANTIDAD*@N_Precio) where new.CompraAlProveedor_Gastos_gast_id = gast_id; 
        
END;
$$ 
DELIMITER ;

Call Actualizar_Detalle_compra_insumo(1, 4, 1);

-- ----------------------- Eliminar compra al proveedor ---------------------------------

Drop Procedure if exists Actualizar_Detalle_compra_insumo;
 
DELIMITER $$ 
create Procedure Eliminar_compra_insumo(id int)

Begin
    
	delete from detallecomprainsumo where CompraAlProveedor_Gastos_gast_id = id;
        
END;
$$ 
DELIMITER ;

GRANT EXECUTE ON Procedure proyecto.Eliminar_compra_insumo TO 'Gerencia'@'localhost';

Drop trigger if exists Delete_Detalle_Gasto;

DELIMITER $$ 
create trigger Delete_Detalle_Gasto after delete on compraalproveedor
		
        FOR each row begin
        
        Delete from Gasto where old.Gastos_gast_id = gast_id; 
        
END;
$$ 
DELIMITER ;

drop trigger if exists Delete_Gasto;

DELIMITER $$ 
create trigger Delete_Gasto after delete on detallecomprainsumo
		
        FOR each row begin
        
        Delete from compraalproveedor where old.CompraAlProveedor_Gastos_gast_id = Gastos_gast_id;
        
END;
$$ 
DELIMITER ;

Call Eliminar_compra_insumo(4);

show triggers from proyecto;

select * from detallecomprainsumo; 
select * from gasto;
select * from proveedor;
select * from compraalproveedor;
select * from producto;

select pro_id, pro_nombre, pro_precio, tip_tipo from producto join Tipo on (Tipo_tip_id = tip_id);

select * from tipo;

