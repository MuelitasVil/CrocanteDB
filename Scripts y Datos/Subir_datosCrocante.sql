use proyecto;

Show variables like "local_infile";

set global local_infile = "ON";

SHOW VARIABLES LIKE "secure_file_priv";

SET sql_mode = "";





-- ///////////////////////// Localidad ///////////////////////////////////////// 

LOAD DATA INFILE 

"C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\CSV\\Localidad.csv"

INTO TABLE Localidad

FIELDS TERMINATED BY ';'

enclosed by '"'

LINES TERMINATED BY '\n'

IGNORE 1 LINES;

select * from localidad;

-- ///////////////////////// Barrio ///////////////////////////////////////// 

LOAD DATA INFILE 

"C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\CSV\\Barrio.csv"

INTO TABLE Barrio

FIELDS TERMINATED BY ';'

enclosed by '"'

LINES TERMINATED BY '\n'

IGNORE 1 LINES;

select * from Barrio;

-- ///////////////////////// Sede ///////////////////////////////////////// 

LOAD DATA INFILE 

"C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\CSV\\Sede.csv"

INTO TABLE Sede

FIELDS TERMINATED BY ';'

enclosed by '"'

LINES TERMINATED BY '\n'

IGNORE 1 LINES;

select * from Sede;

-- ///////////////////////// Persona ///////////////////////////////////////// 

LOAD DATA INFILE 

"C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\CSV\\Persona.csv"

INTO TABLE Persona

FIELDS TERMINATED BY ';'

enclosed by '"'

LINES TERMINATED BY '\n'

IGNORE 1 LINES;

select * from persona;

-- ///////////////////////// Venta  ///////////////////////////////////////// 

LOAD DATA INFILE 

"C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\CSV\\Venta.csv"

INTO TABLE  Venta

FIELDS TERMINATED BY ';'

enclosed by '"'

LINES TERMINATED BY '\n'

IGNORE 1 LINES;

select * from venta;


-- ///////////////////////// Tipo  ///////////////////////////////////////// 

LOAD DATA INFILE 

"C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\CSV\\Tipo.csv"

INTO TABLE Tipo

FIELDS TERMINATED BY ';'

enclosed by '"'

LINES TERMINATED BY '\n'

IGNORE 1 LINES;

select * from Tipo;

-- ///////////////////////// Producto ///////////////////////////////////////// 

LOAD DATA INFILE 

"C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\CSV\\Producto.csv"

INTO TABLE Producto

FIELDS TERMINATED BY ';'

enclosed by '"'

LINES TERMINATED BY '\n'

IGNORE 1 LINES;

select * from Producto;


-- ///////////////////////// Pedido ///////////////////////////////////////// 

LOAD DATA INFILE 

"C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\CSV\\Pedido.csv"

INTO TABLE Pedido

FIELDS TERMINATED BY ';'

enclosed by '"'

LINES TERMINATED BY '\n'

IGNORE 1 LINES;

select * from Pedido;

-- ///////////////////////// Comentario ///////////////////////////////////////// 

LOAD DATA INFILE 

"C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\CSV\\Comentario.csv"

INTO TABLE Comentario

FIELDS TERMINATED BY ';'

enclosed by '"'

LINES TERMINATED BY '\n'

IGNORE 1 LINES;

select * from Comentario;

-- ///////////////////////// Calificacion ///////////////////////////////////////// 

LOAD DATA INFILE 

"C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\CSV\\Calificacion.csv"

INTO TABLE Calificación

FIELDS TERMINATED BY ';'

enclosed by '"'

LINES TERMINATED BY '\n'

IGNORE 1 LINES;

select * from Calificación;




-- ////////////cargo ////////////////

LOAD DATA INFILE 

"C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\CSV\\Cargo.csv"

INTO TABLE Cargo

FIELDS TERMINATED BY ';'

enclosed by '"'

LINES TERMINATED BY '\n'

IGNORE 1 LINES;

select * from Cargo;

-- ///////////////////////// Empleado ///////////////////////////////////////// 


LOAD DATA INFILE 

"C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\CSV\\Empleado.csv"

INTO TABLE Empleado

FIELDS TERMINATED BY ';'

enclosed by '"'

LINES TERMINATED BY '\n'

IGNORE 1 LINES;

select * from Empleado;

-- ///////////////////////// Domicilio ///////////////////////////////////////// 

LOAD DATA INFILE 

"C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\CSV\\Domicilio.csv"

INTO TABLE Domicilio

FIELDS TERMINATED BY ';'

enclosed by '"'

LINES TERMINATED BY '\n'

IGNORE 1 LINES;

select * from Domicilio;

-- ///////////////////////// Gasto ///////////////////////////////////////// 

LOAD DATA INFILE 

"C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\CSV\\Gasto.csv"

INTO TABLE Gasto

FIELDS TERMINATED BY ';'

enclosed by '"'

LINES TERMINATED BY '\n'

IGNORE 1 LINES;

select * from Gasto;

-- ///////////////////////// Insumo ///////////////////////////////////////// 

LOAD DATA INFILE 

"C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\CSV\\Insumo.csv"

INTO TABLE Insumo

FIELDS TERMINATED BY ';'

enclosed by '"'

LINES TERMINATED BY '\n'

IGNORE 1 LINES;

select * from Insumo;

-- ///////////////////////// Proveedor ///////////////////////////////////////// 

LOAD DATA INFILE 

"C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\CSV\\Proveedor.csv"

INTO TABLE  Proveedor 

FIELDS TERMINATED BY ';'

enclosed by '"'

LINES TERMINATED BY '\n'

IGNORE 1 LINES;

select * from Proveedor;

-- ///////////////////////// Salario ///////////////////////////////////////// 

LOAD DATA INFILE 

"C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\CSV\\Salario.csv"

INTO TABLE Salario

FIELDS TERMINATED BY ';'

enclosed by '"'

LINES TERMINATED BY '\n'

IGNORE 1 LINES;

select * from Salario;



-- ///////////////////////// InventarioProveedor ///////////////////////////////////////// 

LOAD DATA INFILE 

"C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\CSV\\InventarioProveedor.csv"

INTO TABLE InventarioProveedor

FIELDS TERMINATED BY ';'

enclosed by '"'

LINES TERMINATED BY '\n'

IGNORE 1 LINES;

select * from InventarioProveedor;



-- ///////////////////////// CompraAlProveedor ///////////////////////////////////////// 

LOAD DATA INFILE 

"C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\CSV\\CompraAlProveedor.csv"

INTO TABLE CompraAlProveedor 

FIELDS TERMINATED BY ';'

enclosed by '"'

LINES TERMINATED BY '\n'

IGNORE 1 LINES;

select * from CompraAlProveedor;

-- ///////////////////////// DetalleCompraInsumo ///////////////////////////////////////// 

LOAD DATA INFILE 

"C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\CSV\\DetalleCompraInsumo.csv"

INTO TABLE DetalleCompraInsumo

FIELDS TERMINATED BY ';'

enclosed by '"'

LINES TERMINATED BY '\n'

IGNORE 1 LINES;

select * from  DetalleCompraInsumo;




















