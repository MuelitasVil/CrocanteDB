# Perfiles
CREATE ROLE if not exists 'Mesero'@'localhost';
CREATE ROLE if not exists 'Caja'@'localhost';
CREATE ROLE if not exists 'Gerencia'@'localhost';


#Usuarios
CREATE USER if not exists 'Venus'@'localhost' IDENTIFIED BY 'gerente';
CREATE USER if not exists 'Manuel'@'localhost' IDENTIFIED BY 'mesero';
CREATE USER if not exists 'Santiago'@'localhost' IDENTIFIED BY 'caja';


#Permisos Perfiles
-- Gerencia
GRANT ALL ON Sede TO 'Gerencia'@'localhost';
GRANT ALL ON Persona TO 'Gerencia'@'localhost';
GRANT ALL ON Empleado TO 'Gerencia'@'localhost';
GRANT SELECT, UPDATE ON Cargo TO 'Gerencia'@'localhost';
GRANT INSERT, SELECT, UPDATE ON Insumo TO 'Gerencia'@'localhost';
GRANT ALL ON Gasto TO 'Gerencia'@'localhost';
GRANT ALL ON Proveedor TO 'Gerencia'@'localhost';
GRANT ALL ON Tipo TO 'Gerencia'@'localhost';
GRANT ALL ON Producto TO 'Gerencia'@'localhost';
GRANT ALL ON Venta TO 'Gerencia'@'localhost';
GRANT SELECT, INSERT ON Comentario TO 'Gerencia'@'localhost';
GRANT SELECT, INSERT ON Calificación TO 'Gerencia'@'localhost';
GRANT ALL ON Domicilio TO 'Gerencia'@'localhost';
GRANT INSERT, SELECT, UPDATE ON Salario TO 'Gerencia'@'localhost';
GRANT ALL ON PEDIDO TO 'Gerencia'@'localhost';

GRANT ALL ON vw_Carta TO 'Gerencia'@'localhost';
GRANT ALL ON vw_Hamburguesas TO 'Gerencia'@'localhost';
GRANT ALL ON vw_Perros TO 'Gerencia'@'localhost';
GRANT ALL ON vw_Carnes TO 'Gerencia'@'localhost';
GRANT ALL ON vw_Varios TO 'Gerencia'@'localhost';
GRANT ALL ON vw_Mazorcada TO 'Gerencia'@'localhost';
GRANT ALL ON vw_Salchipapa TO 'Gerencia'@'localhost';
GRANT ALL ON vw_Bebidas TO 'Gerencia'@'localhost';
GRANT ALL ON vw_Adiciones TO 'Gerencia'@'localhost';
GRANT INSERT, SELECT, UPDATE ON vw_Empleado TO 'Gerencia'@'localhost';
GRANT SELECT, UPDATE ON vw_Emp_id TO 'Gerencia'@'localhost';
GRANT SELECT, UPDATE ON vw_Proveedores TO 'Gerencia'@'localhost';
GRANT SELECT ON vw_Mejores_Platos TO 'Gerencia'@'localhost';
GRANT SELECT ON vw_Comentario TO 'Gerencia'@'localhost';
GRANT SELECT ON vw_recent_coments TO 'Gerencia'@'localhost';
GRANT SELECT ON vw_Tiempo_Barrios TO 'Gerencia'@'localhost';
GRANT ALL ON vw_Gastos TO 'Gerencia'@'localhost';
GRANT SELECT ON vw_Barrio_mas_vende TO 'Gerencia'@'localhost';
GRANT SELECT ON vw_Mejores_Clientes TO 'Gerencia'@'localhost';
GRANT SELECT ON vw_Venta_Mes TO 'Gerencia'@'localhost';
GRANT SELECT ON vw_Compras_Insumo TO 'Gerencia'@'localhost';


-- Caja
GRANT SELECT ON Sede TO 'Caja'@'localhost';
GRANT SELECT, INSERT, UPDATE ON Persona TO 'Caja'@'localhost';
GRANT SELECT ON Tipo TO 'Caja'@'localhost';
GRANT SELECT ON Producto TO 'Caja'@'localhost';
GRANT INSERT, SELECT, UPDATE ON Venta TO 'Caja'@'localhost';
GRANT INSERT, SELECT ON Comentario TO 'Caja'@'localhost'; -- SELECT?
GRANT INSERT, SELECT ON Calificación TO 'Caja'@'localhost';  -- SELECT?
GRANT INSERT, SELECT, UPDATE ON Domicilio TO 'Caja'@'localhost';

GRANT SELECT ON vw_Carta TO 'Caja'@'localhost';
GRANT SELECT ON vw_Hamburguesas TO 'Caja'@'localhost';
GRANT SELECT ON vw_Perros TO 'Caja'@'localhost';
GRANT SELECT ON vw_Carnes TO 'Caja'@'localhost';
GRANT SELECT ON vw_Varios TO 'Caja'@'localhost';
GRANT SELECT ON vw_Mazorcada TO 'Caja'@'localhost';
GRANT SELECT ON vw_Salchipapa TO 'Caja'@'localhost';
GRANT SELECT ON vw_Bebidas TO 'Caja'@'localhost';
GRANT SELECT ON vw_Adiciones TO 'Caja'@'localhost';
GRANT SELECT ON vw_Emp_id TO 'Caja'@'localhost';
GRANT SELECT ON vw_Mejores_Platos TO 'Caja'@'localhost';
GRANT SELECT ON vw_Tiempo_Barrios TO 'Caja'@'localhost';
GRANT SELECT ON vw_Mejores_Clientes TO 'Caja'@'localhost';


-- Mesero
GRANT SELECT, UPDATE ON Insumo TO 'Mesero'@'localhost';
GRANT SELECT ON Tipo TO 'Mesero'@'localhost';
GRANT SELECT ON Producto TO 'Mesero'@'localhost';
GRANT SELECT, UPDATE ON Domicilio TO 'Mesero'@'localhost';

GRANT SELECT ON vw_Carta TO 'Mesero'@'localhost';
GRANT SELECT ON vw_Hamburguesas TO 'Mesero'@'localhost';
GRANT SELECT ON vw_Perros TO 'Mesero'@'localhost';
GRANT SELECT ON vw_Carnes TO 'Mesero'@'localhost';
GRANT SELECT ON vw_Varios TO 'Mesero'@'localhost';
GRANT SELECT ON vw_Mazorcada TO 'Mesero'@'localhost';
GRANT SELECT ON vw_Salchipapa TO 'Mesero'@'localhost';
GRANT SELECT ON vw_Bebidas TO 'Mesero'@'localhost';
GRANT SELECT ON vw_Adiciones TO 'Mesero'@'localhost';
GRANT SELECT ON vw_Mejores_Platos TO 'Mesero'@'localhost';
 

#Usuarios en Perfiles
GRANT 'Gerencia'@'localhost' TO 'Venus'@'localhost';

GRANT 'Caja'@'localhost' TO 'Santiago'@'localhost';

GRANT 'Mesero'@'localhost' TO 'Manuel'@'localhost';

SET DEFAULT ROLE 'Gerencia'@'localhost' TO 'Venus'@'localhost';
SET DEFAULT ROLE 'Caja'@'localhost' TO 'Santiago'@'localhost';
SET DEFAULT ROLE 'Mesero'@'localhost' TO 'Manuel'@'localhost';

SET PERSIST activate_all_roles_on_login = ON;