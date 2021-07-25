use Proyecto;
  
drop table if exists Histo_ventas;
  
Create Table Histo_ventas (

    ven_id INT(10) UNSIGNED NOT NULL,
	ven_fecha DATETIME NOT NULL,
	ven_precioTotal INT(6) UNSIGNED NOT NULL,
	ven_formaPago ENUM('Efectivo', 'Tarjeta', 'Online') NOT NULL,
	ven_estadoPago ENUM('Pagado', 'No Pago') NOT NULL,
	ven_modalidad ENUM('Domicilio', 'Presencial') NOT NULL,
    ven_diaSemana VARCHAR(45) NOT NULL,
	Persona_per_id INT(10) UNSIGNED NOT NULL,
	Sede_sede_id INT(10) UNSIGNED NOT NULL,
    ven_fecha_cambio datetime Default null,
    ven_accion varchar(30) not null
  
)
ENGINE = InnoDB;


--                 ------------------ Borrado en Ventas Triggers para borrar en todo lo relacionado ------------------ 
	

# 
DELIMITER $$ 
create trigger del_venta_pedido before Delete on Venta
		
        FOR each row begin
        
        
        Delete from pedido where Venta_ven_id = old.ven_id;
		
        set @accion = "DELETE",
        @ven_id = old.ven_id,
		@ven_fecha = old.ven_fecha,
		@ven_precioTotal = old.ven_precioTotal,
		@ven_formaPago = old.ven_formaPago,
		@ven_estadoPago = old.ven_estadoPago,
		@ven_modalidad = old.ven_modalidad,
		@ven_diaSemana = old.ven_diaSemana,
		@Persona_per_id = old.Persona_per_id,
		@Sede_sede_id = old.Sede_sede_id;
        
        

		Insert into Histo_ventas Values (@ven_id, @ven_fecha, @ven_precioTotal, @ven_formaPago, @ven_estadoPago, @ven_modalidad , @ven_diaSemana, @Persona_per_id, @Sede_sede_id, NOW(), @accion );
    
    
END;
$$ 
DELIMITER ;

DELIMITER $$ 
create trigger del_venta_domicilio before delete on Venta
		
        FOR each row begin
        
        Delete from Domicilio where Venta_ven_id = old.ven_id;
        
END;
$$ 
DELIMITER ;


DELIMITER $$ 
create trigger del_venta_Comentario before delete on Venta
		
        FOR each row begin
        
        Delete from Comentario  where Venta_ven_id = old.ven_id;
        
END;
$$ 
DELIMITER ;



DELIMITER $$ 
create trigger del_venta_Calificacion before delete on Comentario
		
        FOR each row begin
        
        Delete from Calificación where Comentario_com_id = old.com_id;
        
END;
$$ 
DELIMITER ;

 Drop Procedure if exists Eliminar_ventas;
 
DELIMITER $$ 

create Procedure Eliminar_ventas(id int)
begin	
        
        Delete from Venta where ven_id = id;
        
END;
$$ 
DELIMITER ;


select * from Venta;
select * from Pedido;
select * from Domicilio;
select * from Comentario;
select * from Histo_ventas;

Call Eliminar_ventas (1);

select * from Venta;
select * from Pedido;
select * from Domicilio;
select * from Comentario;
select * from Histo_ventas;
 
 -- ------------------------------------- Triggers update Detallecomprainsumo --------------------------------------------

select * from detallecomprainsumo;
select * from compraalproveedor;
select * from insumo;
select * from gasto;

 Drop Procedure if exists Actualizar_Detalle_compra_insumo;
 
DELIMITER $$ 
 
create Procedure Actualizar_Detalle_compra_insumo(actualizacion varchar(15), id int, cantidad int)

	Begin
    
		if LOWER(actualizacion) = "cantidad" Then
		
			Update detallecomprainsumo set dci_cantidad = cantidad where CompraAlProveedor_Gastos_gast_id = id; 
            
		elseif LOWER(actualizacion) = "precio" Then
        
			Update detallecomprainsumo set dci_precioUnitario = cantidad where CompraAlProveedor_Gastos_gast_id = id; 
            
        
			
        End if;
END;
$$ 
DELIMITER ;



DELIMITER $$ 
create trigger upd_Detalle_Gasto before update on detallecomprainsumo
		
        FOR each row begin
        
        set @N_CANTIDAD = new.dci_cantidad,
        @N_Precio = new.dci_precioUnitario;
        
        Update Gasto set gast_costo = (@N_CANTIDAD*@N_Precio) where new.CompraAlProveedor_Gastos_gast_id = gast_id; 
        
END;
$$ 
DELIMITER ;



select * from detallecomprainsumo;

select * from gasto;

Call Actualizar_Detalle_compra_insumo("precio",5,2);

select * from gasto;


select * from detallecomprainsumo;




