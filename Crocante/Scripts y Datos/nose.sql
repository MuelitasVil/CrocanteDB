SELECT pro_nombre, pro_precio, tip_tipo
FROM Producto JOIN Tipo ON (tip_id = Tipo_tip_id)
WHERE tip_tipo IN (Select tip_tipo from Tipo where tip_id = 1 or tip_id = 6 or tip_id = 7 );



Select tip_tipo from Tipo where tip_id = 1 or tip_id = 6 or tip_id = 7 ;

select * from Producto;

select * from Tipo;

-- Dia que mas vende 

select  max(cnt)
	from (select count(tip_tipo) as cnt
	from Producto JOIN Pedido ON (pro_id = Producto_pro_id) 
	JOIN Venta ON (ven_id = Venta_ven_id) 
	JOIN Tipo ON (tip_id= Tipo_tip_id)
	group by ven_diaSemana
     ) x;

-- SELECT ven_diaSemana,tip_tipo,count(tip_tipo)
-- FROM Producto JOIN Pedido ON (pro_id = Producto_pro_id) 
-- 	JOIN Venta ON (ven_id = Venta_ven_id) 
--     JOIN Tipo ON (tip_id= Tipo_tip_id)
-- 	GROUP BY ven_diaSemana having ;

SELECT ven_diaSemana,tip_tipo
FROM Producto JOIN Pedido ON (pro_id = Producto_pro_id) 
	JOIN Venta ON (ven_id = Venta_ven_id) 
    JOIN Tipo ON (tip_id= Tipo_tip_id);
    
    
select ven_diaSemana, max(cnt)
from (select count(tip_tipo) as cnt
      from Producto JOIN Pedido ON (pro_id = Producto_pro_id) 
		JOIN Venta ON (ven_id = Venta_ven_id) 
		JOIN Tipo ON (tip_id= Tipo_tip_id)
      group by ven_diaSemana
     );