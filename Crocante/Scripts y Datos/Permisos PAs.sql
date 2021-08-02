use proyecto;

GRANT EXECUTE ON FUNCTION Mostrar_Cargo TO 'Gerencia'@'localhost';
GRANT EXECUTE ON FUNCTION Mostrar_Cargo TO 'Caja'@'localhost';
GRANT EXECUTE ON FUNCTION Mostrar_Cargo TO 'Mesero'@'localhost';
GRANT EXECUTE ON FUNCTION get_delivery_time TO 'Gerencia'@'localhost';

GRANT EXECUTE ON FUNCTION get_CC_venta TO 'Gerencia'@'localhost';
GRANT EXECUTE ON Function proyecto.Numero_gasto TO 'Gerencia'@'localhost';
GRANT EXECUTE ON PROCEDURE Agregar_Gasto TO 'Gerencia'@'localhost';
GRANT EXECUTE ON PROCEDURE gast_salario TO 'Gerencia'@'localhost';
