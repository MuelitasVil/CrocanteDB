use proyecto;

GRANT EXECUTE ON FUNCTION Mostrar_Cargo TO 'Gerencia'@'localhost';
GRANT EXECUTE ON FUNCTION Mostrar_Cargo TO 'Caja'@'localhost';
GRANT EXECUTE ON FUNCTION Mostrar_Cargo TO 'Mesero'@'localhost';


GRANT EXECUTE ON FUNCTION get_CC_venta TO 'Gerencia'@'localhost';